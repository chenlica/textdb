package edu.uci.ics.texera.workflow.operators.hashJoin

import edu.uci.ics.amber.engine.common.InputExhausted
import edu.uci.ics.amber.engine.common.amberexception.WorkflowRuntimeException
import edu.uci.ics.amber.engine.common.virtualidentity.LinkIdentity
import edu.uci.ics.amber.error.WorkflowRuntimeError
import edu.uci.ics.texera.workflow.common.operators.OperatorExecutor
import edu.uci.ics.texera.workflow.common.tuple.Tuple
import edu.uci.ics.texera.workflow.common.tuple.schema.{OperatorSchemaInfo, Schema}

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

class HashJoinOpExec[K](
    val buildTable: LinkIdentity,
    val buildAttributeName: String,
    val probeAttributeName: String,
    val operatorSchemaInfo: OperatorSchemaInfo
) extends OperatorExecutor {

  var isBuildTableFinished: Boolean = false
  var buildTableHashMap: mutable.HashMap[K, ArrayBuffer[Tuple]] = _
  var outputProbeSchema: Schema = operatorSchemaInfo.outputSchema

  var currentEntry: Iterator[Tuple] = _
  var currentTuple: Tuple = _

  override def processTexeraTuple(
      tuple: Either[Tuple, InputExhausted],
      input: LinkIdentity
  ): Iterator[Tuple] = {
    tuple match {
      case Left(t) =>
        // The operatorInfo() in HashJoinOpDesc has a inputPorts list. In that the
        // small input port comes first. So, it is assigned the inputNum 0. Similarly
        // the large input is assigned the inputNum 1.
        if (input == buildTable) {
          val key = t.getField(buildAttributeName).asInstanceOf[K]
          val storedTuples = buildTableHashMap.getOrElse(key, new ArrayBuffer[Tuple]())
          storedTuples += t
          buildTableHashMap.put(key, storedTuples)
          Iterator()
        } else {
          if (!isBuildTableFinished) {
            val err = WorkflowRuntimeError(
              "Probe table came before build table ended",
              "HashJoinOpExec",
              Map("stacktrace" -> Thread.currentThread().getStackTrace.mkString("\n"))
            )
            throw new WorkflowRuntimeException(err)
          } else {
            val key = t.getField(probeAttributeName).asInstanceOf[K]
            val storedTuples = buildTableHashMap.getOrElse(key, new ArrayBuffer[Tuple]())
            val tuplesToOutput: ArrayBuffer[Tuple] = new ArrayBuffer[Tuple]()
            if (storedTuples.isEmpty) {
              Iterator()
            }

            storedTuples.foreach(buildTuple => {
              val builder = Tuple
                .newBuilder(operatorSchemaInfo.outputSchema)
                .add(buildTuple)

              var newProbeIdx = 0
              // outputProbeSchema doesnt have "probeAttribute" but t does. The following code
              //  takes that into consideration while creating a tuple.
              for (i <- 0 until t.getFields.size()) {
                if (!t.getSchema.getAttributeNames.get(i).equals(probeAttributeName)) {
                  builder.add(
                    outputProbeSchema.getAttributes.get(newProbeIdx),
                    t.getFields.get(i)
                  )
                  newProbeIdx += 1
                }
              }

              tuplesToOutput += builder.build()
            })
            tuplesToOutput.iterator
          }
        }
      case Right(_) =>
        if (input == buildTable) {
          isBuildTableFinished = true
        }
        Iterator()

    }
  }

  override def open(): Unit = {
    buildTableHashMap = new mutable.HashMap[K, mutable.ArrayBuffer[Tuple]]()
  }

  override def close(): Unit = {
    buildTableHashMap.clear()
  }
}
