package ProjectTests
import FileHandler.UseXML
import org.scalatest.funsuite.AnyFunSuite
import DataStructures.Item

import java.nio.file.{Files, Paths}

/*
Lahav Harary 316012517
Omer Gez 313329302
*/


class UseXMLTests extends AnyFunSuite {
  val item1:Item = new Item("E1", 5.0, 3)
  val item2:Item = new Item("E2", 5.2, 2)
  val item3:Item = new Item("E3", 5.4, 1)
  val item4:Item = new Item("E4", 5.6, 4)


  val itemList1:List[Item] = List[Item](item1,item2,item3,item4)
  val itemList2:List[Item] = List[Item]()

  //write valid file test
  test("Create a new file from list with data"){
    UseXML.writeXMLData(itemList1)
    assert(Files.exists(Paths.get("file.xml")) == true)
  }
  test("Create a new file from list without data"){
    UseXML.writeXMLData(itemList2)
    assert(Files.exists(Paths.get("file.xml")) == true)
  }

  //read from xml test
  test("Same list when you write and load xml"){
    UseXML.writeXMLData(itemList1)
    val tempItems: List[Item] = UseXML.loadExistingFile().toList
    for (i:Int <- 0 until itemList1.length){
      assert(tempItems(i).name == itemList1(i).name)
      assert(tempItems(i).price == itemList1(i).price)
      assert(tempItems(i).amount == itemList1(i).amount)
      assert(tempItems(i).total == itemList1(i).total)
    }
  }

}