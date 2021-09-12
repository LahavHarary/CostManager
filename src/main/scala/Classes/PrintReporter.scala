package Classes
import Traits.IReporter

import scala.xml.Node
import scala.xml.NodeSeq.seqToNodeSeq

class PrintReporter extends IReporter {

  override def report(): Unit = {
    printToScreen();
  }


  private def printToScreen(): Unit ={
    val useXML: UseXML = new UseXML()
    val xmlData = useXML.getXMLData()

    val itemNames = (xmlData \\ "@name")
    val itemAmounts = (xmlData \\ "@amount")
    val itemPrices = (xmlData \\ "@price")
    val itemTotals = (xmlData \\ "@totalPrice")

    var sum: Double = 0
    var str: String = ""

    for (((a,b),(c,d)) <- (itemNames zip itemAmounts) zip (itemPrices zip itemTotals))
    {
      str += "Item name " +a +"\n" +"Amount bought: " +b +" Price per each: " +c +" Total Amount spent on item: "+d +"\n"
      sum += (d.toString()).toDouble
    }

    str += "TOTAL AMOUNT: " +sum
    println(str)
  }


}
