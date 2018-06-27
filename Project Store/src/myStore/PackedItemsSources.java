/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myStore;

import javax.swing.DefaultComboBoxModel;
import javax.swing.*;
import java.sql.*;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author skh
 */
public class PackedItemsSources extends javax.swing.JInternalFrame {
    boolean flag = true;
    DefaultTableModel dtm ;
        
    /**
     * Creates new form PackedItemsSources
     */
    public PackedItemsSources() {
        initComponents();
        addIntoComboBox1();
        jComboBox1.setEnabled(true);
        jComboBox2.setEnabled(false);
        dtm = (DefaultTableModel) jTable1.getModel();
    }
    
    private void addIntoComboBox1()
    {
        flag = false;
        DefaultComboBoxModel dcbm1 = (DefaultComboBoxModel) jComboBox1.getModel();
        DefaultComboBoxModel dcbm2 = (DefaultComboBoxModel) jComboBox2.getModel();
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

                sql = "select * from dealers;";
                rs = st.executeQuery(sql);
                dcbm1.removeAllElements();
                dcbm1.addElement("--Select--");
                while(rs.next())
                {
                    dcbm1.addElement("" + rs.getString("dname"));
                }
                rs.close();
                
                sql = "select * from packeditems;";
                rs = st.executeQuery(sql);
                dcbm2.removeAllElements();
                dcbm2.addElement("--Select--");
                while(rs.next())
                {
                    dcbm2.addElement("" + rs.getString("itemname"));
                }
                rs.close();
                
                flag = true;
                jComboBox1.setSelectedIndex(0);
                jComboBox2.setSelectedIndex(0);
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
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Packed Items Sources", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 36))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Select Dealer : ");

        jComboBox1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel());
        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Select available items : ");

        jComboBox2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel());
        jComboBox2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox2ItemStateChanged(evt);
            }
        });

        jTable1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Serial no.", "Product name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setRowHeight(24);
        jTable1.setRowMargin(3);
        jScrollPane2.setViewportView(jTable1);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setText("Add to list");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton2.setText("Remove from list");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton3.setText("Save details");
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 739, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(64, 64, 64)
                                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 545, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(340, 340, 340)
                        .addComponent(jButton1)
                        .addGap(95, 95, 95)
                        .addComponent(jButton2)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton3)
                .addGap(289, 289, 289)
                .addComponent(jButton4)
                .addGap(248, 248, 248)
                .addComponent(jButton5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton4)
                        .addComponent(jButton5))
                    .addComponent(jButton3))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
        if(flag == false)
        return;
             
        if(jComboBox1.getSelectedIndex() == 0)
            return;
        
        jComboBox1.setEnabled(false);
        jComboBox2.setEnabled(true);
        
    }//GEN-LAST:event_jComboBox1ItemStateChanged

    private void jComboBox2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox2ItemStateChanged
        if(flag == false)
            return;
        if(jComboBox2.getSelectedIndex() == 0)
        {
        }
    }//GEN-LAST:event_jComboBox2ItemStateChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(jComboBox1.getSelectedIndex() == 0)
        {
            JOptionPane.showMessageDialog(this,"Please select a dealer first.");
            return;
        }
        if(jComboBox2.getSelectedIndex() == 0)
        {
            JOptionPane.showMessageDialog(this,"Please select an item first.");
            return;
        }
        /*
        if(jTextField1.getText().trim().equals(""))
        {
            JOptionPane.showMessageDialog(this,"Please enter quantity available.");
            return;
        }
        if(jTextField2.getText().trim().equals(""))
        {
            JOptionPane.showMessageDialog(this,"Please enter cost price of the selected item.");
            return;
        }
        */
        
        int rowsCount = dtm.getRowCount();
        for(int r = 0 ; r < rowsCount ; r++)
        {
            if(dtm.getValueAt(r, 1).equals(jComboBox2.getSelectedItem()))
            {
                JOptionPane.showMessageDialog(this,"this item has already been added to the "
                        + "table.\nIf u want ro re-add it,first remove it from the table.");
                return;
            }
        }
        
        Object row[] = {(rowsCount + 1),
                        jComboBox2.getSelectedItem()
                        /*
                        jTextField1.getText(),
                        jTextField2.getText()
                        */
                        };
        dtm.addRow(row);
        jComboBox2.setSelectedIndex(0);
        /*
        jTextField1.setText("");
        jTextField2.setText("");
        */
        jComboBox2.requestFocus();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if(jComboBox1.getSelectedIndex() == 0)
        {
            JOptionPane.showMessageDialog(this,"Please select a dealer first.");
            return;
        }
        if(jComboBox2.getSelectedIndex() == 0)
        {
            JOptionPane.showMessageDialog(this,"Please select an item first.");
            return;
        }
        
        int rowsCount = dtm.getRowCount();
        int i = 0,r = 0;
        
        for(r = 0 ; r < rowsCount ; r++)
        {
            ;
            if(dtm.getValueAt(r,1).equals(jComboBox2.getSelectedItem()))
            {
                break;
            }
            i++;
        }
        if(r == rowsCount)
        {
            JOptionPane.showMessageDialog(this,"The item you are trying to remove from the"
                    + " table is not present int he table.");
            jComboBox2.setSelectedIndex(0);
            jComboBox2.requestFocus();
                return;
        }
        
        for( ; r < rowsCount - 1 ; r++ )
        {
            dtm.setValueAt(dtm.getValueAt(r,0), r, 0);
            dtm.setValueAt(dtm.getValueAt(r+1,1), r, 1);
            dtm.setValueAt(dtm.getValueAt(r+1,2), r, 2);
            dtm.setValueAt(dtm.getValueAt(r+1,3), r, 3);
        }
        dtm.removeRow(r);
        jComboBox2.setSelectedIndex(0);
        jComboBox2.requestFocus();
            
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
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
                
                sql = "select * from dealers where dname = '" + jComboBox1.getSelectedItem()
                        + "';";
                rs = st.executeQuery(sql);
                rs.next();
                int did = rs.getInt("did");
                rs.close();
                
                for(int r = 0 ; r < dtm.getRowCount() ; r++)
                {
                    sql = "select * from packedItems where itemname = '" + 
                            dtm.getValueAt(r,1) + "';";
                    rs = st.executeQuery(sql);
                    rs.next();
                    int pino = rs.getInt("pino");
                    rs.close();
                    
                    sql = "select * from pisources where did = " + did + 
                            " and pino = " + pino + ";";
                    rs = st.executeQuery(sql);
                    if(rs.next())
                        continue;
                    rs.close();
                    
                    sql = "insert into pisources values(" + 
                            did + "," +  pino + 
                            /*",'" + 
                            dtm.getValueAt(r,2) + "','" + 
                            dtm.getValueAt(r,3) +
                            */
                            ");" ;
                    st.executeUpdate(sql);
                    
                }
                JOptionPane.showMessageDialog(this,"Record Saved.");
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
        jComboBox1.setEnabled(true);
        jComboBox2.setEnabled(false);
        int total = dtm.getRowCount();
        for(int r = 0 ; r < total ; r++)
        {
            dtm.removeRow(0);
        }
        jComboBox1.requestFocus();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton5ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
