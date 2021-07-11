package edu.uci.ics.texera.workflow.common.workflow

import edu.uci.ics.texera.workflow.common.operators.OperatorDescriptor
import edu.uci.ics.texera.workflow.common.tuple.Tuple
import edu.uci.ics.texera.workflow.common.tuple.schema.Schema
import edu.uci.ics.texera.workflow.operators.sink.{CacheSinkOpDesc, SimpleSinkOpDesc}
import edu.uci.ics.texera.workflow.operators.source.cache.CacheSourceOpDesc
import edu.uci.ics.texera.workflow.operators.source.scan.csv.CSVScanSourceOpDesc
import org.scalatest.BeforeAndAfter
import org.scalatest.flatspec.AnyFlatSpec

import scala.collection.mutable

class WorkflowRewriterSpec extends AnyFlatSpec with BeforeAndAfter {
  var rewriter: WorkflowRewriter = _

  it should "return null" in {
    rewriter = new WorkflowRewriter(null, null, null, null, null)
    assert(rewriter.rewrite == null)
  }

  it should "return empty workflowInfo" in {
    val workflowInfo: WorkflowInfo = new WorkflowInfo(
      mutable.MutableList[OperatorDescriptor](),
      mutable.MutableList[OperatorLink](),
      mutable.MutableList[BreakpointInfo]()
    )
    rewriter = new WorkflowRewriter(workflowInfo, null, null, null, null)
    assert(rewriter.rewrite.equals(workflowInfo))
  }

  it should "modify no operator" in {
    val operators = mutable.MutableList[OperatorDescriptor]()
    val links = mutable.MutableList[OperatorLink]()
    val breakpoints = mutable.MutableList[BreakpointInfo]()
    val sourceOperator = new CSVScanSourceOpDesc()
    val sinkOperator = new SimpleSinkOpDesc()
    operators += sourceOperator
    operators += sinkOperator
    val origin = OperatorPort(sourceOperator.operatorID, 0)
    val destination = OperatorPort(sinkOperator.operatorID, 0)
    links += OperatorLink(origin, destination)
    val workflowInfo = WorkflowInfo(operators, links, breakpoints)
    workflowInfo.cachedOperatorIDs = mutable.MutableList[String]()
    rewriter = new WorkflowRewriter(
      workflowInfo,
      mutable.HashMap[String, mutable.MutableList[Tuple]](),
      mutable.HashMap[String, OperatorDescriptor](),
      mutable.HashMap[String, CacheSourceOpDesc](),
      mutable.HashMap[String, CacheSinkOpDesc]()
    )
    val rewrittenWorkflowInfo = rewriter.rewrite
    rewrittenWorkflowInfo.operators.foreach(operator => {
      assert(operators.contains(operator))
    })
  }

  it should "replace source with cache" in {
    val operators = mutable.MutableList[OperatorDescriptor]()
    val links = mutable.MutableList[OperatorLink]()
    val breakpoints = mutable.MutableList[BreakpointInfo]()
    val sourceOperator = new CSVScanSourceOpDesc()
    val sinkOperator = new SimpleSinkOpDesc()
    operators += sourceOperator
    operators += sinkOperator

    val origin = OperatorPort(sourceOperator.operatorID, 0)
    val destination = OperatorPort(sinkOperator.operatorID, 0)
    links += OperatorLink(origin, destination)

    val workflowInfo = WorkflowInfo(operators, links, breakpoints)
    workflowInfo.cachedOperatorIDs = mutable.MutableList(sourceOperator.operatorID)

    val tuples = mutable.MutableList[Tuple]()
    val cacheSourceOperator = new CacheSourceOpDesc(tuples)
    val cacheSinkOperator = new CacheSinkOpDesc(tuples)
    val operatorOutputCache = mutable.HashMap[String, mutable.MutableList[Tuple]]()
    cacheSinkOperator.schema = new Schema()
    operatorOutputCache += ((sourceOperator.operatorID, tuples))
    val cachedOperators = mutable.HashMap[String, OperatorDescriptor]()
    cachedOperators += ((sourceOperator.operatorID, sourceOperator))
    val cacheSourceOperators = mutable.HashMap[String, CacheSourceOpDesc]()
    cacheSourceOperators += ((sourceOperator.operatorID, cacheSourceOperator))
    val cacheSinkOperators = mutable.HashMap[String, CacheSinkOpDesc]()
    cacheSinkOperators += ((sourceOperator.operatorID, cacheSinkOperator))

    rewriter = new WorkflowRewriter(
      workflowInfo,
      operatorOutputCache,
      cachedOperators,
      cacheSourceOperators,
      cacheSinkOperators
    )

    val rewrittenWorkflowInfo = rewriter.rewrite
    assert(2.equals(rewrittenWorkflowInfo.operators.size))
    assert(rewrittenWorkflowInfo.operators.contains(cacheSourceOperator))
    assert(rewrittenWorkflowInfo.operators.contains(sinkOperator))
    assert(1.equals(rewrittenWorkflowInfo.links.size))
  }

