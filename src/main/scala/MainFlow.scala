import FileHandler.UseXML
import DataStructures.Item
import Reporters.{PrintReporter, TextReporter, WordReporter}
import scala.util.control.Breaks.break

/*
Lahav Harary 316012517
Omer Gez 313329302
*/


object MainFlow {

  def flow(): Unit ={

    println("Click 1 to create a new file \n" +
      "Click 2 to work on existing file \n" +
      "Any other key to shut down the program")
    var choice : Char = scala.io.StdIn.readChar()

    while(choice == '1' || choice == '2'){
      choice match{
        case '1' => newFile()
        case '2' => existingFile()
        case _ => break
      }

      println("Click 1 to create a new file \n" +
        "Click 2 to work on existing file \n" +
        "Any other key to shut down the program")
      choice = scala.io.StdIn.readChar()

    }
    println("Goodbye Have a nice day!")

    /* Functions that assists newFile and existingFile*/
    def makeAnXMLFile(itemList: List[Item]) = {
      UseXML.writeXMLData(itemList)
    }
    def getItemsFromUser(): (scala.collection.mutable.ListBuffer[Item]) ={
      val buf = scala.collection.mutable.ListBuffer.empty[Item]
      var continue: Char = '1'

      while(continue == '1'){
        println("Please enter the name of the product, value per each, amount of items: ")
        var readLine: String = scala.io.StdIn.readLine()
        var stuff = readLine.split(" "(0))
        var item: Item = new Item(stuff(0),stuff(1).toDouble,stuff(2).toInt)
        buf += item

        println("Please enter 1 to add a new element or other key to stop adding")
        continue = scala.io.StdIn.readChar()
      }
      return buf
    }

    def presentChoices(itemList: List[Item]): Unit={
      makeAnXMLFile(itemList)
      var continue = '1'
      while(continue == '1' || continue == '2' || continue == '3'){
        println("Click 1 to get a docs report \n" +
          "Click 2 to get txt report \n" +
          "Click 3 to get printed report \n" +
          "Click ANY OTHER KEY to go back")

        continue = scala.io.StdIn.readChar()
        continue match {
          case '1' => WordReporter.report()
            println("docs report is being created") //get docs report
          case '2' => TextReporter.report() // get txt report
            println("docs text is being created")
          case '3' => PrintReporter.report() // get printed report
          case _ => // END newFile.
        }
      }
    }
    /* Two Option functions that allows the user to choose what he wants to do - create a new file or work on existing file */
    def newFile(): Unit= {
      println("Click 1 to add elements to the list, Any other key to cancel.")
      var choice : Char = scala.io.StdIn.readChar()
      if(choice == '1'){
        val buf = getItemsFromUser()
        var itemList = buf.toList
        presentChoices(itemList)
      }

    }
    def existingFile(): Unit= {
      val buf: scala.collection.mutable.ListBuffer[Item] = UseXML.loadExistingFile()

      println("For adding new elements click 1 \n" +
        "For deleting elements click 2 \n" +
        "Any other key = continue")
      var choice : Char = scala.io.StdIn.readChar()
      while(choice == '1' || choice == '2'){
        choice match {
          case '1' => // Add elements logic
            val newBuf = getItemsFromUser()
            for(item <- newBuf){
              buf += item
            }

          case '2' => // Delete elements logic
            PrintReporter.report()
            if(buf.toList.length>0){
              println("Enter the number of item that you would like to delete (starting from 1)")
              var delete: Int = scala.io.StdIn.readInt() - 1
              if(delete < 0 || delete > buf.toList.length){
                println("Wrong number.")
              }
              else{
                buf.remove(delete)
              }
            }
            else{
              println("No more items, can't delete")
            }

          case _ => println()
        }

        UseXML.writeXMLData(buf.toList)
        println("For adding new elements click 1 \n" +
          "For deleting elements click 2 \n" +
          "Any other key = continue")
        choice = scala.io.StdIn.readChar()
      }


      presentChoices(buf.toList)
    }

  }

}



