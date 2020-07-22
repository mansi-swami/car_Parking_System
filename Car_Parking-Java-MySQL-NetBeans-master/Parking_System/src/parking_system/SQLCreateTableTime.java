package parking_system;

import java.sql.*;
import javax.swing.*;
public class SQLCreateTableTime {
    
  public SQLCreateTableTime(String tname,String a,String b,String f,String d) {
    
    Connection c;    SQLConnection MyCon;
    Statement stmt;  String SQL="";
    ResultSet rs;    DatabaseMetaData md;
    boolean found=false; String msg;
    try {
      MyCon = new SQLConnection(a,b,f,d);
      c = MyCon.getConnection("car_parking");
      md = c.getMetaData();
      rs = md.getTables(null, null, "%", null);
      while (rs.next()) {
        if (rs.getString(3).equals(tname)) {
          found = true;
          break;
        }
      }
      stmt = c.createStatement();
      if (!found) {
        if (tname.equals("time")) {
              SQL = "create table time (num int not null auto_increment,"
                      + "In_time varchar(30),"
                      + "Out_time varchar(30),"
                      + "Date varchar(12),"
                      + "License_Plate varchar(15),"
                      + "primary key (num))";
              
        }
        stmt.executeUpdate(SQL);
        md = c.getMetaData();
        rs = md.getTables(null, null, "%", null);
        msg = "Table >>> ";
        while (rs.next()) {
          if (rs.getString(3).equals(tname)) {
              msg = msg+rs.getString(3).toUpperCase();
              break;
          }
        }
        msg = msg+" is Created";
        JOptionPane.showMessageDialog(null, msg);
      }
      
    }
    catch (SQLException ex) {
      System.out.println(ex);
    }
  }
}