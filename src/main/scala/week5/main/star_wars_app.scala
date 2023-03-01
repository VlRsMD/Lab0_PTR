package week5.main

import java.sql.{Connection, DriverManager, PreparedStatement, ResultSet, ResultSetMetaData, Statement}

object star_wars_app extends App {
  http_methods.get()
  // test different http methods from the http_methods object

}

object connection {
  def connect(): Connection = {
    var url: String = "jdbc:sqlite:identifier.sqlite"
    var conn: Connection = null
    try {
      Class.forName("org.sqlite.JDBC")
      conn = DriverManager.getConnection(url)
    } catch {
      case e: Exception => e.printStackTrace
    }
    return conn
  }
}


object http_methods {
  def get(): Unit = {
    var sqlQuery: String = "SELECT * FROM movie"
    var conn: Connection = connection.connect()
    var st: Statement = conn.createStatement()
    var res: ResultSet = st.executeQuery(sqlQuery)
    var rsmd: ResultSetMetaData = res.getMetaData
    var col_n: Int = rsmd.getColumnCount
    while(res.next()) {
      for (i<-1 to col_n) {
        println(res.getString(i) + " ")
      }
    }
  }
  def get_id(id: Int) = {
    var sqlQuery: String = "SELECT * FROM movie WHERE id="+id;
    var conn: Connection = connection.connect()
    var st: Statement = conn.createStatement()
    var res: ResultSet = st.executeQuery(sqlQuery)
    var rsmd: ResultSetMetaData = res.getMetaData
    var col_n: Int = rsmd.getColumnCount
    while(res.next()) {
      for (i<-1 to col_n) {
        println(res.getString(i) + " ")
      }
    }
  }

  def post(id: Int, title:String, year: Int, director: String): Unit ={
    var sqlQuery: String = "INSERT INTO movie(id, title, release_year, director) VALUES(?, ?, ?, ?)"
    var conn: Connection = connection.connect()
    var st: PreparedStatement = conn.prepareStatement(sqlQuery)
    st.setInt(1, id)
    st.setString(2, title)
    st.setInt(3, year)
    st.setString(4, director)
    var exec = st.executeUpdate()
  }
  def put(id: Int, title:String, year: Int, director: String): Unit ={
    var sqlQuery_create: String = "INSERT INTO movie(id, title, release_year, director) VALUES(?, ?, ?, ?)"
    var sqlQuery_update: String = "UPDATE movie SET title=?, release_year=?, director=? WHERE id=?"
    var conn: Connection = connection.connect()
    var st_check: Statement = conn.createStatement()
    var res_check: ResultSet = st_check.executeQuery("SELECT * FROM movie WHERE id="+id)
    if (res_check.isBeforeFirst()) {
      var st: PreparedStatement = conn.prepareStatement(sqlQuery_update)
      st.setString(1, title)
      st.setInt(2, year)
      st.setString(3, director)
      st.setInt(4, id)
      var exec = st.executeUpdate()
    } else {
      var st: PreparedStatement = conn.prepareStatement(sqlQuery_create)
      st.setInt(1, id)
      st.setString(2, title)
      st.setInt(3, year)
      st.setString(4, director)
      var exec = st.executeUpdate()
    }
  }
  def patch(id: Int, year: Int, director: String): Unit ={
    var sqlQuery: String = "UPDATE movie SET release_year=?, director=? WHERE id=?"
    var conn: Connection = connection.connect()
    var st: PreparedStatement = conn.prepareStatement(sqlQuery)
    st.setInt(1, year)
    st.setString(2, director)
    st.setInt(3, id)
    var exec = st.executeUpdate()
  }
  def delete(id: Int): Unit = {
    var sqlQuery: String = "DELETE FROM movie WHERE id=?";
    var conn: Connection = connection.connect()
    var st: PreparedStatement = conn.prepareStatement(sqlQuery)
    st.setInt(1, id)
    var exec = st.executeUpdate()
  }
}