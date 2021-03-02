package edu.uci.ics.amber.engine.recovery.mem

import edu.uci.ics.amber.engine.recovery.MainLogStorage.MainLogElement

import scala.collection.mutable

object InMemoryLogStorage {

  private lazy val mainLogs = new mutable.HashMap[String, mutable.Queue[MainLogElement]]()

  private lazy val secondaryLogs = new mutable.HashMap[String, mutable.Queue[Long]]()

  def getMainLogOf(k: String): mutable.Queue[MainLogElement] = {
    if (!mainLogs.contains(k)) {
      mainLogs(k) = new mutable.Queue[MainLogElement]()
    }
    mainLogs(k)
  }

  def getSecondaryLogOf(k: String): mutable.Queue[Long] = {
    if (!secondaryLogs.contains(k)) {
      secondaryLogs(k) = new mutable.Queue[Long]()
    }
    secondaryLogs(k)
  }

  def clearMainLogOf(k: String): Unit = {
    if (mainLogs.contains(k)) {
      mainLogs.remove(k)
    }
  }

  def clearSecondaryLogOf(k: String): Unit = {
    if (secondaryLogs.contains(k)) {
      secondaryLogs.remove(k)
    }
  }

}