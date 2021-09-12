import Classes.{PrintReporter, TextReporter, UseXML, WordReporter}
import DataStructures.Item

import scala.util.control.Breaks.break

class MainFlow {

  println("Click 1 to create a new file \n" +
    "Click 2 to work on existing file \n" +
    "Any other key to shut down the program \n")
  var choice : Char = scala.io.StdIn.readChar()

  while(choice == '1' || choice == '2'){
    choice match{
      case '1' => newFile()
      case '2' => existingFile()
      case _ => break
    }

    println("Click 1 to create a new file \n" +
      "Click 2 to work on existing file \n" +
      "Any other key to shut down the program \n")
    choice = scala.io.StdIn.readChar()

  }

  println("Good Bye")

  /* Functions that assists newFile and existingFile*/
  def makeAnXMLFile(itemList: List[Item]) = {
    val useXML = new UseXML()
    useXML.writeXMLData(itemList)
  }
  def getItemsFromUser(): (scala.collection.mutable.ListBuffer[Item]) ={
    val buf = scala.collection.mutable.ListBuffer.empty[Item]
    var continue: Char = '1'

    while(continue == '1'){
      println("Please enter the name of the product: ")
      var name: String = scala.io.StdIn.readLine()
      println("Please enter the value per item: ")
      var value: Double = scala.io.StdIn.readDouble()
      println("Please enter the amount of items bought: ")
      var amount: Int = scala.io.StdIn.readInt()
      var item: Item = new Item(name,value,amount)
      buf += item

      println("Please enter 1 to add a new element or any other key to stop adding.")
      continue = scala.io.StdIn.readChar()
    }
    return buf
  }
  def getDocsFile(): Unit= {
    val wordReporter: WordReporter = new WordReporter()
    wordReporter.report()
  }
  def getTxtFile(): Unit= {
    val txtReporter: TextReporter = new TextReporter()
    txtReporter.report()
  }
  def getPrintedReport(itemList: List[Item]): Unit= {
    for(item <- itemList){
      println(item.toString)
    }
  }
  def presentChoices(itemList: List[Item]): Unit={
    makeAnXMLFile(itemList)
    var continue = '1'
    while(continue == '1' || continue == '2' || continue == '3'){
      println("Click 1 to get a docs report \n" +
        "Click 2 to get txt report \n" +
        "Click 3 to get printed report \n" +
        "Click ANY OTHER KEY to go back \n")

      continue = scala.io.StdIn.readChar()
      continue match {
        case '1' => getDocsFile()
          printf("docs report is being created") //get docs report
        case '2' => getTxtFile() // get txt report
          printf("docs text is being created")
        case '3' => getPrintedReport(itemList) // get printed report
        case _ => // END newFile.
      }
    }
  }
  /* Two Option functions that allows the user to choose what he wants to do - create a new file or work on existing file */
  def newFile(): Unit= {
    println("Click 1 to add elements to the list, Any other key to cancel.\n")
    var choice : Char = scala.io.StdIn.readChar()
    if(choice == '1'){
      val buf = getItemsFromUser()
      var itemList = buf.toList
      presentChoices(itemList)
    }

  }
  def existingFile(): Unit= {
    val useXML: UseXML = new UseXML()
    val buf: scala.collection.mutable.ListBuffer[Item] = useXML.loadExistingFile()

    printf("For adding new elements click 1 \n" +
      "For deleting elements click 2 \n" +
      "Any other key = continue \n")
    var choice : Char = scala.io.StdIn.readChar()
    while(choice == '1' || choice == '2'){
      choice match {
        case '1' => // Add elements logic
          val newBuf = getItemsFromUser()
          for(item <- newBuf){
            buf += item
          }

        case '2' => // Delete elements logic
          getPrintedReport(buf.toList)
          println("Enter the number of item that you would like to delete (starting from 1)")
          var delete: Int = scala.io.StdIn.readInt() - 1
          if(delete < 0 || delete > buf.toList.length){
            println("Wrong number.")
          }
          else{
            buf.remove(delete)
          }
        case _ => println()
      }

      printf("For adding new elements click 1 \n" +
        "For deleting elements click 2 \n" +
        "Any other key = continue \n")
      choice = scala.io.StdIn.readChar()
    }

    presentChoices(buf.toList)

  }

}




