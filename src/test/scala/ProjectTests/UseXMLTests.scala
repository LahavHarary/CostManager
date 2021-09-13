package ProjectTests
import FileHandler.UseXML
import org.scalatest.funsuite.AnyFunSuite
import DataStructures.Item

import java.nio.file.{Files, Paths}

/**
Lahav Harary 316012517
Omer Gez 313329302
*/

/**
* In this class we are checking if the UseXML object is working properly.
*/

class UseXMLTests extends AnyFunSuite {

  // At first, we create 4 items and 2 item lists (full list and empty list)
  val firstItem:Item = new Item("E1", 5.0, 3)
  val secondItem:Item = new Item("E2", 5.2, 2)
  val thirdItem:Item = new Item("E3", 5.4, 1)
  val fourthItem:Item = new Item("E4", 5.6, 4)

  val firstItemList:List[Item] = List[Item](firstItem,secondItem,thirdItem,fourthItem)
  val secondItemList:List[Item] = List[Item]()

  //We are checking that a non empty list creates a file
  test("Create a new file from list with data"){
    UseXML.writeXMLData(firstItemList)
    assert(Files.exists(Paths.get("file.xml")) == true)
  }
  //We are checking that an empty list creates a file
  test("Create a new file from list without data"){
    UseXML.writeXMLData(secondItemList)
    assert(Files.exists(Paths.get("file.xml")) == true)
  }

  /**
  * Check our read xml function: we are checking each one of our items from
  * firstItemList vs the item that came back from writeXMLData
  */
  test("Same list when you write and load xml"){
    UseXML.writeXMLData(firstItemList)
    val tempItems: List[Item] = UseXML.loadExistingFile().toList
    for (i:Int <- 0 until firstItemList.length){
      assert(tempItems(i).name == firstItemList(i).name)
      assert(tempItems(i).price == firstItemList(i).price)
      assert(tempItems(i).amount == firstItemList(i).amount)
      assert(tempItems(i).total == firstItemList(i).total)
    }
  }

}