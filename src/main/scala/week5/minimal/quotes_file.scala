package week5.minimal

import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.select.Elements
import net.liftweb.json._
import net.liftweb.json.Serialization.write
import java.io.{File, FileWriter}
import scala.collection.mutable.ListBuffer

object quotes_file extends App {
  def write_file (file_name: String, content: String): Unit = {
    if(file_name != null && !file_name.isEmpty()) {
      val file = new File(file_name)
      var file_writer = new FileWriter(file)
      file_writer.write(content)
      file_writer.close()
    }
  }
  var quotes_doc: Document = Jsoup.connect("https://quotes.toscrape.com/").get();
  val quotes :Elements = quotes_doc.select("div.quote")
  val quotesListB: ListBuffer[String] = new ListBuffer[String]
  val quotes_arr = quotes.toArray()
  for (i<-0 to quotes_arr.length-1) {
    var quote: Document = Jsoup.parse(quotes_arr(i).toString)
    var q: String = quote.text()
    implicit val formats = DefaultFormats
    val json_quote = write(q)
    quotesListB += json_quote
  }
  val quotesList = quotesListB.toList
  var quotes_string: String = ""
  for (i<-0 to quotesList.length-1) {
    quotes_string += quotesList(i) + "\n"
  }
  implicit val formats = DefaultFormats
  val json_quotes = write(quotes_string)
  var file_name = "quotes.json"
  write_file(file_name, json_quotes)
}
