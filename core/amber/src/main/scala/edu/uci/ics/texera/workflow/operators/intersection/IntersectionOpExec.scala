package edu.uci.ics.texera.workflow.operators.intersection

import com.google.common.base.Preconditions
import edu.uci.ics.amber.engine.common.InputExhausted
import edu.uci.ics.amber.engine.common.virtualidentity.LinkIdentity
import edu.uci.ics.texera.workflow.common.operators.OperatorExecutor
import edu.uci.ics.texera.workflow.common.tuple.Tuple

import scala.collection.convert.ImplicitConversions.`mutableSet AsJavaSet`
import scala.collection.mutable

class IntersectionOpExec extends OperatorExecutor {
  private val hashMap: mutable.HashMap[LinkIdentity, mutable.LinkedHashSet[Tuple]] =
    new mutable.HashMap()

  private var exhaustedCounter: Int = 0

  override def processTexeraTuple(
      tuple: Either[Tuple, InputExhausted],
      input: LinkIdentity
  ): Iterator[Tuple] = {
    tuple match {
      case Left(t) =>
        // for each input stream, initialize an empty set
        if (!hashMap.contains(input)) {
          hashMap.put(input, mutable.LinkedHashSet())
        }

        // should expect no more than 2 input streams, thus no more than 2 sets
        Preconditions.checkArgument(hashMap.size <= 2)

        // add the tuple to corresponding set
        hashMap(input) += t
        Iterator()

      case Right(_) =>
        // for empty input stream, initialize an empty set
        if (!hashMap.contains(input)) {
          hashMap.put(input, mutable.LinkedHashSet())
        }
        exhaustedCounter += 1
        if (exhaustedCounter == 2) {
          // both streams are exhausted, take the intersection and return the results

          hashMap.valuesIterator
            .reduce((set1, set2) => {
              print("set1.size: ", set1.size)
              print("set2 size: ", set2.size)
              set1.retainAll(set2); set1
            })
            .iterator
        } else {
          // only one of the stream is exhausted, continue accepting tuples
          Iterator()
        }

    }
  }

  override def open(): Unit = {}

  override def close(): Unit = {}
}