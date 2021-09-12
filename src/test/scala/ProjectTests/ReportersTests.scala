package ProjectTests
import DataStructures.Item
import org.scalatest.funsuite.AnyFunSuite
import Classes.{PrintReporter, TextReporter, UseXML, WordReporter}

import java.nio.file.{Files, Paths}
class ReportersTests extends AnyFunSuite{

  val item1:Item = new Item("E1", 5.0, 3)
  val item2:Item = new Item("E2", 5.2, 2)
  val item3:Item = new Item("E3", 5.4, 1)
  val item4:Item = new Item("E4", 5.6, 4)

  val itemList:List[Item] = List[Item](item1,item2,item3,item4)
  (new UseXML).writeXMLData(itemList)

  //word reporter test
  test("Create a new word/doc file"){
    (new WordReporter).report()
    assert(Files.exists(Paths.get("hello.docs")) == true)
  }
  test("Create a new txt file"){
    (new TextReporter).report()
    assert(Files.exists(Paths.get("hello.txt")) == true)
  }

}