  it should "add a CacheSinkOpDesc" in {
    val operators = mutable.MutableList[OperatorDescriptor]()
    val links = mutable.MutableList[OperatorLink]()
    val breakpoints = mutable.MutableList[BreakpointInfo]()
    val sourceOperator = new CSVScanSourceOpDesc()
    val sinkOperator = new SimpleSinkOpDesc()
    operators += sourceOperator
    operators += sinkOperator

    val origin = OperatorPort(sourceOperator.operatorID, 0)
    val destination = OperatorPort(sinkOperator.operatorID, 0)
    links += OperatorLink(origin, destination)

    val workflowInfo = WorkflowInfo(operators, links, breakpoints)
    workflowInfo.cachedOperatorIDs = mutable.MutableList(sourceOperator.operatorID)

    val operatorOutputCache = mutable.HashMap[String, mutable.MutableList[Tuple]]()
    val cachedOperators = mutable.HashMap[String, OperatorDescriptor]()
    val cacheSourceOperators = mutable.HashMap[String, CacheSourceOpDesc]()
    val cacheSinkOperators = mutable.HashMap[String, CacheSinkOpDesc]()

    rewriter = new WorkflowRewriter(
      workflowInfo,
      operatorOutputCache,
      cachedOperators,
      cacheSourceOperators,
      cacheSinkOperators
    )

    val rewrittenWorkflowInfo = rewriter.rewrite
    assert(3.equals(rewrittenWorkflowInfo.operators.size))
    assert(rewrittenWorkflowInfo.operators.contains(sourceOperator))
    assert(rewrittenWorkflowInfo.operators(1).isInstanceOf[CacheSinkOpDesc])
    assert(rewrittenWorkflowInfo.operators.contains(sinkOperator))
    assert(2.equals(rewrittenWorkflowInfo.links.size))
  }

  it should "add correct numbers of operators and links" in {
    val operators = mutable.MutableList[OperatorDescriptor]()
    val links = mutable.MutableList[OperatorLink]()
    val breakpoints = mutable.MutableList[BreakpointInfo]()
    val sourceOperator = new CSVScanSourceOpDesc()
    val sinkOperator = new SimpleSinkOpDesc()
    val sinkOperator2 = new SimpleSinkOpDesc()
    operators += sourceOperator
    operators += sinkOperator
    operators += sinkOperator2

    val origin = OperatorPort(sourceOperator.operatorID, 0)
    val destination = OperatorPort(sinkOperator.operatorID, 0)
    links += OperatorLink(origin, destination)

    val destination2 = OperatorPort(sinkOperator2.operatorID, 0)
    links += OperatorLink(origin, destination2)

    val workflowInfo = WorkflowInfo(operators, links, breakpoints)
    workflowInfo.cachedOperatorIDs = mutable.MutableList(sourceOperator.operatorID)

    val operatorOutputCache = mutable.HashMap[String, mutable.MutableList[Tuple]]()
    val cachedOperators = mutable.HashMap[String, OperatorDescriptor]()
    val cacheSourceOperators = mutable.HashMap[String, CacheSourceOpDesc]()
    val cacheSinkOperators = mutable.HashMap[String, CacheSinkOpDesc]()

    rewriter = new WorkflowRewriter(
      workflowInfo,
      operatorOutputCache,
      cachedOperators,
      cacheSourceOperators,
      cacheSinkOperators
    )

    val rewrittenWorkflowInfo = rewriter.rewrite
    assert(4.equals(rewrittenWorkflowInfo.operators.size))
    assert(rewrittenWorkflowInfo.operators.contains(sourceOperator))
    assert(rewrittenWorkflowInfo.operators(2).isInstanceOf[CacheSinkOpDesc])
    assert(rewrittenWorkflowInfo.operators.contains(sinkOperator))
    assert(3.equals(rewrittenWorkflowInfo.links.size))
  }
}
