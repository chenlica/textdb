package edu.uci.ics.texera.web.model.request

case class HelloWorldRequest(message: String) extends TexeraWebSocketRequest

case class HeartBeatRequest() extends TexeraWebSocketRequest
