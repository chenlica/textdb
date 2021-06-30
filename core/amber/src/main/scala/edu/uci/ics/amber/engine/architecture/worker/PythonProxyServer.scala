package edu.uci.ics.amber.engine.architecture.worker

import edu.uci.ics.amber.engine.architecture.messaginglayer.ControlOutputPort
import edu.uci.ics.amber.engine.common.ambermessage2.WorkflowControlMessage
import edu.uci.ics.amber.engine.common.rpc.AsyncRPCClient.ReturnPayload
import edu.uci.ics.amber.engine.common.rpc.AsyncRPCServer.CommandCompleted
import kotlin.NotImplementedError
import org.apache.arrow.flight._
import org.apache.arrow.flight.example.InMemoryStore
import org.apache.arrow.memory.{BufferAllocator, RootAllocator}
import org.apache.arrow.util.AutoCloseables


private class AmberProducer(allocator: BufferAllocator, location: Location, controlOutputPort: ControlOutputPort)
    extends InMemoryStore(allocator, location) {

  override def doAction(context: FlightProducer.CallContext, action: Action, listener: FlightProducer.StreamListener[Result]): Unit = {
    action.getType match {
      case "control" =>
        val workflowControlMessage = WorkflowControlMessage.parseFrom(action.getBody)
        println("JAVA received CONTROL from PYTHON " + workflowControlMessage)

        var returnValue1: Any = null
        workflowControlMessage.payload match {
          case returnPayloadV2: edu.uci.ics.amber.engine.common.ambermessage2.ReturnPayload => {
            if (returnPayloadV2.returnValue.isDefined) {
              returnPayloadV2.returnValue match {
                case workerStatistics: edu.uci.ics.amber.engine.architecture.worker.promisehandler2.WorkerStatistics => {
                  println(" this is statistics:::" + workerStatistics)
                  returnValue1 = WorkerStatistics(workerStatistics.workerState, workerStatistics.inputRowCount, workerStatistics.outputRowCount)
                }
              }
            }
          }
          case _ => returnValue1 = CommandCompleted()
        }
        controlOutputPort.sendTo(to = workflowControlMessage.from, payload = ReturnPayload(
          originalCommandID = workflowControlMessage.payload.asMessage.getReturnPayload.originalCommandID
          , returnValue = returnValue1))
        listener.onNext(new Result("ack".getBytes))
        listener.onCompleted()
      case _ => throw new NotImplementedError()
    }


  }
}

class PythonProxyServer(portNumber: Int, controlOutputPort: ControlOutputPort) extends Runnable with AutoCloseable {

  val allocator: BufferAllocator =
    new RootAllocator().newChildAllocator("flight-server", 0, Long.MaxValue);
  val location: Location = Location.forGrpcInsecure("localhost", portNumber)
  val mem: InMemoryStore = new AmberProducer(allocator, location, controlOutputPort)
  val server: FlightServer = FlightServer.builder(allocator, location, mem).build()


  override def run(): Unit = {
    server.start()
  }

  @throws[Exception]
  override def close(): Unit = {
    AutoCloseables.close(mem, server, allocator)
  }
}
