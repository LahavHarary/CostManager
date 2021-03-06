package ProjectTests
import org.scalatest.funsuite.AnyFunSuite
import DataStructures.Item

/**
Lahav Harary 316012517
Omer Gez 313329302
 */

/**
 * In this class we are checking Item data structure.
 */


class ItemTests extends AnyFunSuite {

  /**
   * Item class doesn't allow negative numbers in priceFrom and amountFrom.
   * In this test case we are checking that all of item values are properly inserted.
   */
  val item1 = new Item("test", 5.0, 3)
  val item2 = new Item("test", -5.0, -3)

  test("all properties of item have valid values"){
    assert(item1.name == "test")
    assert(item1.price ==  "5.0")
    assert(item1.amount == "3")
    assert(item1.total == (5.0*3).toString)
    assert(item2.price == "0.0")
    assert(item2.amount == "0")
    assert(item2.total == "0.0")
  }

}