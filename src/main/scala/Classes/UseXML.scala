package Classes
import DataStructures.Item

import scala.reflect.ClassTag
import scala.xml._
import scala.io.Source

class UseXML {

  def getXMLData(): scala.xml.Elem = {
    val xmlData = xml.XML.loadFile("file.xml")
    return xmlData
  }

  def writeXMLData(itemList: List[Item]): Unit = {
    scala.xml.XML.save("file.xml", <items>{itemList.map(nodeFromItem)}</items>)
  }

  def nodeFromItem(i: Item): Node ={
    <item name={i.name} amount={i.amount} price={i.price} totalPrice={i.total}></item>
  }

}
