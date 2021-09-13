package Reporters

import FileHandler.UseXML
import Traits.IReporter

/**
Lahav Harary 316012517
Omer Gez 313329302
*/

/**
 * A reporter Object which prints a file according to existing XML file
 * The function uses loadExistingFile method from UseXML object
 * The function is iterating over the entire data from the XML file and adding each line to str variable (String)
 * In the same time sum is being added according to the total value of each one of the Items inside the list.
 * At the end, a report in printed format is being created from str and being printed to the screen using.
 */

object PrintReporter extends IReporter {

  override def report(): Unit = {
    printToScreen();
  }


  private def printToScreen(): Unit = {

    var dataFromXML = (UseXML.loadExistingFile()).toList

    var sum: Double = 0
    var str: String = ""
    for (item <- dataFromXML) {
      str += item.toString()
      sum += item.total.toDouble
    }
    str += "TOTAL AMOUNT: " + sum + "\n"
    println(str)
  }
}