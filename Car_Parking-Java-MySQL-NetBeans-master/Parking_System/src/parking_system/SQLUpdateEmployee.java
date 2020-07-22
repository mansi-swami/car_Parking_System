package parking_system;

import java.sql.*;
import javax.swing.JOptionPane;
public class SQLUpdateEmployee {
    String address,port,user,pass;
  public SQLUpdateEmployee(String n1,String n2,String n3,String n4,String g0,String g1, String g2,String g3,String g4, String g5,String g6){
      address = n1;
      port = n2;
      user = n3;
      pass = n4;
      Connection theConn = null; String SQL;
        try {
            SQLConnection  MyCon = new SQLConnection(n1,n2,n3,n4);
            theConn = MyCon.getConnection("car_parking");
            Statement stmt = theConn.createStatement();      
            SQL = "update employee set name='"+ g1 + "', "
                + "age='" + g2 +"', " + "gender='" + g3 +"', " + "phone='" + g4 +"', " + "address='" + g5 +"', " + "rank='"+ g6 +"' where user='"+ g0 +"'";
      stmt.executeUpdate(SQL);
        JOptionPane.showMessageDialog(null, "Data Edited");
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