

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.jdbc.JdbcDialects


object SparkDrillJdbcTest {

  case object DrillDialect extends org.apache.spark.sql.jdbc.JdbcDialect {

    override def canHandle(url: String): Boolean = url.startsWith("jdbc:drill")

    override def quoteIdentifier(colName: String): String = {
      s"`$colName`"
    }
  }

  def main(args: Array[String]) {


    val spark = SparkSession.builder()
      .appName("Spark Drill JDBC Example")
      .getOrCreate()

    val drillDialect=DrillDialect

    JdbcDialects.registerDialect(drillDialect)

    // connect to the database named "mysql" on the localhost
    val driver = "org.apache.drill.jdbc.Driver"
    val url = "jdbc:drill:drillbit=10.10.72.72:31010"
    val username = "mapr"
    val password = "mapr"

    val query = "(select `version`,`commit_id` from sys.version) version_info"

    val df = spark.read.format("jdbc").
        option("url", url).
        option("driver", driver).
        option("useUnicode", "true").
        option("continueBatchOnError","true").
        option("useSSL", "false").
        option("user", username).
        option("password", password).
        option("dbtable", query).
        load()
    df.show()

  }

}
