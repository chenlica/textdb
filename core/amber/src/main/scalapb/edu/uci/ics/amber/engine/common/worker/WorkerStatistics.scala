// Generated by the Scala Plugin for the Protocol Buffer Compiler.
// Do not edit!
//
// Protofile syntax: PROTO3

package edu.uci.ics.amber.engine.common.worker

@SerialVersionUID(0L)
final case class WorkerStatistics(
    workerState: edu.uci.ics.amber.engine.common.worker.WorkerState,
    inputRowCount: _root_.scala.Long,
    outputRowCount: _root_.scala.Long
    ) extends scalapb.GeneratedMessage with scalapb.lenses.Updatable[WorkerStatistics] {
    @transient
    private[this] var __serializedSizeCachedValue: _root_.scala.Int = 0
    private[this] def __computeSerializedValue(): _root_.scala.Int = {
      var __size = 0
      
      {
        val __value = workerState.value
        if (__value != 0) {
          __size += _root_.com.google.protobuf.CodedOutputStream.computeEnumSize(1, __value)
        }
      };
      
      {
        val __value = inputRowCount
        if (__value != 0L) {
          __size += _root_.com.google.protobuf.CodedOutputStream.computeInt64Size(2, __value)
        }
      };
      
      {
        val __value = outputRowCount
        if (__value != 0L) {
          __size += _root_.com.google.protobuf.CodedOutputStream.computeInt64Size(3, __value)
        }
      };
      __size
    }
    override def serializedSize: _root_.scala.Int = {
      var read = __serializedSizeCachedValue
      if (read == 0) {
        read = __computeSerializedValue()
        __serializedSizeCachedValue = read
      }
      read
    }
    def writeTo(`_output__`: _root_.com.google.protobuf.CodedOutputStream): _root_.scala.Unit = {
      {
        val __v = workerState.value
        if (__v != 0) {
          _output__.writeEnum(1, __v)
        }
      };
      {
        val __v = inputRowCount
        if (__v != 0L) {
          _output__.writeInt64(2, __v)
        }
      };
      {
        val __v = outputRowCount
        if (__v != 0L) {
          _output__.writeInt64(3, __v)
        }
      };
    }
    def withWorkerState(__v: edu.uci.ics.amber.engine.common.worker.WorkerState): WorkerStatistics = copy(workerState = __v)
    def withInputRowCount(__v: _root_.scala.Long): WorkerStatistics = copy(inputRowCount = __v)
    def withOutputRowCount(__v: _root_.scala.Long): WorkerStatistics = copy(outputRowCount = __v)
    def getFieldByNumber(__fieldNumber: _root_.scala.Int): _root_.scala.Any = {
      (__fieldNumber: @_root_.scala.unchecked) match {
        case 1 => {
          val __t = workerState.javaValueDescriptor
          if (__t.getNumber() != 0) __t else null
        }
        case 2 => {
          val __t = inputRowCount
          if (__t != 0L) __t else null
        }
        case 3 => {
          val __t = outputRowCount
          if (__t != 0L) __t else null
        }
      }
    }
    def getField(__field: _root_.scalapb.descriptors.FieldDescriptor): _root_.scalapb.descriptors.PValue = {
      _root_.scala.Predef.require(__field.containingMessage eq companion.scalaDescriptor)
      (__field.number: @_root_.scala.unchecked) match {
        case 1 => _root_.scalapb.descriptors.PEnum(workerState.scalaValueDescriptor)
        case 2 => _root_.scalapb.descriptors.PLong(inputRowCount)
        case 3 => _root_.scalapb.descriptors.PLong(outputRowCount)
      }
    }
    def toProtoString: _root_.scala.Predef.String = _root_.scalapb.TextFormat.printToSingleLineUnicodeString(this)
    def companion = edu.uci.ics.amber.engine.common.worker.WorkerStatistics
    // @@protoc_insertion_point(GeneratedMessage[edu.uci.ics.amber.engine.common.WorkerStatistics])
}

