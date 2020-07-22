package parking_system;

import java.sql.*;
import javax.swing.JOptionPane;
public class SQLInsertTable {
  public SQLInsertTable (String n1,String n2,String n3,String n4,String g1, String g2,String g3,String g4, String g5,String g6,String g7, String g8,String g9,String g10, String g11,String g12,String g13,String g14,String g15,byte[] photo) {
    Connection theConn = null; String SQL;
    try {
      SQLConnection  MyCon = new SQLConnection(n1,n2,n3,n4);
      theConn = MyCon.getConnection("car_parking");
      Statement stmt = theConn.createStatement();
      SQL = "insert into member (Name,Gender,Birth_Date,Address,City,Province,ZIP_Code,Phone,Email,Car_Brand,Car_Model,Car_Color,License_Plate,Reg_Date,Exp_Date,Photo) values "
              + "('" + g1 + "','" + g2 + "','"+ g3 +"','" + g4 + "','" + g5 + "','"+ g6 +"','" + g7 + "','" + g8 + "','"+ g9 +"','" + g10 + "','" + g11 + "','"+ g12 +"','"+ g13 +"','"+ g14 +"','"+ g15 +"','"+ photo+"')";  
      stmt.executeUpdate(SQL); 
        JOptionPane.showMessageDialog(null, "Adding Successful");
    }
    catch (SQLException ex) {
      JOptionPane.showMessageDialog(null, ex);
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