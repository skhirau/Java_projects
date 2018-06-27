/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myStore;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import java.util.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author skh
 */
public class GenerateBill extends javax.swing.JInternalFrame {
    boolean flag = true;
    DefaultTableModel dtm;
    float billAmount = 0;
    /**
     * Creates new form PlaceOrder
     */
    public GenerateBill() {
        initComponents();
        addIntoComboBox1();
        Calendar c = Calendar.getInstance();
        jDateChooser1.setCalendar(c);
        dtm = (DefaultTableModel) jTable1.getModel();
    }
    
    private void addIntoComboBox1()
    {
        flag = false;
        DefaultComboBoxModel dcbm1 = (DefaultComboBoxModel) jComboBox1.getModel();
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        String sql;
        try
        {
            try
            {
                Class.forName("java.sql.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/store","root","admin");
                st = con.createStatement();
                
                sql = "select max(billno) as mx from bills;";
                rs = st.executeQuery(sql);
                if(rs.next())
                {
                    tf1.setText("" + (rs.getInt("mx")+1));
                }
                else
                    tf1.setText("1");
                rs.close();
                
                sql = "select count(*) as cnt from packeditemdetails ;";
                rs = st.executeQuery(sql);
                int cnt;
                if(rs.next())
                {    
                    cnt = rs.getInt("cnt");
                    rs.close();
                }
                else
                {
                    JOptionPane.showMessageDialog(this, "No items to sell.");
                    if(!rs.isClosed())
                    rs.close();
                    if(!st.isClosed())
                    st.close();
                    if(!con.isClosed())
                    con.close();
                    return;
                }
                
                
                int pino[] = new int[cnt];
                float sp1unit[] = new float[cnt];
                int i = 0; //for looping;

                sql = "select * from packeditemdetails order by pino asc;";
                rs = st.executeQuery(sql);
                dcbm1.removeAllElements();
                dcbm1.addElement("--Select--");
                while(rs.next())
                {
                    if(rs.getFloat("sp1unit") == 0)
                    {
                        if(rs.getString("sp1unit").equals("null"))
                        {
                            JOptionPane.showMessageDialog(this,"sp1unit is null");
                            //continue;
                        }
                        continue;
                    }
                    
                    pino[i] = rs.getInt("pino");
                    sp1unit[i] = rs.getFloat("sp1unit");
                    
                    i++;
                }
                rs.close();
                
                for(int j = 0 ; j < i ; j++)
                {
                    sql = "select * from packeditems where pino = " + pino[j] + 
                            ";";
                    rs = st.executeQuery(sql);
                    rs.next();
                    dcbm1.addElement("" + rs.getString("itemname") + "   ," + 
                            "price :" + sp1unit[j]);
                }
                
                jComboBox1.setSelectedIndex(0);
                flag = true;
                
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(this,e.getMessage());
            }
            finally
            {
                if(!rs.isClosed())
                rs.close();
                if(!st.isClosed())
                st.close();
                if(!con.isClosed())
                con.close();
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this,"Badi Gadbad.");
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tf1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        tf4 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        tf5 = new javax.swing.JTextField();
        tf2 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        tf3 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        tf6 = new javax.swing.JTextField();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Generate Bill", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 36))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Bill no : ");

        tf1.setEditable(false);
        tf1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setText("Date : ");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Enter Customer name : ");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Select items available : ");

