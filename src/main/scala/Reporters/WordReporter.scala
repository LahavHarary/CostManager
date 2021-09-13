package Reporters
import FileHandler.UseXML
import Traits.IReporter

import java.io.{File, PrintWriter}

/*
Lahav Harary 316012517
Omer Gez 313329302
*/


object WordReporter extends IReporter {
  override def report(): Unit = {
    saveAsDoc()
  }

  private def saveAsDoc(): Unit = {
    val pw = new PrintWriter(new File("hello.docs"))
    var str: String = ""
    var sum: Double = 0
    var dataFromXML = (UseXML.loadExistingFile()).toList

    for (item <- dataFromXML) {
      str += item.toString()
      sum += item.total.toDouble
    }
    str += "TOTAL AMOUNT: " + sum + "\n"

    pw.write(str)
    pw.close()

  }


}