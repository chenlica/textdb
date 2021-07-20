// Generated by the Scala Plugin for the Protocol Buffer Compiler.
// Do not edit!
//
// Protofile syntax: PROTO3

package edu.uci.ics.amber.engine.architecture.worker.controlreturns

@SerialVersionUID(0L)
final case class ControlReturn(
    value: edu.uci.ics.amber.engine.architecture.worker.controlreturns.ControlReturn.Value
    ) extends scalapb.GeneratedMessage with scalapb.lenses.Updatable[ControlReturn] {
    @transient
    private[this] var __serializedSizeCachedValue: _root_.scala.Int = 0
    private[this] def __computeSerializedValue(): _root_.scala.Int = {
      var __size = 0
      if (value.workerStatistics.isDefined) {
        val __value = value.workerStatistics.get
        __size += 1 + _root_.com.google.protobuf.CodedOutputStream.computeUInt32SizeNoTag(__value.serializedSize) + __value.serializedSize
      };
      if (value.workerState.isDefined) {
        val __value = value.workerState.get.value
        __size += _root_.com.google.protobuf.CodedOutputStream.computeEnumSize(2, __value)
      };
      if (value.queryStatistics.isDefined) {
        val __value = value.queryStatistics.get
        __size += 1 + _root_.com.google.protobuf.CodedOutputStream.computeUInt32SizeNoTag(__value.serializedSize) + __value.serializedSize
      };
      if (value.pythonPrint.isDefined) {
        val __value = value.pythonPrint.get
        __size += 2 + _root_.com.google.protobuf.CodedOutputStream.computeUInt32SizeNoTag(__value.serializedSize) + __value.serializedSize
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
      value.workerStatistics.foreach { __v =>
        val __m = __v
        _output__.writeTag(1, 2)
        _output__.writeUInt32NoTag(__m.serializedSize)
        __m.writeTo(_output__)
      };
      value.workerState.foreach { __v =>
        val __m = __v.value
        _output__.writeEnum(2, __m)
      };
      value.queryStatistics.foreach { __v =>
        val __m = __v
        _output__.writeTag(3, 2)
        _output__.writeUInt32NoTag(__m.serializedSize)
        __m.writeTo(_output__)
      };
      value.pythonPrint.foreach { __v =>
        val __m = __v
        _output__.writeTag(201, 2)
        _output__.writeUInt32NoTag(__m.serializedSize)
        __m.writeTo(_output__)
      };
    }
    def getWorkerStatistics: edu.uci.ics.amber.engine.common.worker.WorkerStatistics = value.workerStatistics.getOrElse(edu.uci.ics.amber.engine.common.worker.WorkerStatistics.defaultInstance)
    def withWorkerStatistics(__v: edu.uci.ics.amber.engine.common.worker.WorkerStatistics): ControlReturn = copy(value = edu.uci.ics.amber.engine.architecture.worker.controlreturns.ControlReturn.Value.WorkerStatistics(__v))
    def getWorkerState: edu.uci.ics.amber.engine.common.worker.WorkerState = value.workerState.getOrElse(edu.uci.ics.amber.engine.common.worker.WorkerState.Uninitialized)
    def withWorkerState(__v: edu.uci.ics.amber.engine.common.worker.WorkerState): ControlReturn = copy(value = edu.uci.ics.amber.engine.architecture.worker.controlreturns.ControlReturn.Value.WorkerState(__v))
    def getQueryStatistics: edu.uci.ics.amber.engine.architecture.worker.controlreturns.QueryStatistics = value.queryStatistics.getOrElse(edu.uci.ics.amber.engine.architecture.worker.controlreturns.QueryStatistics.defaultInstance)
    def withQueryStatistics(__v: edu.uci.ics.amber.engine.architecture.worker.controlreturns.QueryStatistics): ControlReturn = copy(value = edu.uci.ics.amber.engine.architecture.worker.controlreturns.ControlReturn.Value.QueryStatistics(__v))
    def getPythonPrint: edu.uci.ics.amber.engine.architecture.worker.controlreturns.PythonPrint = value.pythonPrint.getOrElse(edu.uci.ics.amber.engine.architecture.worker.controlreturns.PythonPrint.defaultInstance)
    def withPythonPrint(__v: edu.uci.ics.amber.engine.architecture.worker.controlreturns.PythonPrint): ControlReturn = copy(value = edu.uci.ics.amber.engine.architecture.worker.controlreturns.ControlReturn.Value.PythonPrint(__v))
    def clearValue: ControlReturn = copy(value = edu.uci.ics.amber.engine.architecture.worker.controlreturns.ControlReturn.Value.Empty)
    def withValue(__v: edu.uci.ics.amber.engine.architecture.worker.controlreturns.ControlReturn.Value): ControlReturn = copy(value = __v)
    def getFieldByNumber(__fieldNumber: _root_.scala.Int): _root_.scala.Any = {
      (__fieldNumber: @_root_.scala.unchecked) match {
        case 1 => value.workerStatistics.orNull
        case 2 => value.workerState.map(_.javaValueDescriptor).orNull
        case 3 => value.queryStatistics.orNull
        case 201 => value.pythonPrint.orNull
      }
    }
    def getField(__field: _root_.scalapb.descriptors.FieldDescriptor): _root_.scalapb.descriptors.PValue = {
      _root_.scala.Predef.require(__field.containingMessage eq companion.scalaDescriptor)
      (__field.number: @_root_.scala.unchecked) match {
        case 1 => value.workerStatistics.map(_.toPMessage).getOrElse(_root_.scalapb.descriptors.PEmpty)
        case 2 => value.workerState.map(__e => _root_.scalapb.descriptors.PEnum(__e.scalaValueDescriptor)).getOrElse(_root_.scalapb.descriptors.PEmpty)
        case 3 => value.queryStatistics.map(_.toPMessage).getOrElse(_root_.scalapb.descriptors.PEmpty)
        case 201 => value.pythonPrint.map(_.toPMessage).getOrElse(_root_.scalapb.descriptors.PEmpty)
      }
    }
    def toProtoString: _root_.scala.Predef.String = _root_.scalapb.TextFormat.printToSingleLineUnicodeString(this)
    def companion = edu.uci.ics.amber.engine.architecture.worker.controlreturns.ControlReturn
    // @@protoc_insertion_point(GeneratedMessage[edu.uci.ics.amber.engine.architecture.worker.ControlReturn])
}

object ControlReturn extends scalapb.GeneratedMessageCompanion[edu.uci.ics.amber.engine.architecture.worker.controlreturns.ControlReturn] {
  implicit def messageCompanion: scalapb.GeneratedMessageCompanion[edu.uci.ics.amber.engine.architecture.worker.controlreturns.ControlReturn] = this
  def parseFrom(`_input__`: _root_.com.google.protobuf.CodedInputStream): edu.uci.ics.amber.engine.architecture.worker.controlreturns.ControlReturn = {
    var __value: edu.uci.ics.amber.engine.architecture.worker.controlreturns.ControlReturn.Value = edu.uci.ics.amber.engine.architecture.worker.controlreturns.ControlReturn.Value.Empty
    var _done__ = false
    while (!_done__) {
      val _tag__ = _input__.readTag()
      _tag__ match {
        case 0 => _done__ = true
        case 10 =>
          __value = edu.uci.ics.amber.engine.architecture.worker.controlreturns.ControlReturn.Value.WorkerStatistics(__value.workerStatistics.fold(_root_.scalapb.LiteParser.readMessage[edu.uci.ics.amber.engine.common.worker.WorkerStatistics](_input__))(_root_.scalapb.LiteParser.readMessage(_input__, _)))
        case 16 =>
          __value = edu.uci.ics.amber.engine.architecture.worker.controlreturns.ControlReturn.Value.WorkerState(edu.uci.ics.amber.engine.common.worker.WorkerState.fromValue(_input__.readEnum()))
        case 26 =>
          __value = edu.uci.ics.amber.engine.architecture.worker.controlreturns.ControlReturn.Value.QueryStatistics(__value.queryStatistics.fold(_root_.scalapb.LiteParser.readMessage[edu.uci.ics.amber.engine.architecture.worker.controlreturns.QueryStatistics](_input__))(_root_.scalapb.LiteParser.readMessage(_input__, _)))
        case 1610 =>
          __value = edu.uci.ics.amber.engine.architecture.worker.controlreturns.ControlReturn.Value.PythonPrint(__value.pythonPrint.fold(_root_.scalapb.LiteParser.readMessage[edu.uci.ics.amber.engine.architecture.worker.controlreturns.PythonPrint](_input__))(_root_.scalapb.LiteParser.readMessage(_input__, _)))
        case tag => _input__.skipField(tag)
      }
    }
    edu.uci.ics.amber.engine.architecture.worker.controlreturns.ControlReturn(
        value = __value
    )
  }
  implicit def messageReads: _root_.scalapb.descriptors.Reads[edu.uci.ics.amber.engine.architecture.worker.controlreturns.ControlReturn] = _root_.scalapb.descriptors.Reads{
    case _root_.scalapb.descriptors.PMessage(__fieldsMap) =>
      _root_.scala.Predef.require(__fieldsMap.keys.forall(_.containingMessage eq scalaDescriptor), "FieldDescriptor does not match message type.")
      edu.uci.ics.amber.engine.architecture.worker.controlreturns.ControlReturn(
        value = __fieldsMap.get(scalaDescriptor.findFieldByNumber(1).get).flatMap(_.as[_root_.scala.Option[edu.uci.ics.amber.engine.common.worker.WorkerStatistics]]).map(edu.uci.ics.amber.engine.architecture.worker.controlreturns.ControlReturn.Value.WorkerStatistics(_))
            .orElse[edu.uci.ics.amber.engine.architecture.worker.controlreturns.ControlReturn.Value](__fieldsMap.get(scalaDescriptor.findFieldByNumber(2).get).flatMap(_.as[_root_.scala.Option[_root_.scalapb.descriptors.EnumValueDescriptor]]).map(__e => edu.uci.ics.amber.engine.architecture.worker.controlreturns.ControlReturn.Value.WorkerState(edu.uci.ics.amber.engine.common.worker.WorkerState.fromValue(__e.number))))
            .orElse[edu.uci.ics.amber.engine.architecture.worker.controlreturns.ControlReturn.Value](__fieldsMap.get(scalaDescriptor.findFieldByNumber(3).get).flatMap(_.as[_root_.scala.Option[edu.uci.ics.amber.engine.architecture.worker.controlreturns.QueryStatistics]]).map(edu.uci.ics.amber.engine.architecture.worker.controlreturns.ControlReturn.Value.QueryStatistics(_)))
            .orElse[edu.uci.ics.amber.engine.architecture.worker.controlreturns.ControlReturn.Value](__fieldsMap.get(scalaDescriptor.findFieldByNumber(201).get).flatMap(_.as[_root_.scala.Option[edu.uci.ics.amber.engine.architecture.worker.controlreturns.PythonPrint]]).map(edu.uci.ics.amber.engine.architecture.worker.controlreturns.ControlReturn.Value.PythonPrint(_)))
            .getOrElse(edu.uci.ics.amber.engine.architecture.worker.controlreturns.ControlReturn.Value.Empty)
      )
    case _ => throw new RuntimeException("Expected PMessage")
  }
  def javaDescriptor: _root_.com.google.protobuf.Descriptors.Descriptor = ControlreturnsProto.javaDescriptor.getMessageTypes().get(2)
  def scalaDescriptor: _root_.scalapb.descriptors.Descriptor = ControlreturnsProto.scalaDescriptor.messages(2)
  def messageCompanionForFieldNumber(__number: _root_.scala.Int): _root_.scalapb.GeneratedMessageCompanion[_] = {
    var __out: _root_.scalapb.GeneratedMessageCompanion[_] = null
    (__number: @_root_.scala.unchecked) match {
      case 1 => __out = edu.uci.ics.amber.engine.common.worker.WorkerStatistics
      case 3 => __out = edu.uci.ics.amber.engine.architecture.worker.controlreturns.QueryStatistics
      case 201 => __out = edu.uci.ics.amber.engine.architecture.worker.controlreturns.PythonPrint
    }
    __out
  }
  lazy val nestedMessagesCompanions: Seq[_root_.scalapb.GeneratedMessageCompanion[_ <: _root_.scalapb.GeneratedMessage]] = Seq.empty
  def enumCompanionForFieldNumber(__fieldNumber: _root_.scala.Int): _root_.scalapb.GeneratedEnumCompanion[_] = {
    (__fieldNumber: @_root_.scala.unchecked) match {
      case 2 => edu.uci.ics.amber.engine.common.worker.WorkerState
    }
  }
  lazy val defaultInstance = edu.uci.ics.amber.engine.architecture.worker.controlreturns.ControlReturn(
    value = edu.uci.ics.amber.engine.architecture.worker.controlreturns.ControlReturn.Value.Empty
  )
  sealed trait Value extends _root_.scalapb.GeneratedOneof {
    def isEmpty: _root_.scala.Boolean = false
    def isDefined: _root_.scala.Boolean = true
    def isWorkerStatistics: _root_.scala.Boolean = false
    def isWorkerState: _root_.scala.Boolean = false
    def isQueryStatistics: _root_.scala.Boolean = false
    def isPythonPrint: _root_.scala.Boolean = false
    def workerStatistics: _root_.scala.Option[edu.uci.ics.amber.engine.common.worker.WorkerStatistics] = _root_.scala.None
    def workerState: _root_.scala.Option[edu.uci.ics.amber.engine.common.worker.WorkerState] = _root_.scala.None
    def queryStatistics: _root_.scala.Option[edu.uci.ics.amber.engine.architecture.worker.controlreturns.QueryStatistics] = _root_.scala.None
    def pythonPrint: _root_.scala.Option[edu.uci.ics.amber.engine.architecture.worker.controlreturns.PythonPrint] = _root_.scala.None
  }
  object Value {
    @SerialVersionUID(0L)
    case object Empty extends edu.uci.ics.amber.engine.architecture.worker.controlreturns.ControlReturn.Value {
      type ValueType = _root_.scala.Nothing
      override def isEmpty: _root_.scala.Boolean = true
      override def isDefined: _root_.scala.Boolean = false
      override def number: _root_.scala.Int = 0
      override def value: _root_.scala.Nothing = throw new java.util.NoSuchElementException("Empty.value")
    }
  
    @SerialVersionUID(0L)
    final case class WorkerStatistics(value: edu.uci.ics.amber.engine.common.worker.WorkerStatistics) extends edu.uci.ics.amber.engine.architecture.worker.controlreturns.ControlReturn.Value {
      type ValueType = edu.uci.ics.amber.engine.common.worker.WorkerStatistics
      override def isWorkerStatistics: _root_.scala.Boolean = true
      override def workerStatistics: _root_.scala.Option[edu.uci.ics.amber.engine.common.worker.WorkerStatistics] = Some(value)
      override def number: _root_.scala.Int = 1
    }
    @SerialVersionUID(0L)
    final case class WorkerState(value: edu.uci.ics.amber.engine.common.worker.WorkerState) extends edu.uci.ics.amber.engine.architecture.worker.controlreturns.ControlReturn.Value {
      type ValueType = edu.uci.ics.amber.engine.common.worker.WorkerState
      override def isWorkerState: _root_.scala.Boolean = true
      override def workerState: _root_.scala.Option[edu.uci.ics.amber.engine.common.worker.WorkerState] = Some(value)
      override def number: _root_.scala.Int = 2
    }
    @SerialVersionUID(0L)
    final case class QueryStatistics(value: edu.uci.ics.amber.engine.architecture.worker.controlreturns.QueryStatistics) extends edu.uci.ics.amber.engine.architecture.worker.controlreturns.ControlReturn.Value {
      type ValueType = edu.uci.ics.amber.engine.architecture.worker.controlreturns.QueryStatistics
      override def isQueryStatistics: _root_.scala.Boolean = true
      override def queryStatistics: _root_.scala.Option[edu.uci.ics.amber.engine.architecture.worker.controlreturns.QueryStatistics] = Some(value)
      override def number: _root_.scala.Int = 3
    }
    @SerialVersionUID(0L)
    final case class PythonPrint(value: edu.uci.ics.amber.engine.architecture.worker.controlreturns.PythonPrint) extends edu.uci.ics.amber.engine.architecture.worker.controlreturns.ControlReturn.Value {
      type ValueType = edu.uci.ics.amber.engine.architecture.worker.controlreturns.PythonPrint
      override def isPythonPrint: _root_.scala.Boolean = true
      override def pythonPrint: _root_.scala.Option[edu.uci.ics.amber.engine.architecture.worker.controlreturns.PythonPrint] = Some(value)
      override def number: _root_.scala.Int = 201
    }
  }
  implicit class ControlReturnLens[UpperPB](_l: _root_.scalapb.lenses.Lens[UpperPB, edu.uci.ics.amber.engine.architecture.worker.controlreturns.ControlReturn]) extends _root_.scalapb.lenses.ObjectLens[UpperPB, edu.uci.ics.amber.engine.architecture.worker.controlreturns.ControlReturn](_l) {
    def workerStatistics: _root_.scalapb.lenses.Lens[UpperPB, edu.uci.ics.amber.engine.common.worker.WorkerStatistics] = field(_.getWorkerStatistics)((c_, f_) => c_.copy(value = edu.uci.ics.amber.engine.architecture.worker.controlreturns.ControlReturn.Value.WorkerStatistics(f_)))
    def workerState: _root_.scalapb.lenses.Lens[UpperPB, edu.uci.ics.amber.engine.common.worker.WorkerState] = field(_.getWorkerState)((c_, f_) => c_.copy(value = edu.uci.ics.amber.engine.architecture.worker.controlreturns.ControlReturn.Value.WorkerState(f_)))
    def queryStatistics: _root_.scalapb.lenses.Lens[UpperPB, edu.uci.ics.amber.engine.architecture.worker.controlreturns.QueryStatistics] = field(_.getQueryStatistics)((c_, f_) => c_.copy(value = edu.uci.ics.amber.engine.architecture.worker.controlreturns.ControlReturn.Value.QueryStatistics(f_)))
    def pythonPrint: _root_.scalapb.lenses.Lens[UpperPB, edu.uci.ics.amber.engine.architecture.worker.controlreturns.PythonPrint] = field(_.getPythonPrint)((c_, f_) => c_.copy(value = edu.uci.ics.amber.engine.architecture.worker.controlreturns.ControlReturn.Value.PythonPrint(f_)))
    def value: _root_.scalapb.lenses.Lens[UpperPB, edu.uci.ics.amber.engine.architecture.worker.controlreturns.ControlReturn.Value] = field(_.value)((c_, f_) => c_.copy(value = f_))
  }
  final val WORKER_STATISTICS_FIELD_NUMBER = 1
  final val WORKER_STATE_FIELD_NUMBER = 2
  final val QUERY_STATISTICS_FIELD_NUMBER = 3
  final val PYTHON_PRINT_FIELD_NUMBER = 201
  def of(
    value: edu.uci.ics.amber.engine.architecture.worker.controlreturns.ControlReturn.Value
  ): _root_.edu.uci.ics.amber.engine.architecture.worker.controlreturns.ControlReturn = _root_.edu.uci.ics.amber.engine.architecture.worker.controlreturns.ControlReturn(
    value
  )
  // @@protoc_insertion_point(GeneratedMessageCompanion[edu.uci.ics.amber.engine.architecture.worker.ControlReturn])
}
