package Reporters

import FileHandler.UseXML
import Traits.IReporter

/*
Lahav Harary 316012517
Omer Gez 313329302
*/


object PrintReporter extends IReporter {

  override def report(): Unit = {
    printToScreen();
  }


  private def printToScreen(): Unit = {
    val xmlData = UseXML.getXMLData()

    val itemNames = (xmlData \\ "@name")
    val itemAmounts = (xmlData \\ "@amount")
    val itemPrices = (xmlData \\ "@price")
    val itemTotals = (xmlData \\ "@totalPrice")

    var sum: Double = 0
    var str: String = ""

    for (((a, b), (c, d)) <- (itemNames zip itemAmounts) zip (itemPrices zip itemTotals)) {
      str += "Item name " + a + "\n" + "Amount bought: " + b + " Price per each: " + c + " Total Amount spent on item: " + d + "\n"
      sum += (d.toString()).toDouble
    }

    str += "TOTAL AMOUNT: " + sum + "\n"
    println(str)
  }


}
