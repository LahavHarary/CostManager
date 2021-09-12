package Classes
import Traits.IReporter
import java.io.{File, PrintWriter}

class WordReporter extends IReporter{
  override def report(): Unit ={
    saveAsDoc()
  }

  private def saveAsDoc(): Unit ={
    val pw = new PrintWriter(new File("hello.docs"))
    var str: String = ""
    var sum: Double = 0
    val useXML: UseXML = new UseXML();
    var dataFromXML = (useXML.loadExistingFile()).toList

    for(item <- dataFromXML){
      str += item.toString()
      sum += item.total.toDouble
    }
    str += "TOTAL AMOUNT: " +sum

    pw.write(str)
    pw.close()

  }



}
