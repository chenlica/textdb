package edu.uci.ics.texera.workflow.operators.projection

import com.google.common.base.Preconditions
import edu.uci.ics.texera.workflow.common.operators.map.MapOpExec
import edu.uci.ics.texera.workflow.common.tuple.Tuple
import edu.uci.ics.texera.workflow.common.tuple.schema.OperatorSchemaInfo

class ProjectionOpExec(var attributes: List[String], val schemaInfo: OperatorSchemaInfo)
    extends MapOpExec {

  def project(tuple: Tuple): Tuple = {
    Preconditions.checkArgument(attributes.nonEmpty)
    val builder = Tuple.newBuilder(schemaInfo.outputSchema)

    attributes.foreach(attrName => {
      builder.add(
        attrName,
        tuple.getSchema.getAttribute(attrName).getType,
        tuple.getField(attrName)
      )
    })
    builder.build()
  }

  setMapFunc(project)
}
