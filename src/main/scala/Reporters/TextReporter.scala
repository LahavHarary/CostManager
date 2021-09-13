package Reporters

import FileHandler.UseXML
import Traits.IReporter

import java.io.{File, PrintWriter}

/**
Lahav Harary 316012517
Omer Gez 313329302
*/

/**
 * A reporter Object which creates a txt file according to existing XML file
 * The function uses loadExistingFile method from UseXML object
 * The function is iterating over the entire data from the XML file and adding each line to str variable (String)
 * In the same time sum is being added according to the total value of each one of the Items inside the list.
 * At the end, a report in txt format is being created from str.
 */

object TextReporter extends IReporter {
  override def report(): Unit = {
    saveAsTxt()
  }

  private def saveAsTxt(): Unit = {
    val pw = new PrintWriter(new File("report.txt"))
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
