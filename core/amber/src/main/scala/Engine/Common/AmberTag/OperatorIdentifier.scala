package Engine.Common.AmberTag

case class OperatorIdentifier(workflow: String, operator: String) extends AmberTag {
  override def getGlobalIdentity: String = workflow + "-" + operator
}

object OperatorIdentifier {
  def apply(workflowTag: WorkflowTag, operator: String): OperatorIdentifier = {
    OperatorIdentifier(workflowTag.workflow, operator)
  }
}
