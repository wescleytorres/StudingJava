package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DB {

  private static Connection conn = null;

  public static Connection getConnection() {
    if (conn == null) {
      try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Properties props = loadProperties();
        String url = props.getProperty("dburl");
        conn = DriverManager.getConnection(url, props);
      } catch (SQLException e) {
        throw new DbException(e.getMessage());
      } catch (ClassNotFoundException e) {
        throw new DbException(e.getMessage());
      }
    }
    return conn;
  }

  public static void closeConnection() {
    if (conn != null) {
      try {
        conn.close();
      } catch (SQLException e) {
        throw new DbException(e.getMessage());
      }
    }
  }

  private static Properties loadProperties() {
    // fazendo leitura de properties e guardando no obj props
    try (FileInputStream fs = new FileInputStream("db.properties")) {
      Properties props = new Properties();
      props.load(fs);
      return props;
    } catch (IOException e) {
      throw new DbException(e.getMessage());
    }
  }
}
