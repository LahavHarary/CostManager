package Classes

import Traits.IReporter

import java.io.{File, PrintWriter}

class TextReporter extends IReporter {
  override def report(): Unit = {
    saveAsTxt()
  }

  private def saveAsTxt(): Unit = {
    val pw = new PrintWriter(new File("hello.txt"))
    var str: String = ""
    var sum: Double = 0
    val useXML: UseXML = new UseXML();
    var dataFromXML = (useXML.loadExistingFile()).toList

    for (item <- dataFromXML) {
      str += item.toString()
      sum += item.total.toDouble
    }
    str += "TOTAL AMOUNT: " + sum

    pw.write(str)
    pw.close()

  }
}
