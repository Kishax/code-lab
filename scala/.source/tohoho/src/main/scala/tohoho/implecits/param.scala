package tohoho.implicits

import java.sql.Connection
import java.sql.DriverManager
import java.util.Properties

class Data

class Provider {
  def getConnection(): Connection = {
    val jdbcUrl = "jdbc:your_database_type://your_host:your_port/your_database"
    val properties = new Properties()
    properties.setProperty("user", "your_user")
    properties.setProperty("password", "your_password")

    try {
      DriverManager.getConnection(jdbcUrl, properties)
    } catch {
      case e: Exception => {
        println(s"Connection failed: ${e.getMessage}")
        null
      }
    }
  }
}

object param {
  // def loadData(conn: Connection, dataId: Int): Data = { new Data }
  // def saveData(conn: Connection, data: Data) = { println(data) }
  def loadData(dataId: Int)(implicit conn: Connection): Data = { new Data }
  def saveData(data: Data)(implicit conn: Connection) = { println(data) }

  def main(args: Array[String]) {
    // val conn = base.getConnection()
    // var data = loadData(conn, 123)
    // saveData(conn, data)

    val base = new Provider()
    implicit val conn = base.getConnection()
    var data = loadData(123)
    saveData(data)
  }
}
