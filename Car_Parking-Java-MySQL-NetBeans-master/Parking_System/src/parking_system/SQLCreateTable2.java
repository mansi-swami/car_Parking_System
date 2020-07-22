package parking_system;

import java.sql.*;
import javax.swing.*;
public class SQLCreateTable2{
    
  public SQLCreateTable2(String tname,String a,String b,String f,String d) {
    
    Connection c;    SQLConnection MyCon;
    Statement stmt;  String SQL="";
    ResultSet rs;    DatabaseMetaData md;
    boolean found=false; String msg="";
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
        if (tname.equals("employee")) {
              SQL = "create table employee (user varchar(10),password varchar(10),name varchar(30),"
                  + "age varchar(10),gender varchar(10),phone varchar(20),address varchar(80),rank varchar(10),primary key (user))";
  
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
      JOptionPane.showMessageDialog(null,ex);
    }
  }
}