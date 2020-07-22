package parking_system;

import java.sql.*;
import javax.swing.JOptionPane;
public class SQLUpdateTable {
  public SQLUpdateTable(String n1,String n2,String n3,String n4,String ind,String g1, String g2,String g3,String g4, String g5,String g6,String g7, String g8,String g9,String g10, String g11,String g12, String g13,String g14,byte[] a15){
    Connection theConn = null; String SQL;
    try {
      SQLConnection  MyCon = new SQLConnection(n1,n2,n3,n4);
      theConn = MyCon.getConnection("car_parking");
      Statement stmt = theConn.createStatement();      
      SQL = "update member set Name='"+ g1 + "', "
          + "Gender='" + g2 +"', " + "Birth_Date='" + g3 +"', " + "Address='" + g4 +"', " + "City='" + g5 +"', " + "Province='" + g6 +"', " + "ZIP_Code='" + g7 +"', " + "Phone='" + g8 +"', " + "Email='" + g9 +"', " 
          + "Car_Brand='" + g10 +"', " + "Car_Model='" + g11 +"', " + "Car_Color='" + g12 +"', " + "License_Plate='" + g13 +"', " + "Exp_Date='" + g14 +"', Photo='"+a15+"' "
          + " where ID='"+ ind +"'";
      stmt.executeUpdate(SQL);
        JOptionPane.showMessageDialog(null, "Update Successful");
    }
    catch (SQLException ex) {
      System.out.println(ex);
    }
    finally {
      try {
        if (theConn != null) theConn.close();
      }
      catch (SQLException e) {
      }
    }
  }
}