package edu.uci.ics.amber.engine.architecture.common

import akka.actor.{Actor, ActorLogging, ActorRef, Stash}
import com.softwaremill.macwire.wire
import com.typesafe.scalalogging.LazyLogging
import edu.uci.ics.amber.engine.architecture.messaginglayer.ControlInputPort.WorkflowControlMessage
import edu.uci.ics.amber.engine.architecture.messaginglayer.NetworkCommunicationActor.{
  GetActorRef,
  NetworkAck,
  NetworkMessage,
  NetworkSenderActorRef,
  RegisterActorRef
}
import edu.uci.ics.amber.engine.architecture.messaginglayer.{
  ControlInputPort,
  ControlOutputPort,
  NetworkCommunicationActor
}
import edu.uci.ics.amber.engine.common.WorkflowLogger
import edu.uci.ics.amber.engine.common.rpc.{
  AsyncRPCClient,
  AsyncRPCHandlerInitializer,
  AsyncRPCServer
}
import edu.uci.ics.amber.engine.common.virtualidentity.ActorVirtualIdentity
import edu.uci.ics.amber.error.WorkflowRuntimeError

abstract class WorkflowActor(
    val identifier: ActorVirtualIdentity,
    parentNetworkCommunicationActorRef: ActorRef
) extends Actor
    with Stash {

  protected val logger: WorkflowLogger = WorkflowLogger(s"$identifier")

//  For now, just log it to the console
//  TODO: enable throwing of the exception when all control messages have been handled properly
//  logger.setErrorLogAction(err => {
//    throw new WorkflowRuntimeException(err)
//  })

  val networkCommunicationActor: NetworkSenderActorRef = NetworkSenderActorRef(
    context.actorOf(NetworkCommunicationActor.props(parentNetworkCommunicationActorRef))
  )
  lazy val controlInputPort: ControlInputPort = wire[ControlInputPort]
  lazy val controlOutputPort: ControlOutputPort = wire[ControlOutputPort]
  lazy val asyncRPCClient: AsyncRPCClient = wire[AsyncRPCClient]
  lazy val asyncRPCServer: AsyncRPCServer = wire[AsyncRPCServer]
  // this variable cannot be lazy
  // because it should be initialized with the actor itself
  val rpcHandlerInitializer: AsyncRPCHandlerInitializer

  def disallowActorRefRelatedMessages: Receive = {
    case GetActorRef(id, replyTo) =>
      logger.logError(
        WorkflowRuntimeError(
          "workflow actor should never receive get actor ref message",
          identifier.toString,
          Map.empty
        )
      )
    case RegisterActorRef(id, ref) =>
      logger.logError(
        WorkflowRuntimeError(
          "workflow actor should never receive register actor ref message",
          identifier.toString,
          Map.empty
        )
      )
  }

  def processControlMessages: Receive = {
    case msg @ NetworkMessage(id, cmd: WorkflowControlMessage) =>
      sender ! NetworkAck(id)
      // use control input port to pass control messages
      controlInputPort.handleControlMessage(cmd)
  }
}
