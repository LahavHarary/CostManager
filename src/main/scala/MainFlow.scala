import Classes.{PrintReporter, UseXML}
import DataStructures.Item

class MainFlow {

  def loadExistingFile(): Unit={
    /*NOT DONE*/
  }
  def makeAnXMLFile(): Unit ={
    val useXML = new UseXML()
    useXML.writeXMLData(itemList)
  }
  def makeAnXMLFileAndPrintToScreen(): Unit ={
    makeAnXMLFile()
    printToScreen()
  }
  def makeAnXMLAndDocsFile(): Unit ={
    makeAnXMLFile()
    /*Docs comes here*/
  }
  def makeAnXMLAndDocsFilePrintToScreen(): Unit ={
    makeAnXMLAndDocsFile()
    printToScreen()
  }
  def printToScreen(): Unit={
    for(item <- itemList){
      println(item.toString)
    }
  }

  var counter = 0;
  val buf = scala.collection.mutable.ListBuffer.empty[Item]

  println("Please enter 1 to add a new element or any other key to stop adding.")
  var continue: Char = scala.io.StdIn.readChar()
  while(continue == '1'){

    println("Please enter the name of the product: ")
    var name: String = scala.io.StdIn.readLine()
    println("Please enter the value per item: ")
    var value: Double = scala.io.StdIn.readDouble()
    println("Please enter the amount of items bought: ")
    var amount: Int = scala.io.StdIn.readInt()
    var item: Item = new Item(name,value,amount)
    buf += item

    counter += 1
    println("Please enter 1 to add a new element or any other key to stop adding.")
    continue = scala.io.StdIn.readChar()
  }

  var itemList = buf.toList

  if(counter > 0){
    println("1 = make an XML file \n" +
      "2 = make an XML file AND print on screen \n" +
      "3 = make an XML file AND docs file \n" +
      "4 = make an XML file AND docs file AND print to screen \n" +
      "5 = print on screen  \n"+
      "Any other key = Do Nothing")

    continue = scala.io.StdIn.readChar()
    continue match
    {
      case '1' => makeAnXMLFile()
      case '2' => makeAnXMLFileAndPrintToScreen()
      case '3' => makeAnXMLAndDocsFile()
      case '4' => makeAnXMLAndDocsFilePrintToScreen()
      case '5' => printToScreen()
      case _ =>
    }

    print("Good Bye")
  }

}

