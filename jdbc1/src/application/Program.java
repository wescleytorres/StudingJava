package application;

import java.sql.Connection;
// import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
// import java.text.ParseException;
// import java.text.SimpleDateFormat;
// import java.sql.ResultSet;

import db.DB;
import db.DbException;
// import db.DbIntegrityException;

public class Program {

  public static void main(String[] args) {

    Connection conn = null;
    // PreparedStatement st = null;
    Statement st = null;

    /*
     * ---------------------------- RECUPERACAO DE DADOS
     * ----------------------------
     * 
     * Connection conn = null;
     * Statement st = null;
     * ResultSet rs = null;
     * 
     * try {
     * conn = DB.getConnection();
     * st = conn.createStatement();
     * rs = st.executeQuery("select * from department");
     * while (rs.next()) {
     * System.out.println(rs.getInt("Id") + ", " + rs.getString("Name"));
     * 
     * }
     * } catch (SQLException e) {
     * e.printStackTrace();
     * } finally {
     * DB.closeResultSet(rs);
     * DB.closeStatement(st);
     * DB.closeConnection();
     * }
     */

    /*
     * --------------------------- INSERCAO DE DADOS -----------------------------
     */

    // SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    // try {
    // conn = DB.getConnection();
    // st = conn.prepareStatement(
    // "INSERT INTO seller "
    // + "(Name, Email, BirthDate, BaseSalary, DepartmentId) "
    // + "VALUES"
    // + "(?, ?, ?, ?, ?)",
    // Statement.RETURN_GENERATED_KEYS);

    // st.setString(1, "Carl Purple");
    // st.setString(2, "carl@gmail.com");
    // st.setDate(3, new java.sql.Date(sdf.parse("22/04/1985").getTime()));
    // st.setDouble(4, 3000.0);
    // st.setInt(5, 4);

    /*
     * ==> INSERCAO MAIS DE UM ID <==
     * 
     * st = conn.prepareStatement(
     * "insert into department (Name) values ('D1'),('D2')",
     * Statement.RETURN_GENERATED_KEYS);
     */

    // int rowsAffected = st.executeUpdate();

    // if (rowsAffected > 0) {
    // ResultSet rs = st.getGeneratedKeys();

    // while (rs.next()) {
    // int id = rs.getInt(1);
    // System.out.println("Done! Id = " + id);
    // }
    // } else {
    // System.out.println("No rows affected!");
    // }

    // System.out.println("Done! rows affected: " + rowsAffected);

    // } catch (SQLException e) {
    // e.printStackTrace();
    // } catch (ParseException e) {
    // e.printStackTrace();
    // } finally {
    // DB.closeStatement(st);
    // DB.closeConnection();
    // }

    /* --------------------------- UPDATE DE DADOS ----------------------------- */

    // try {
    // conn = DB.getConnection();

    // st = conn.prepareStatement(
    // "UPDATE seller "
    // + "SET BaseSalary = BaseSalary + ? "
    // + "WHERE "
    // + "(DepartmentId = ?)");

    // st.setDouble(1, 200.0);
    // st.setInt(2, 2);

    // int rowsAffected = st.executeUpdate();

    // System.out.println("Done! Rows affected: " + rowsAffected);
    // } catch (SQLException e) {
    // e.printStackTrace();
    // } finally {
    // DB.closeStatement(st);
    // DB.closeConnection();
    // }

    /* --------------------------- DELETE DE DADOS ----------------------------- */

    // try {
    // conn = DB.getConnection();

    // st = conn.prepareStatement(
    // "DELETE FROM department "
    // + "WHERE "
    // + "Id = ?");

    // st.setInt(1, 2);

    // int rowsAffected = st.executeUpdate();

    // System.out.println("Done! Rows affected: " + rowsAffected);

    // } catch (SQLException e) {

    // throw new DbIntegrityException(e.getMessage());

    // } finally {

    // DB.closeStatement(st);
    // DB.closeConnection();

    // }

    /*
     * --------------------------- TRANSACTION DE DADOS
     * -----------------------------
     */

    try {
      conn = DB.getConnection();

      // a transacao sera confirmada manualmente
      conn.setAutoCommit(false);

      st = conn.createStatement();

      int rows1 = st.executeUpdate("UPDATE seller SET BaseSalary = 2090 WHERE DepartmentId = 1");

      // int x = 1;
      // if (x < 2) {
      // throw new SQLException("Fake error");
      // }

      int rows2 = st.executeUpdate("UPDATE seller SET BaseSalary = 3090 WHERE DepartmentId = 2");

      // informando confirmacao
      conn.commit();

      System.out.println("rows1 = " + rows1);
      System.out.println("rows2 = " + rows2);
    } catch (SQLException e) {
      try {
        // a transacao retorna
        conn.rollback();
        throw new DbException("Transaction rolled back! Caused by: " + e.getMessage());
      } catch (SQLException e1) {
        throw new DbException("Error trying to rollback! Caused by: " + e1.getMessage());
      }
    } finally {
      DB.closeStatement(st);
      DB.closeConnection();
    }

  }
}
