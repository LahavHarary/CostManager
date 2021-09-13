package ProjectTests
import DataStructures.Item
import org.scalatest.funsuite.AnyFunSuite
import FileHandler.UseXML
import Reporters.{TextReporter, WordReporter}

import java.nio.file.{Files, Paths}

/**
Lahav Harary 316012517
Omer Gez 313329302
*/

/**
 * In this class we are checking each one of our Reporters are working properly.
 */

class ReportersTests extends AnyFunSuite{

  // At first, we create 4 items and 1 item list, we will use writeXMLData.
  val firstItem:Item = new Item("E1", 5.0, 3)
  val secondItem:Item = new Item("E2", 5.2, 2)
  val thirdItem:Item = new Item("E3", 5.4, 1)
  val fourthItem:Item = new Item("E4", 5.6, 4)

  val itemList:List[Item] = List[Item](firstItem,secondItem,thirdItem,fourthItem)
  UseXML.writeXMLData(itemList)

  // A test to see if a docs file was created.
  test("Create a new word/doc file"){
    WordReporter.report()
    assert(Files.exists(Paths.get("hello.docs")) == true)
  }
  // A test to see if a txt file was created.
  test("Create a new txt file"){
    TextReporter.report()
    assert(Files.exists(Paths.get("hello.txt")) == true)
  }

}