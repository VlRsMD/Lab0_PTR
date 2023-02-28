package week5.minimal

import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.select.Elements
import scala.collection.mutable.ListBuffer

object collect_quotes extends App {
  var quotes_doc: Document = Jsoup.connect("https://quotes.toscrape.com/").get();
  val quotes :Elements = quotes_doc.select("div.quote")
  val quotesListB: ListBuffer[String] = new ListBuffer[String]
  val quotes_arr = quotes.toArray()
  for (i<-0 to quotes_arr.length-1) {
    var quote: Document = Jsoup.parse(quotes_arr(i).toString)
    var q: String = quote.text()
    quotesListB += q
  }
  val quotesList = quotesListB.toList
  for (i<-0 to quotesList.length-1) {
    println(quotesList(i))
  }
}