        jComboBox1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel());
        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setText("Add to Bill");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton2.setText("Remove from Bill");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("Quantity Available  : ");

        tf4.setEditable(false);
        tf4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        tf4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tf4KeyTyped(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setText("Enter quantity to purchase : ");

        tf5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        tf5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf5ActionPerformed(evt);
            }
        });
        tf5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tf5KeyTyped(evt);
            }
        });

        tf2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        tf2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tf2KeyTyped(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setText("mobno.");

        tf3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        tf3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tf3KeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tf2, javax.swing.GroupLayout.PREFERRED_SIZE, 649, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tf3, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 523, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1)
                        .addGap(78, 78, 78)
                        .addComponent(jButton2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tf4, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tf5, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tf3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tf4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tf5, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jTable1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "S.no.", "Product name", "Selling price of 1 unit", "Quantity purchased", "Total Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setRowHeight(20);
        jTable1.setRowMargin(2);
        jScrollPane1.setViewportView(jTable1);

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton3.setText("Generate Bill");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton4.setText("  Clear  ");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton5.setText("  Close  ");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setText("Total Bill Amount : ");

        tf6.setEditable(false);
        tf6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        tf6.setText(" ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf1, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jButton3)
                        .addGap(354, 354, 354)
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton5)
                        .addGap(221, 221, 221))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf6, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tf1, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf6, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton4)
                    .addComponent(jButton5))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
        if(flag == false)
            return;
        if(jComboBox1.getSelectedIndex() == 0)
            return;
        
        tf4.setText("");
        tf5.setText("");
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        String sql;
        try
        {
            try
            {
                Class.forName("java.sql.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/store","root","admin");
                st = con.createStatement();
                
                
                String str = jComboBox1.getSelectedItem().toString();
                StringTokenizer stkr = new StringTokenizer(str,",:");
                String itemname = stkr.nextToken();
                stkr.nextToken();
                String sp1unit = stkr.nextToken();
                //JOptionPane.showMessageDialog(this,"Tokenized string is " + itemname );
                                //works like a charm.
                //JOptionPane.showMessageDialog(this,"next Tokenized string is " + sp1unit );
                                //works like a charm.
                
                
                sql = "select * from packeditems where itemname = '" + 
                        itemname + "';";
                rs = st.executeQuery(sql);
                rs.next();
                int pino = rs.getInt("pino");
                rs.close();
                
                sql = "select * from packeditemdetails where pino = " + pino + 
                        " and sp1unit = '" + sp1unit + "';";
                rs = st.executeQuery(sql);
                rs.next();
                int qtyavail = rs.getInt("qtyathand");
                tf4.setText("" + qtyavail);
                rs.close();
                
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(this,e.getMessage());
            }
            finally
            {
                if(!rs.isClosed())
                rs.close();
                if(!st.isClosed())
                st.close();
                if(!con.isClosed())
                con.close();
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this,"Badi Gadbad.");
        }
        
    }//GEN-LAST:event_jComboBox1ItemStateChanged

    private void tf4KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf4KeyTyped
        
    }//GEN-LAST:event_tf4KeyTyped

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        if(jComboBox1.getSelectedIndex() == 0)
        {
            JOptionPane.showMessageDialog(this,"Please select an item first.");
            return;
        }
        if(tf5.getText().trim().equals(""))
        {
            JOptionPane.showMessageDialog(this,"Please enter quantity to purchase.");
            tf4.setText("");
            tf5.setText("");
            jComboBox1.setSelectedIndex(0);
            jComboBox1.requestFocus();
            return;
        }
        
        String str = jComboBox1.getSelectedItem().toString();
        StringTokenizer stkr = new StringTokenizer(str,",:");
        String itemname = stkr.nextToken();
        stkr.nextToken();
        String sp1unit = stkr.nextToken();
                
        int rowsCount = dtm.getRowCount();
        
        for(int r = 0 ;r < rowsCount ; r++)
        {
            if(dtm.getValueAt(r, 1).equals(itemname) && dtm.getValueAt(r, 2).equals(sp1unit))
            {
                JOptionPane.showMessageDialog(this,"This item has already added to the bill."
                        + "\nIf you want to re-add it first remove it from the bill");
                return;
            }
        }
        
        int qtypur = Integer.parseInt("" + tf5.getText());
        float totalPrice = Float.parseFloat(sp1unit)*qtypur;
        billAmount += totalPrice;
        
        Object row[] = {rowsCount + 1,
                        itemname,
                        sp1unit,
                        qtypur,
                        totalPrice   
                        };
        
        dtm.addRow(row);
        tf6.setText("" + billAmount);
        
        tf4.setText("");
        tf5.setText("");
        jComboBox1.setSelectedIndex(0);
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if(jComboBox1.getSelectedIndex() == 0)
        {
            JOptionPane.showMessageDialog(this,"Please select an item first.");
            return;
        }
        
        String str = jComboBox1.getSelectedItem().toString();
        StringTokenizer stkr = new StringTokenizer(str,",:");
        String itemname = stkr.nextToken();
        stkr.nextToken();
        String sp1unit = stkr.nextToken();
        
        
        int rowsCount = dtm.getRowCount();
        int i = 0,r = 0;
        float totalPrice = 0.0f;
        
        for(r = 0 ; r < rowsCount ; r++)
        {
            ;
            if(dtm.getValueAt(r,1).equals(itemname) && dtm.getValueAt(r, 2).equals(sp1unit))
            {
                totalPrice = Float.parseFloat("" + dtm.getValueAt(r,4));
                break;
            }
            i++;
        }
        if(r == rowsCount)
        {
            JOptionPane.showMessageDialog(this,"The item you are trying to remove from the"
                    + " table is not present int he table.");
            jComboBox1.setSelectedIndex(0);
            jComboBox1.requestFocus();
                return;
        }
        
        
        for( ; r < rowsCount - 1 ; r++ )
        {
            dtm.setValueAt(dtm.getValueAt(r,0), r, 0);
            dtm.setValueAt(dtm.getValueAt(r+1,1), r, 1);
            dtm.setValueAt(dtm.getValueAt(r+1,2), r, 2);
            dtm.setValueAt(dtm.getValueAt(r+1,3), r, 3);
            dtm.setValueAt(dtm.getValueAt(r+1,4), r, 4);
            dtm.setValueAt(dtm.getValueAt(r+1,5), r, 5);
            
        }
        dtm.removeRow(r);
        billAmount -= totalPrice ;
        tf6.setText("" + billAmount);
        tf4.setText("");
        tf5.setText("");
        jComboBox1.setSelectedIndex(0);
        jComboBox1.requestFocus();
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if(dtm.getRowCount() == 0)
        {
           JOptionPane.showMessageDialog(this,"Please first select some items to prchase");
           return;
        }
        if(tf2.getText().trim().equals(""))
        {
            JOptionPane.showMessageDialog(this,"Please enter the customer name.");
            return;
        }
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        String sql;
        try
        {
            try
            {
                Class.forName("java.sql.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/store","root","admin");
                st = con.createStatement();
                
                Calendar c;
                c = jDateChooser1.getCalendar();
                
                sql = "insert into bills (customername,customermob1,billdate,billamount)"
                        + " values ('" + tf2.getText() + "','" + tf3.getText() + "','"
                        + c.get(Calendar.YEAR) + 
                        "-" + (1 + c.get(Calendar.MONTH)) + "-" + 
                        c.get(Calendar.DATE) + "','" + tf6.getText() + "');";
                st.executeUpdate(sql);
                
                
                for(int r = 0; r < dtm.getRowCount() ; r++)
                {
                    sql = "select * from packeditems where itemname = '" + 
                            dtm.getValueAt(r,1) + "';";
                    rs = st.executeQuery(sql);
                    rs.next();
                    int pino = rs.getInt("pino");
                    rs.close();
                    
                    int qtyathand ;
                    float cp1unit;
                     
                    sql = "select * from packeditemdetails where pino = " + pino + 
                            " and sp1unit = '" + dtm.getValueAt(r,2) + "';";
                    rs = st.executeQuery(sql);
                    rs.next();
                    qtyathand = rs.getInt("qtyathand");
                    cp1unit = rs.getFloat("cp1unit");
                    rs.close();
                     
                    qtyathand -= Float.parseFloat("" + dtm.getValueAt(r, 3));
                    if(qtyathand < 0)
                    {
                        JOptionPane.showMessageDialog(this,"Entered Quantity  to purchase is"
                                + " more than available quantity.\nPlease re-add the item.");
                        if(!rs.isClosed())
                        rs.close();
                        if(!st.isClosed())
                        st.close();
                        if(!con.isClosed())
                        con.close();return;
                    }
                    
                    sql = "update packeditemdetails set qtyathand = " + qtyathand +
                            " where pino = " + pino + " and cp1unit = '" + cp1unit + "';";
                    st.executeUpdate(sql);
                    
                    sql = "insert into billdetails values('" + tf1.getText() + "','" + pino +
                            "','" + cp1unit + "','" + dtm.getValueAt(r, 3) + "','" + 
                            dtm.getValueAt(r, 2) + "','" + dtm.getValueAt(r, 4) + 
                            "');";
                    st.executeUpdate(sql);
                
                }
                
                JOptionPane.showMessageDialog(this,"Bill generated successfully.");
                jButton4.doClick();
                
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(this,e.getMessage());
            }
            finally
            {
                if(!rs.isClosed())
                rs.close();
                if(!st.isClosed())
                st.close();
                if(!con.isClosed())
                con.close();
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this,"Badi Gadbad.");
        }
       
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        addIntoComboBox1();
        Calendar c = Calendar.getInstance();
        jDateChooser1.setCalendar(c);
        int total = dtm.getRowCount();
        for(int r = 0 ; r < total ; r++)
            dtm.removeRow(0);
        billAmount = 0.0f;
        tf2.setText("");
        tf3.setText("");
        tf4.setText("");
        tf5.setText("");
        tf6.setText("");
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void tf5KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf5KeyTyped
        char ch = evt.getKeyChar();
        if(ch >= '0' && ch <= '9')
        {
            if(ch == '0')
                if(Integer.parseInt(tf4.getText()) == 0)
                    evt.consume();
        }
        else
            evt.consume();
    }//GEN-LAST:event_tf5KeyTyped

    private void tf2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf2KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_tf2KeyTyped

    private void tf3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf3KeyTyped
        char ch = evt.getKeyChar();
        if(tf3.getText().length() == 0)
        {
            if(ch >= '0' && ch <= '9' || ch == '+')
            ;
            else
            evt.consume();
        }
        else
        {
            if(tf3.getText().charAt(0) == '+')
            {
                if(tf3.getText().length() <= 12)
                {
                    if(ch >= '0' && ch <= '9')
                    ;
                    else
                    evt.consume();
                }
                else
                evt.consume();
            }
            else
            {
                if(tf3.getText().length() <= 9)
                {
                    if(ch >= '0' && ch <= '9')
                    ;
                    else
                    evt.consume();
                }
                else
                evt.consume();
            }
        }
    }//GEN-LAST:event_tf3KeyTyped

    private void tf5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf5ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JComboBox<String> jComboBox1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField tf1;
    private javax.swing.JTextField tf2;
    private javax.swing.JTextField tf3;
    private javax.swing.JTextField tf4;
    private javax.swing.JTextField tf5;
    private javax.swing.JTextField tf6;
    // End of variables declaration//GEN-END:variables
}
