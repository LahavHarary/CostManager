package DataStructures

/**
Lahav Harary 316012517
Omer Gez 313329302
*/

/**
 * @param nameFrom
 * @param priceFrom
 * @param amountFrom
 *
 * A data structure that is being used in order to store "items" from the user input
 * Item data structure can't receive negative values in priceFrom and amountFrom.
 * if a negative value is being given then it will be saved as 0 instead (You can't buy -1 apples for example) and it's
 * pretty rare to see someone giving you money in order for you to receive an object.
 *
 * the total amount is being calculated when Item is created.
 */

class Item(private var nameFrom: String ,private var priceFrom: Double ,private var amountFrom: Int) {

  if(priceFrom < 0){
    priceFrom = 0
  }
  if(amountFrom < 0){
    amountFrom = 0
  }

  def name: String = nameFrom
  def price: String = priceFrom.toString
  def amount: String = amountFrom.toString
  def total: String = (priceFrom*amountFrom).toString

  override def toString: String = "Item name " +name +"\n" +
    "Amount bought: " +amount +" Price per each: " +price +" Total Amount spent on item: "+total +"\n"

}
