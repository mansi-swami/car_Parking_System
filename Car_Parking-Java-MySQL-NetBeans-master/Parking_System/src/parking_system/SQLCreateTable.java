package parking_system;

import java.sql.*;
import javax.swing.*;
public class SQLCreateTable {
    
  public SQLCreateTable(String tname,String a,String b,String f,String d) {
    
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
        if (tname.equals("member")) {
              SQL = "create table member (ID int not null auto_increment,"
                      + "Name varchar(30),"
                      + "Gender varchar(15),"
                      + "Birth_Date varchar(12),"
                      + "Address varchar(30),"
                      + "City varchar(20),"
                      + "Province varchar(20),"
                      + "ZIP_Code varchar(10),"
                      + "Phone varchar(20),"
                      + "Email varchar(30),"
                      + "Car_Brand varchar(15),"
                      + "Car_Model varchar(15),"
                      + "Car_Color varchar(15),"
                      + "License_Plate varchar(15),"
                      + "Reg_Date varchar(12),"
                      + "Exp_Date varchar(12),"
                      + "Photo BLOB,"
                      + "primary key (ID))";
              
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