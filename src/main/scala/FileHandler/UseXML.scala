package FileHandler
import DataStructures.Item

import java.nio.file.{Files, Paths}
import scala.collection.mutable.ListBuffer
import scala.xml._

/*
Lahav Harary 316012517
Omer Gez 313329302
*/


object UseXML {

  def getXMLData(): scala.xml.Elem ={
    val xmlData = xml.XML.loadFile("file.xml")
    return xmlData
  }

  def writeXMLData(itemList: List[Item]): Unit = {
    scala.xml.XML.save("file.xml", <items>{itemList.map(nodeFromItem)}</items>)
  }

  private def nodeFromItem(i: Item): Node ={
    <item name={i.name} amount={i.amount} price={i.price} totalPrice={i.total}></item>
  }

  def loadExistingFile():  ListBuffer[Item]={
    /*
    A function that loads existing XML file and return it.
    */
    val buf = scala.collection.mutable.ListBuffer.empty[Item]

    if(Files.exists(Paths.get("file.xml")) == false){println("file not found")}
    else {
      val existingXMLFile = UseXML.getXMLData()
      val itemNames = (existingXMLFile \\ "@name")
      val itemAmounts = (existingXMLFile \\ "@amount")
      val itemPrices = (existingXMLFile \\ "@price")
      for(i:Int <- 0 until itemNames.length) {
        buf += new Item(itemNames(i).toString, (itemPrices(i).toString).toDouble, (itemAmounts(i).toString).toInt)
      }
    }
    return buf
  }
}
