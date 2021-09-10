package DataStructures

class Item(name: String ,price: Double,amount: Int) {

  // (name:String, price: Double, amount: Int)
  private[this] var priceChecker: Double = 0
  def price: Double = priceChecker
  def price_=(vol: Double)
  {
    if(vol>0)
    {
      priceChecker = vol
    }
    else if(vol < 0)
    {
      throw new RuntimeException("price cannot be negative")
    }
    else
    {
      throw new RuntimeException("price cannot be zero")
    }
  }

  private[this] var amountChecker: Int = 0
  def amount: Int = amountChecker
  def amount_=(vol: Int)
  {
    if(vol>0)
    {
      amountChecker = vol
    }
    else if(vol < 0)
    {
      throw new RuntimeException("amount cannot be negative")
    }
    else
    {
      throw new RuntimeException("amount cannot be zero")
    }
  }

  def getTotal(): Double={
    return 5
  }

  def getName(): String ={
    return name
  }


  /*
  override def toString() : String = {
    return "The name of the product: " + name + ", price per product is: " +
      "" +price +" the amount of items from the product: " +amount +" total cost: " +(price*amount)
  }
*/
}
