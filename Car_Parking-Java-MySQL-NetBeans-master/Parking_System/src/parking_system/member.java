package parking_system;

import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import net.proteanit.sql.DbUtils;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sulkiflee Masa
 */
public class member extends javax.swing.JFrame {

    /**
     * Creates new form member
     */
    String address,port,user,pass;
    String k1,k2,k3;
    
    public member(String a,String b,String c,String d,String c1,String c2,String c3) {
        
        run();
        initComponents();
        setTitle("Car Parking System");
        setResizable(false);
        address = a;    k1 = c1;
        port = b;       k2 = c2;
        user = c;       k3 = c3;
        pass = d;       
        connectDB();
        showcurent();
    }
    
    private void showcurent(){
        cur_user.setText(k1);
        rank_type.setText(k3);
        em_name.setText(k2);
    }
    private void connectDB(){
        
            try {
                
                Connection theConn;
                String SQL;
                SQLConnection  MyCon = new SQLConnection(address,port,user,pass);
                theConn = MyCon.getConnection("car_parking");
                Statement stmt = theConn.createStatement();    
                SQL = "select * from member order by ID";
                ResultSet rs = stmt.executeQuery(SQL);
                Table_member.setModel(DbUtils.resultSetToTableModel(rs));
            }catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,ex);
        }        
    }
    
    public void insertinDB(){
        
        String a1 = tname.getText();
        String a2 = gender;
        String a3 = ((JTextField)b_date.getDateEditor().getUiComponent()).getText();
        String a4 = taddress.getText();
        String a5 = tcity.getText();
        String a6 = tprovince.getText();
        String a7 = tzip.getText();
        String a8 = tphone.getText();
        String a9 = temail.getText();
        String a10 = tbrand.getText();
        String a11 = tmodel.getText();
        String a12 = tcolor.getText();
        String a13 = tlp.getText();
        String a14 = ((JTextField)reg_date.getDateEditor().getUiComponent()).getText();
        String a15 = ((JTextField)exp_date.getDateEditor().getUiComponent()).getText();
        
        if("".equals(a1)){
                JOptionPane.showMessageDialog(null,"Please Enter your Name");
            }else if(a2 == null){
                JOptionPane.showMessageDialog(null,"Please select your Genger");
            }else if("".equals(a3)){
                JOptionPane.showMessageDialog(null,"Please enter your date of birth");
            }else if("".equals(a4)){
                JOptionPane.showMessageDialog(null,"Please enter your address");                
            }else if("".equals(a5)){
                JOptionPane.showMessageDialog(null,"Please enter the City");
            }else if("".equals(a6)){
                JOptionPane.showMessageDialog(null,"Please enter the Province");
            }else if("".equals(a7)){
                JOptionPane.showMessageDialog(null,"Please enter ZIP Code");
            }else if("".equals(a8)){
                JOptionPane.showMessageDialog(null,"Please enter your Phone Number");
            }else if("".equals(a9)){
                JOptionPane.showMessageDialog(null,"Please enter your E-mail");
            }else if("".equals(a10)){
                JOptionPane.showMessageDialog(null,"Please enter the car's brand");
            }else if("".equals(a11)){
                JOptionPane.showMessageDialog(null,"Please enter the car's model");
            }else if("".equals(a12)){
                JOptionPane.showMessageDialog(null,"Please enter the car's color");
            }else if("".equals(a13)){
                JOptionPane.showMessageDialog(null,"Please enter the car's license plate");
            }else if("".equals(a14)){
                JOptionPane.showMessageDialog(null,"Please enter Registered date");
            }else if("".equals(a15)){
                JOptionPane.showMessageDialog(null,"Please enter Expired date");
            }else{
                
                int reply = JOptionPane.showConfirmDialog(null, "Name: "+a1+"\nGender: "+a2+"\n"
                             +"Birth Date: "+a3+"\n"
                             +"Address: "+a4+"\n"
                             +"City: "+a5+"\n"
                             +"Province: "+a6+"\n"
                             +"ZIP Code: "+a7+"\n"
                             +"Phone: "+a8+"\n"
                             +"Email: "+a9+"\n\n"
                             +"Car Brand: "+a10+"\n"
                             +"Car Model: "+a11+"\n"
                             +"Car Color: "+a12+"\n"
                             +"Car License Plate: "+a13+"\n"
                             +"Reg. Date: "+a14+"\n"
                             +"Exp. Date: "+a15, "Pleae comfirm your information!", JOptionPane.YES_NO_OPTION);  
                if (reply == JOptionPane.YES_OPTION){
                    SQLInsertTable i = new SQLInsertTable(address,port,user,pass,a1,a2,a3,a4,a5,a6,a7,a8,a9,a10,a11,a12,a13,a14,a15,photo);
                    ClearTextbox();
                }
            }
        
    }
    
    public void editdata(){
        
        
        String a0 = tid.getText();
        String a1 = tname.getText();
        String a2 = gender;
        String a3 = ((JTextField)b_date.getDateEditor().getUiComponent()).getText();
        String a4 = taddress.getText();
        String a5 = tcity.getText();
        String a6 = tprovince.getText();
        String a7 = tzip.getText();
        String a8 = tphone.getText();
        String a9 = temail.getText();
        String a10 = tbrand.getText();
        String a11 = tmodel.getText();
        String a12 = tcolor.getText();
        String a13 = tlp.getText();
        String a14 = ((JTextField)reg_date.getDateEditor().getUiComponent()).getText();
        String a15 = ((JTextField)exp_date.getDateEditor().getUiComponent()).getText();
        
        if("".equals(a1) || "".equals(a2) || "".equals(a3) || "".equals(a4) || "".equals(a5) || "".equals(a6) || "".equals(a7) || "".equals(a8)
                || "".equals(a9) || "".equals(a10) || "".equals(a11) || "".equals(a12) || "".equals(a13) || "".equals(a14) || "".equals(a15)){
            JOptionPane.showMessageDialog(null, "Please select the information or search it before you click Edit button");
        }else{
            if("".equals(a1)){
                JOptionPane.showMessageDialog(null,"Please Enter your Name");
            }else if(a2 == null){
                JOptionPane.showMessageDialog(null,"Please select your Genger");
            }else if("".equals(a3)){
                JOptionPane.showMessageDialog(null,"Please enter your date of birth");
            }else if("".equals(a4)){
                JOptionPane.showMessageDialog(null,"Please enter your address");                
            }else if("".equals(a5)){
                JOptionPane.showMessageDialog(null,"Please enter the City");
            }else if("".equals(a6)){
                JOptionPane.showMessageDialog(null,"Please enter the Province");
            }else if("".equals(a7)){
                JOptionPane.showMessageDialog(null,"Please enter ZIP Code");
            }else if("".equals(a8)){
                JOptionPane.showMessageDialog(null,"Please enter your Phone Number");
            }else if("".equals(a9)){
                JOptionPane.showMessageDialog(null,"Please enter your E-mail");
            }else if("".equals(a10)){
                JOptionPane.showMessageDialog(null,"Please enter the car's brand");
            }else if("".equals(a11)){
                JOptionPane.showMessageDialog(null,"Please enter the car's model");
            }else if("".equals(a12)){
                JOptionPane.showMessageDialog(null,"Please enter the car's color");
            }else if("".equals(a13)){
                JOptionPane.showMessageDialog(null,"Please enter the car's license plate");
            }else if("".equals(a14)){
                JOptionPane.showMessageDialog(null,"Please enter Registered date");
            }else if("".equals(a15)){
                JOptionPane.showMessageDialog(null,"Please enter Expired date");
            }else{
                
                int reply = JOptionPane.showConfirmDialog(null, "Name: "+a1+"\n"
                             +"Gender: "+a2+"\n"
                             +"Birth Date: "+a3+"\n"
                             +"Address: "+a4+"\n"
                             +"City: "+a5+"\n"
                             +"Province: "+a6+"\n"
                             +"ZIP Code: "+a7+"\n"
                             +"Phone: "+a8+"\n"
                             +"Email: "+a9+"\n\n"
                             +"Car Brand: "+a10+"\n"
                             +"Car Model: "+a11+"\n"
                             +"Car Color: "+a12+"\n"
                             +"Car License Plate: "+a13+"\n"
                             +"Exp. Date: "+a14, "Pleae comfirm your information!", JOptionPane.YES_NO_OPTION);  
                if (reply == JOptionPane.YES_OPTION){
                    SQLUpdateTable i = new SQLUpdateTable(address,port,user,pass,a0,a1,a2,a3,a4,a5,a6,a7,a8,a9,a10,a11,a12,a13,a14,photo);
                    ClearTextbox();
                }
            }  
        }
    }
    
    public void ClearTextbox(){
        tid.setText(null);
        tname.setText(null);
        jrMale.setSelected(false);
        jrFemale.setSelected(false);
        b_date.setDate(null);
        taddress.setText(null);
        tcity.setText(null);
        tprovince.setText(null);
        tzip.setText(null);
        tphone.setText(null);
        temail.setText(null);
        tbrand.setText(null);
        tmodel.setText(null);
        tcolor.setText(null);
        tlp.setText(null);
        reg_date.setDate(null);
        exp_date.setDate(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        search_group = new javax.swing.ButtonGroup();
        gen = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        phone_r = new javax.swing.JRadioButton();
        id_r = new javax.swing.JRadioButton();
        email_r = new javax.swing.JRadioButton();
        jButton6 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        tsearch = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tname = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jrMale = new javax.swing.JRadioButton();
        jrFemale = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        b_date = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        taddress = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        tcity = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        tprovince = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        tzip = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        tphone = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        temail = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        tbrand = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        tmodel = new javax.swing.JTextField();
        tcolor = new javax.swing.JTextField();
        tlp = new javax.swing.JTextField();
        reg_date = new com.toedter.calendar.JDateChooser();
        exp_date = new com.toedter.calendar.JDateChooser();
        tid = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jDesktopPane2 = new javax.swing.JDesktopPane();
        show_photo = new javax.swing.JLabel();
        im_input = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        cur_user = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        rank_type = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        em_name = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        Table_member = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 102, 0), null));

        jButton1.setBackground(new java.awt.Color(102, 0, 51));
        jButton1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Add");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(102, 0, 51));
        jButton2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Refresh");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(102, 0, 51));
        jButton3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Edit");
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(102, 0, 51));
        jButton4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Delete");
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(102, 0, 51));
        jButton5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Close");
        jButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton7.setBackground(new java.awt.Color(102, 0, 51));
        jButton7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setText("Clear");
        jButton7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setBackground(new java.awt.Color(102, 0, 51));
        jButton8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton8.setForeground(new java.awt.Color(255, 255, 255));
        jButton8.setText("Logout");
        jButton8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setBackground(new java.awt.Color(102, 0, 51));
        jButton9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton9.setForeground(new java.awt.Color(255, 255, 255));
        jButton9.setText("Login");
        jButton9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(16, 16, 16))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        search_group.add(phone_r);
        phone_r.setText("Phone");
        phone_r.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                phone_rItemStateChanged(evt);
            }
        });

        search_group.add(id_r);
        id_r.setText("License Plate");
        id_r.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                id_rItemStateChanged(evt);
            }
        });

        search_group.add(email_r);
        email_r.setText("Email");
        email_r.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                email_rItemStateChanged(evt);
            }
        });

        jButton6.setBackground(new java.awt.Color(102, 0, 51));
        jButton6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("Search");
        jButton6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel1.setText(" By: ");

        tsearch.setText("Search...");
        tsearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tsearchMouseClicked(evt);
            }
        });
        tsearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tsearchKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(tsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton6))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(8, 8, 8)
                        .addComponent(id_r)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(phone_r)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(email_r)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton6)
                    .addComponent(tsearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(id_r)
                    .addComponent(phone_r)
                    .addComponent(email_r)))
        );

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jPanel4.setBackground(new java.awt.Color(102, 0, 102));
        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel4.setForeground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Customer ID: ");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Name: ");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Gender: ");

        gen.add(jrMale);
        jrMale.setForeground(new java.awt.Color(255, 255, 255));
        jrMale.setText("Male");
        jrMale.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jrMaleItemStateChanged(evt);
            }
        });

        gen.add(jrFemale);
        jrFemale.setForeground(new java.awt.Color(255, 255, 255));
        jrFemale.setText("Female");
        jrFemale.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jrFemaleItemStateChanged(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Birth Date: ");

        b_date.setDateFormatString("yyyy-MM-dd");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Address: ");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("City: ");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Province: ");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("ZIP Code: ");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Phone: ");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Email: ");

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Exp. Date: ");

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Reg. Date: ");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("License Plate:");

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Color: ");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Model: ");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Brand: ");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Car Information");

        reg_date.setDateFormatString("yyyy-MM-dd");

        exp_date.setDateFormatString("yyyy-MM-dd");

        tid.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tid.setForeground(new java.awt.Color(102, 0, 0));

        jPanel5.setBackground(new java.awt.Color(204, 204, 204));

        show_photo.setBackground(new java.awt.Color(255, 255, 255));

        jDesktopPane2.setLayer(show_photo, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane2Layout = new javax.swing.GroupLayout(jDesktopPane2);
        jDesktopPane2.setLayout(jDesktopPane2Layout);
        jDesktopPane2Layout.setHorizontalGroup(
            jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(show_photo, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jDesktopPane2Layout.setVerticalGroup(
            jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(show_photo, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jDesktopPane2)
                .addContainerGap())
        );

        im_input.setBackground(new java.awt.Color(102, 0, 51));
        im_input.setForeground(new java.awt.Color(255, 255, 255));
        im_input.setText("Choose");
        im_input.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        im_input.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                im_inputActionPerformed(evt);
            }
        });

        jPanel6.setBackground(new java.awt.Color(204, 255, 204));
        jPanel6.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(0, 153, 51), null, null));

        jButton12.setBackground(new java.awt.Color(102, 0, 51));
        jButton12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton12.setForeground(new java.awt.Color(255, 255, 255));
        jButton12.setText("Statistics");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jButton13.setBackground(new java.awt.Color(102, 0, 51));
        jButton13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton13.setForeground(new java.awt.Color(255, 255, 255));
        jButton13.setText("Car Check In/Out");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton13)
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Login as: ");

        cur_user.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cur_user.setForeground(new java.awt.Color(255, 255, 255));

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Rank:");

        rank_type.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        rank_type.setForeground(new java.awt.Color(255, 255, 255));

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Employee Name: ");

        em_name.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        em_name.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(im_input)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jrMale)
                            .addComponent(jrFemale)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(tname, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, Short.MAX_VALUE))
                            .addComponent(b_date, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel19)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cur_user, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel20)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rank_type, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tid))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel21)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(em_name)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(328, 328, 328)
                        .addComponent(jLabel12))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel8)
                                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                                        .addGap(11, 11, 11)
                                                        .addComponent(jLabel7)))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(tcity)
                                                    .addComponent(tprovince, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addComponent(jLabel9)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(tzip, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                            .addComponent(jLabel6)
                                            .addGap(18, 18, 18)
                                            .addComponent(taddress, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                        .addGap(7, 7, 7)
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel10)
                                            .addComponent(jLabel11))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(tphone)
                                            .addComponent(temail, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(17, 17, 17)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addComponent(jLabel16)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(jLabel14)
                                                    .addComponent(jLabel15))
                                                .addGap(18, 18, 18)))
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(tcolor)
                                            .addComponent(tmodel)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                                .addGap(2, 2, 2)
                                                .addComponent(tlp, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel18)
                                            .addComponent(jLabel17))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(reg_date, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(exp_date, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGap(25, 25, 25)
                                        .addComponent(jLabel13)
                                        .addGap(18, 18, 18)
                                        .addComponent(tbrand, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addGap(20, 20, 20))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(cur_user)
                    .addComponent(jLabel20)
                    .addComponent(rank_type))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(em_name))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tid))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(b_date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jrMale))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jrFemale)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(im_input)
                        .addContainerGap())
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(0, 3, Short.MAX_VALUE)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel12)
                .addGap(1, 1, 1)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(tbrand, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(tmodel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tcolor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(tlp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel18))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(reg_date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(exp_date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(5, 5, 5))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(taddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(tcity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(tprovince, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(tzip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tphone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(temail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(6, 6, 6))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(2209, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(390, Short.MAX_VALUE))
        );

        jScrollPane2.setViewportView(jPanel2);

        Table_member.setBackground(new java.awt.Color(51, 153, 255));
        Table_member.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        Table_member.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Table_member.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Table_memberMouseClicked(evt);
            }
        });
        Table_member.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Table_memberKeyReleased(evt);
            }
        });
        jScrollPane4.setViewportView(Table_member);

        jMenu1.setText("File");

        jMenuItem2.setText("Exit");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        jMenu3.setText("About");

        jMenuItem3.setText("About");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem3);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 1, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 798, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 9, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        setSize(new java.awt.Dimension(1085, 598));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        editdata();
        connectDB();
        
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void tsearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tsearchMouseClicked
        // TODO add your handling code here:
        tsearch.setText(null);
    }//GEN-LAST:event_tsearchMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        insertinDB();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        ClearTextbox();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        connectDB();
        ClearTextbox();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void Table_memberMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Table_memberMouseClicked
        // TODO add your handling code here:
        tableEvent();
    }
        
        
        
    private void tableEvent(){    
        try{
            int row = Table_member.getSelectedRow();
            String Table_Click = (Table_member.getModel().getValueAt(row, 0).toString());
            SQLConnection  MyCon = new SQLConnection(address,port,user,pass);
                Connection theConn;
                String SQL;
                theConn = MyCon.getConnection("car_parking");
                Statement stmt = theConn.createStatement();    
                SQL = "select * from member where ID='" + Table_Click + "'"; 
                ResultSet rs = stmt.executeQuery(SQL);
                if(rs.next()){
                    int add1 = rs.getInt("ID");
                    String add = String.valueOf(add1);
                    tid.setText(add);
                    
                    String add_gen = rs.getString("Gender");
                    if("Male".equals(add_gen)){
                        jrMale.setSelected(true);
                    }else{
                        jrFemale.setSelected(true);
                    }
                    String add2 = rs.getString("Name");
                    tname.setText(add2);
                    
                    Date add4 = rs.getDate("Birth_Date");
                    b_date.setDate(add4);
                    String add5 = rs.getString("Address");
                    taddress.setText(add5);
                    String add6 = rs.getString("City");
                    tcity.setText(add6);
                    String add7 = rs.getString("Province");
                    tprovince.setText(add7);
                    String add8 = rs.getString("ZIP_Code");
                    tzip.setText(add8);
                    String add9 = rs.getString("Phone");
                    tphone.setText(add9);
                    String add0 = rs.getString("Email");
                    temail.setText(add0);
                    String add10 = rs.getString("Car_Brand");
                    tbrand.setText(add10);
                    String add11 = rs.getString("Car_Model");
                    tmodel.setText(add11);
                    String add12 = rs.getString("Car_Color");
                    tcolor.setText(add12);
                    String add13 = rs.getString("License_Plate");
                    tlp.setText(add13);
                    Date add14 = rs.getDate("Reg_Date");
                    reg_date.setDate(add14);
                    Date add15 = rs.getDate("Exp_Date");
                    exp_date.setDate(add15);
                    
                    byte[] imagedata = rs.getBytes("Photo");
                    format = new ImageIcon(imagedata);
                    show_photo.setIcon(format);
                    
                    
                    
                }
            
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_Table_memberMouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        
        
        String a0 = tid.getText();
        String a1 = tname.getText();
        String a2 = gender;
        String a3 = ((JTextField)b_date.getDateEditor().getUiComponent()).getText();
        String a4 = taddress.getText();
        String a5 = tcity.getText();
        String a6 = tprovince.getText();
        String a7 = tzip.getText();
        String a8 = tphone.getText();
        String a9 = temail.getText();
        String a10 = tbrand.getText();
        String a11 = tmodel.getText();
        String a12 = tcolor.getText();
        String a13 = tlp.getText();
        String a14 = ((JTextField)reg_date.getDateEditor().getUiComponent()).getText();
        String a15 = ((JTextField)exp_date.getDateEditor().getUiComponent()).getText();
       if("".equals(a1) || "".equals(a2) || "".equals(a3) || "".equals(a4) || "".equals(a5) || "".equals(a6) || "".equals(a7) || "".equals(a8)
                || "".equals(a9) || "".equals(a10) || "".equals(a11) || "".equals(a12) || "".equals(a13) || "".equals(a14) || "".equals(a15)){
            JOptionPane.showMessageDialog(null, "Please select the information or search it before you click Delete button");
        }else{
            int reply = JOptionPane.showConfirmDialog(null, "ID: "+tid.getText()+"\n"
                             +"Name: "+tname.getText()+"\n"
                             +"Gender: "+gender+"\n"
                             +"Birth Date: "+a3+"\n"
                             +"Address: "+taddress.getText()+"\n"
                             +"City: "+tcity.getText()+"\n"
                             +"Province: "+tprovince.getText()+"\n"
                             +"ZIP Code: "+tzip.getText()+"\n"
                             +"Phone: "+tphone.getText()+"\n"
                             +"Email: "+temail.getText()+"\n\n"
                             +"Car Brand: "+tbrand.getText()+"\n"
                             +"Car Model: "+tmodel.getText()+"\n"
                             +"Car Color: "+tcolor.getText()+"\n"
                             +"Car License Plate: "+tlp.getText()+"\n"
                             +"Reg. Date: "+reg_date.getDate()+"\n"
                             +"Exp. Date: "+exp_date.getDate(), "Comfirm to delete", JOptionPane.YES_NO_OPTION);  
            if (reply == JOptionPane.YES_OPTION){
                SQLDeleteTable godel = new SQLDeleteTable(tid.getText(),address,port,user,pass);
                ClearTextbox();
            }
       }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void id_rItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_id_rItemStateChanged
        // TODO add your handling code here:
        rs_search = "License_Plate";
    }//GEN-LAST:event_id_rItemStateChanged

    private void phone_rItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_phone_rItemStateChanged
        // TODO add your handling code here:
        rs_search = "Phone";
    }//GEN-LAST:event_phone_rItemStateChanged

    private void email_rItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_email_rItemStateChanged
        // TODO add your handling code here:
        rs_search = "Email";
    }//GEN-LAST:event_email_rItemStateChanged

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        search_data();
    }
    
    private void search_data(){
        if(rs_search == null){
                JOptionPane.showMessageDialog(null, "Please select Search By");
            }else{
                String gsearch = tsearch.getText();
                try{
                    SQLConnection  MyCon = new SQLConnection(address,port,user,pass);
                    Connection theConn;
                    String SQL;
                    theConn = MyCon.getConnection("car_parking");
                    Statement stmt = theConn.createStatement();    
                    SQL = "select * from member where "+ rs_search +"='" + gsearch + "'"; 
                    ResultSet rs = stmt.executeQuery(SQL);
                        
                        int add1;
                        
                    if(rs.next()){
                        add1 = rs.getInt("ID");
                        String add = String.valueOf(add1);
                        tid.setText(add);
                    
                        String add2 = rs.getString("Name");
                        tname.setText(add2);
                    
                        Date add4 = rs.getDate("Birth_Date");
                        b_date.setDate(add4);
                        String add5 = rs.getString("Address");
                        taddress.setText(add5);
                        String add6 = rs.getString("City");
                        tcity.setText(add6);
                        String add7 = rs.getString("Province");
                        tprovince.setText(add7);
                        String add8 = rs.getString("ZIP_Code");
                        tzip.setText(add8);
                        String add9 = rs.getString("Phone");
                        tphone.setText(add9);
                        String add0 = rs.getString("Email");
                        temail.setText(add0);
                        String add10 = rs.getString("Car_Brand");
                        tbrand.setText(add10);
                        String add11 = rs.getString("Car_Model");
                        tmodel.setText(add11);
                        String add12 = rs.getString("Car_Color");
                        tcolor.setText(add12);
                        String add13 = rs.getString("License_Plate");
                        tlp.setText(add13);
                        Date add14 = rs.getDate("Reg_Date");
                        reg_date.setDate(add14);
                        Date add15 = rs.getDate("Exp_Date");
                        exp_date.setDate(add15);
                        
                        byte[] imagedata = rs.getBytes("Photo");
                        format = new ImageIcon(imagedata);
                        show_photo.setIcon(format);
                        
                    
                }else{
                        JOptionPane.showMessageDialog(null, "Result not found!");
                    }
            
            
        }catch( HeadlessException | SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }       
                
            }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, "Program by: MADHUR RASTOGI\n                       "
                + "SOFTECH PTV LTD\n                       "
                + "MORADABAD UTTAR PRADESH\n                       ");
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        new login(address,port,user,pass).setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        new login(address,port,user,pass).setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jrFemaleItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jrFemaleItemStateChanged
        // TODO add your handling code here:
        gender = "Female";
    }//GEN-LAST:event_jrFemaleItemStateChanged

    private void jrMaleItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jrMaleItemStateChanged
        // TODO add your handling code here:
        gender = "Male";
    }//GEN-LAST:event_jrMaleItemStateChanged

    private void im_inputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_im_inputActionPerformed
        // TODO add your handling code here:
        JFileChooser ch = new JFileChooser();
        ch.showOpenDialog(null);
        File f = ch.getSelectedFile();
        filename = f.getAbsolutePath();
        
        
        try{
            
            File image = new File(filename);
            FileInputStream fs = new FileInputStream(image);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] buf = new byte[1024];
            for(int readNum; (readNum=fs.read(buf)) != -1;){
                bos.write(buf,0,readNum);
            }
            photo = bos.toByteArray();
            
        }catch(IOException e){
            e.printStackTrace();
        }
        
    }//GEN-LAST:event_im_inputActionPerformed

    private void Table_memberKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Table_memberKeyReleased
        // TODO add your handling code here:
        if(evt.getKeyCode() == KeyEvent.VK_DOWN || evt.getKeyCode() == KeyEvent.VK_UP){
            tableEvent();
        }
    }//GEN-LAST:event_Table_memberKeyReleased

    private void tsearchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tsearchKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            search_data();
        }
    }//GEN-LAST:event_tsearchKeyPressed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        // TODO add your handling code here:
        new Car_IO(address, port, user, pass).setVisible(true);
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // TODO add your handling code here:
        new Statistics(address, port, user, pass).setVisible(true);
    }//GEN-LAST:event_jButton12ActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
    private void run(){
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(member.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }
        //</editor-fold>

        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                SQLConnection MyCon = new SQLConnection();
//                MyCon.CreateDB("car_parking");
//                SQLCreateTable t = new SQLCreateTable("member");
//                new member().setVisible(true);
//            }
//        });       
//    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Table_member;
    private com.toedter.calendar.JDateChooser b_date;
    private javax.swing.JLabel cur_user;
    private javax.swing.JLabel em_name;
    private javax.swing.JRadioButton email_r;
    private com.toedter.calendar.JDateChooser exp_date;
    private javax.swing.ButtonGroup gen;
    private javax.swing.JRadioButton id_r;
    private javax.swing.JButton im_input;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JDesktopPane jDesktopPane2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JRadioButton jrFemale;
    private javax.swing.JRadioButton jrMale;
    private javax.swing.JRadioButton phone_r;
    private javax.swing.JLabel rank_type;
    private com.toedter.calendar.JDateChooser reg_date;
    private javax.swing.ButtonGroup search_group;
    private javax.swing.JLabel show_photo;
    private javax.swing.JTextField taddress;
    private javax.swing.JTextField tbrand;
    private javax.swing.JTextField tcity;
    private javax.swing.JTextField tcolor;
    private javax.swing.JTextField temail;
    private javax.swing.JLabel tid;
    private javax.swing.JTextField tlp;
    private javax.swing.JTextField tmodel;
    private javax.swing.JTextField tname;
    private javax.swing.JTextField tphone;
    private javax.swing.JTextField tprovince;
    private javax.swing.JTextField tsearch;
    private javax.swing.JTextField tzip;
    // End of variables declaration//GEN-END:variables
    String gender,rs_search;
    private ImageIcon format = null;
    String filename = null;
    int s = 0;
    byte[] photo = null;
}
