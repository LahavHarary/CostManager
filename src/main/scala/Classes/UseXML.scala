package Classes
import DataStructures.Item

import scala.reflect.ClassTag
import scala.xml._
import scala.io.Source

class UseXML {

  def getXMLData(): scala.xml.Elem = {
    //for (line <- Source.fromFile("file.xml").getLines) {
    //  println(line)
    //}

    val xmlData = xml.XML.loadFile("file.xml")

    return xmlData
  }

  //itemList: List[Item]
  def writeXMLData(itemList: List[Item]): Unit = {


    /*
    var toXML = <items>
      <item name="a" amount="100" price="10" totalPrice="1000"></item>
      <item name="b" amount="10" price="10" totalPrice="100"></item>
      <item name="c" amount="1" price="10" totalPrice="10"></item>
      <item name="d" amount="1" price="1" totalPrice="1"></item>
    </items>
    */

    scala.xml.XML.save("file.xml", <items>{itemList.map(nodeFromItem)}</items>)
  }

  def nodeFromItem(i: Item): Node ={
    <item name={i.getName()} amount={i.amount.toString} price={i.price.toString} totalPrice={i.getTotal().toString()}></item>
  }

}