object WorkerStatistics extends scalapb.GeneratedMessageCompanion[edu.uci.ics.amber.engine.common.worker.WorkerStatistics] {
  implicit def messageCompanion: scalapb.GeneratedMessageCompanion[edu.uci.ics.amber.engine.common.worker.WorkerStatistics] = this
  def parseFrom(`_input__`: _root_.com.google.protobuf.CodedInputStream): edu.uci.ics.amber.engine.common.worker.WorkerStatistics = {
    var __workerState: edu.uci.ics.amber.engine.common.worker.WorkerState = edu.uci.ics.amber.engine.common.worker.WorkerState.Uninitialized
    var __inputRowCount: _root_.scala.Long = 0L
    var __outputRowCount: _root_.scala.Long = 0L
    var _done__ = false
    while (!_done__) {
      val _tag__ = _input__.readTag()
      _tag__ match {
        case 0 => _done__ = true
        case 8 =>
          __workerState = edu.uci.ics.amber.engine.common.worker.WorkerState.fromValue(_input__.readEnum())
        case 16 =>
          __inputRowCount = _input__.readInt64()
        case 24 =>
          __outputRowCount = _input__.readInt64()
        case tag => _input__.skipField(tag)
      }
    }
    edu.uci.ics.amber.engine.common.worker.WorkerStatistics(
        workerState = __workerState,
        inputRowCount = __inputRowCount,
        outputRowCount = __outputRowCount
    )
  }
  implicit def messageReads: _root_.scalapb.descriptors.Reads[edu.uci.ics.amber.engine.common.worker.WorkerStatistics] = _root_.scalapb.descriptors.Reads{
    case _root_.scalapb.descriptors.PMessage(__fieldsMap) =>
      _root_.scala.Predef.require(__fieldsMap.keys.forall(_.containingMessage eq scalaDescriptor), "FieldDescriptor does not match message type.")
      edu.uci.ics.amber.engine.common.worker.WorkerStatistics(
        workerState = edu.uci.ics.amber.engine.common.worker.WorkerState.fromValue(__fieldsMap.get(scalaDescriptor.findFieldByNumber(1).get).map(_.as[_root_.scalapb.descriptors.EnumValueDescriptor]).getOrElse(edu.uci.ics.amber.engine.common.worker.WorkerState.Uninitialized.scalaValueDescriptor).number),
        inputRowCount = __fieldsMap.get(scalaDescriptor.findFieldByNumber(2).get).map(_.as[_root_.scala.Long]).getOrElse(0L),
        outputRowCount = __fieldsMap.get(scalaDescriptor.findFieldByNumber(3).get).map(_.as[_root_.scala.Long]).getOrElse(0L)
      )
    case _ => throw new RuntimeException("Expected PMessage")
  }
  def javaDescriptor: _root_.com.google.protobuf.Descriptors.Descriptor = WorkerProto.javaDescriptor.getMessageTypes().get(0)
  def scalaDescriptor: _root_.scalapb.descriptors.Descriptor = WorkerProto.scalaDescriptor.messages(0)
  def messageCompanionForFieldNumber(__number: _root_.scala.Int): _root_.scalapb.GeneratedMessageCompanion[_] = throw new MatchError(__number)
  lazy val nestedMessagesCompanions: Seq[_root_.scalapb.GeneratedMessageCompanion[_ <: _root_.scalapb.GeneratedMessage]] = Seq.empty
  def enumCompanionForFieldNumber(__fieldNumber: _root_.scala.Int): _root_.scalapb.GeneratedEnumCompanion[_] = {
    (__fieldNumber: @_root_.scala.unchecked) match {
      case 1 => edu.uci.ics.amber.engine.common.worker.WorkerState
    }
  }
  lazy val defaultInstance = edu.uci.ics.amber.engine.common.worker.WorkerStatistics(
    workerState = edu.uci.ics.amber.engine.common.worker.WorkerState.Uninitialized,
    inputRowCount = 0L,
    outputRowCount = 0L
  )
  implicit class WorkerStatisticsLens[UpperPB](_l: _root_.scalapb.lenses.Lens[UpperPB, edu.uci.ics.amber.engine.common.worker.WorkerStatistics]) extends _root_.scalapb.lenses.ObjectLens[UpperPB, edu.uci.ics.amber.engine.common.worker.WorkerStatistics](_l) {
    def workerState: _root_.scalapb.lenses.Lens[UpperPB, edu.uci.ics.amber.engine.common.worker.WorkerState] = field(_.workerState)((c_, f_) => c_.copy(workerState = f_))
    def inputRowCount: _root_.scalapb.lenses.Lens[UpperPB, _root_.scala.Long] = field(_.inputRowCount)((c_, f_) => c_.copy(inputRowCount = f_))
    def outputRowCount: _root_.scalapb.lenses.Lens[UpperPB, _root_.scala.Long] = field(_.outputRowCount)((c_, f_) => c_.copy(outputRowCount = f_))
  }
  final val WORKERSTATE_FIELD_NUMBER = 1
  final val INPUTROWCOUNT_FIELD_NUMBER = 2
  final val OUTPUTROWCOUNT_FIELD_NUMBER = 3
  def of(
    workerState: edu.uci.ics.amber.engine.common.worker.WorkerState,
    inputRowCount: _root_.scala.Long,
    outputRowCount: _root_.scala.Long
  ): _root_.edu.uci.ics.amber.engine.common.worker.WorkerStatistics = _root_.edu.uci.ics.amber.engine.common.worker.WorkerStatistics(
    workerState,
    inputRowCount,
    outputRowCount
  )
  // @@protoc_insertion_point(GeneratedMessageCompanion[edu.uci.ics.amber.engine.common.WorkerStatistics])
}
