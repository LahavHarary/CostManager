import Classes.{PrintReporter, UseXML}
import DataStructures.Item

object main {

  def main(args: Array[String]): Unit = {
    //checkItemNegativePrice()
    //checkItemZeroPrice()
    //checkItemNegativeAmount()
    //checkItemZeroAmount()
    //checkLoadFunction()
    //checkSaveFunction()
    //checkPrintReporter()
    var mainFlow: MainFlow  = new MainFlow()
  }



  def checkLoadFunction(): Unit = {
    var useXml = new UseXML();
    var xmlData = useXml.getXMLData()
    print(xmlData)

  }

  def checkSaveFunction(): Unit = {
    var a = new Item("a",-100,10)
    var b = new Item("b",10,10)
    var c = new Item("c",1,10)
    var d = new Item("d",1,1)

    val itemList = List[Item](a,b,c,d)
    var useXml = new UseXML();
    useXml.writeXMLData(itemList)
  }

  def checkItemNegativePrice(): Unit = {
    var item: Item = new Item("Hello This is a check",-500,100)
    print(item)
  }

  def checkItemZeroPrice(): Unit = {
    var item: Item = new Item("Hello This is a check",0,100)
    print(item)
  }

  def checkItemNegativeAmount(): Unit = {
    var item: Item = new Item("Hello This is a check",500,-100)
    print(item)
  }

  def checkItemZeroAmount(): Unit = {
    var item: Item = new Item("Hello This is a check",500,0)

    print(item)
  }

  def checkPrintReporter(): Unit={
    var printReporter: PrintReporter = new PrintReporter()
    printReporter.report()
  }
}
