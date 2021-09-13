package FileHandler
import DataStructures.Item

import java.nio.file.{Files, Paths}
import scala.collection.mutable.ListBuffer
import scala.xml._

/**
Lahav Harary 316012517
Omer Gez 313329302
*/

/**
 * A class which is responsible for receiving data from XML file and creating XML files from Item list.
 */

object UseXML {

  /**
   * getXMLData is a private method which gets the data from xml file using xml.XML.loadFile method (library method)
   * This function is private and is used in UseXML object only.
   */
  private def getXMLData(): scala.xml.Elem ={
    val xmlData = xml.XML.loadFile("file.xml")
    return xmlData
  }

  /**
   * writeXMLData is a public method which sends each one of the items inside the list to nodeFromItem function
   * later on it saves the entire data as an XML document
   */
  def writeXMLData(itemList: List[Item]): Unit = {
    scala.xml.XML.save("file.xml", <items>{itemList.map(nodeFromItem)}</items>)
  }

  /**
   * nodeFromItem is a private function which receives an Item and returns a node with Xml syntax.
   */
  private def nodeFromItem(i: Item): Node ={
    <item name={i.name} amount={i.amount} price={i.price} totalPrice={i.total}></item>
  }

  /**
   * A function which other users can use.
   * The function is creating an empty buffer at first
   * The function then checks that file.xml is existing
   * if it is existing and everything is ok it will use getXMLData function to pull the data from it.
   * Then it will create 4 values from the data:
   * 1. items names
   * 2. items amounts
   * 3. items prices
   * 4. items prices
   *
   * each one of those values will be used inside a for loop in order to create an item data structure and then to
   * add it to the buffer
   *
   * at the end of the method the buffer is returned
   */
  def loadExistingFile():  ListBuffer[Item]={
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
