package parking_system;

import java.sql.*;
import javax.swing.JOptionPane;
public class SQLDeleteTable {
  public SQLDeleteTable (String n,String n1,String n2,String n3,String n4) {
    Connection theConn = null; String SQL;
    try {
      SQLConnection  MyCon = new SQLConnection(n1,n2,n3,n4);
      theConn = MyCon.getConnection("car_parking");
      Statement stmt = theConn.createStatement();      
      SQL = "delete from member where ID='" + n + "'";
      stmt.executeUpdate(SQL);
        JOptionPane.showMessageDialog(null, "Delete Successful");
    }
    catch (SQLException ex) {
      System.out.println(ex);
    }
    finally {
      try {
        if (theConn != null) theConn.close();
      }
      catch (Exception e) {
      }
    }
  }
}