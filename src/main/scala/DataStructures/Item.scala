package DataStructures

/*
Lahav Harary 316012517
Omer Gez 313329302
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
