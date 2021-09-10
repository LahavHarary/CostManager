package DataStructures

class Item(var nameFrom: String ,var priceFrom: Double ,var amountFrom: Int) {

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

  override def toString: String = "item name is " +name +"\n" +"amount of items: " +
    "" +amount +" price per item: " +price +" total: " +total

}
