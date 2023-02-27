package week5.minimal

import requests.Response

object visit_link {
  def main(args: Array[String])
  {
    val response: Response = requests.get("https://quotes.toscrape.com/")
    println("Response status code:")
    println(response.statusCode)
    println
    println("Response headers:")
    println(response.headers)
    println
    println("Response body:")
    println(response.data)
  }
}
