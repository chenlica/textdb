package edu.uci.ics.texera.workflow.common.operators.aggregate

import edu.uci.ics.texera.workflow.common.operators.OperatorDescriptor
import edu.uci.ics.texera.workflow.common.tuple.schema.Schema

abstract class AggregateOpDesc extends OperatorDescriptor {

  override def operatorExecutor(
      inputSchemas: Array[Schema],
      outputSchema: Schema
  ): AggregateOpExecConfig[_]

}
