import FileHandler.UseXML
import DataStructures.Item
import Reporters.{PrintReporter, TextReporter, WordReporter}
import scala.util.control.Breaks.break

/**
Lahav Harary 316012517
Omer Gez 313329302
*/

/**
 * The object that runs our code.
 * when user is using flow function it allows him to decide between two different options:
 * The first one is - creating a brand new file.
 * The second one is - working with an existing file.
 */

object MainFlow {

  /**
   * The "MAIN MENU" of our program
   * If 1 is clicked the user is moving to newFile function (which there he will create a new file)
   * If 2 is clicked the user is moving to existingFile function (which there he will be working on an existing file)
   * any other key will shut down the program
   */

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

    /**
     *  Functions that assists newFile and existingFile:
     *  MakeAnXMLFile is a function which receives item list and uses UseXML.writeXMLData function.
     *
     *  getItemsFromUser is a menu function which asks the user if we would like to enter items.
     *  If the user clicks '1' it means that he would like to add another item and the function will ask him to do so.
     *  Any other key will end this function and buffer with the existing items will return.
     *
     * presentChoices is another Menu Function which shows the user what he can do at the moment.
     * The choices consist of:
     * '1' create a docs report
     * '2' create a txt report
     * '3' print the report to cmd
     *  Any other key will end this function and take the user back.
     */
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

    /**
     *  The purpose of those two function is explained at the top.
     *
     *  newFile asks the user if he would like to add elements to the list
     *  If '1' is clicked it means that the user does and the function will ask for his input
     *  (using the getItemsFromUser function)
     *  Any other key will cancel newFile Menu (no Items will be added)
     *
     *  existingFile loads whatever is in file.xml and turns in to a mutable list buffer.
     *  The user is being asked if he would like to add elements to the list, delete elements from the list or do nothing.
     *  If '1' is clicked then a new buffer will be created inside getItemsFromUser function (explained earlier here)
     *  The old buffer will add the values from the new buffer using a standard scala for loop
     *  If '2' is clicked then at first the current report will be printed to the screen.
     *  If the amount of items inside buffer is greater than 0 then it means that item can be deleted from the list
     *  The user is asked to write the number of item inside the list (we are subtracting 1 from the user input because
     *  in Computer Science we are counting from 0).
     *  If The use decided to be funny and enter a wrong number then an if condition will defend access to the wrong place
     *  in the buffer (Simple check that the number that the user has entered isn't negative Nor greater then the amount of
     *  items inside buffer).
     *  When existingFile logic is ending the user is once again going to presentChoices function to show him what he
     *  can do at the moment.
     *
     * */
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



