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
import javax.swing.JOptionPane;

/**
 *
 * @author skh
 */
public class AddDealer extends javax.swing.JInternalFrame {

    /**
     * Creates new form ItemEntry
     */
    public AddDealer() {
        initComponents();
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
        jLabel2 = new javax.swing.JLabel();
        dtf1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        dtf2 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        dtf3 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        dtf4 = new javax.swing.JTextField();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Add Dealer", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 36))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Dealer name : ");

        dtf1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        dtf1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                dtf1FocusGained(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setText("  Add  ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton2.setText("  Clear  ");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton3.setText("  Close  ");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Address          : ");

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("email              : ");

        dtf2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        dtf2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                dtf2FocusGained(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("mob1              : ");

        dtf3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        dtf3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                dtf3FocusGained(evt);
            }
        });
        dtf3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                dtf3KeyTyped(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("mob2              : ");

        dtf4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        dtf4.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                dtf4FocusGained(evt);
            }
        });
        dtf4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                dtf4KeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dtf1)
                            .addComponent(jScrollPane1)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jButton1)
                            .addGap(180, 180, 180)
                            .addComponent(jButton2)
                            .addGap(185, 185, 185)
                            .addComponent(jButton3))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel5)
                                .addComponent(jLabel6))
                            .addGap(31, 31, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(dtf4, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(dtf3, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(dtf2, javax.swing.GroupLayout.PREFERRED_SIZE, 746, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(59, 59, 59)))
                    .addComponent(jLabel4))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dtf1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dtf2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dtf3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dtf4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void dtf1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_dtf1FocusGained
        
    }//GEN-LAST:event_dtf1FocusGained

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(dtf1.getText().trim().equals(""))
        {
            JOptionPane.showMessageDialog(this,"Please enter the dealer's name.");
            return;
        }
        if(dtf2.getText().trim().equals(""))
        {
            JOptionPane.showMessageDialog(this,"Please enter the dealer's email.");
            return;
        }
        if(dtf3.getText().length() != 10 && dtf3.getText().length() != 13)
        {
            JOptionPane.showMessageDialog(this,"Please enter a valid mob1.");
            return;
        }
        if(dtf4.getText().length() != 10 && dtf4.getText().length() != 13)
        {
            JOptionPane.showMessageDialog(this,"Please enter a valid mob2.");
            return;
        }
        if(jTextArea1.getText().trim().equals(""))
        {
            JOptionPane.showMessageDialog(this,"Please enter the dealer's address.");
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

                sql = "insert into dealers (dname,address,email,mob1,mob2) values('"
                        + dtf1.getText().trim().toUpperCase() + 
                        "','" + jTextArea1.getText().trim() + 
                        "','" + dtf2.getText().trim() + 
                        "','" + dtf3.getText().trim() + 
                        "','" + dtf4.getText().trim() + 
                        "');";
                st.executeUpdate(sql);
                JOptionPane.showMessageDialog(this,"Dealer added.");
                jButton2.doClick();
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
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        dtf1.setText("");
        dtf2.setText("");
        dtf3.setText("");
        dtf4.setText("");
        jTextArea1.setText("");
        
        dtf1.requestFocus();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void dtf2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_dtf2FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_dtf2FocusGained

    private void dtf3FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_dtf3FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_dtf3FocusGained

    private void dtf4FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_dtf4FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_dtf4FocusGained

    private void dtf3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dtf3KeyTyped
        char ch = evt.getKeyChar();
        if(dtf3.getText().length() == 0)
        {
            if(ch >= '0' && ch <= '9' || ch == '+')
            ;
            else
            evt.consume();
        }
        else
        {
            if(dtf3.getText().charAt(0) == '+')
            {
                if(dtf3.getText().length() <= 12)
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
                if(dtf3.getText().length() <= 9)
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
    }//GEN-LAST:event_dtf3KeyTyped

    private void dtf4KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dtf4KeyTyped
        char ch = evt.getKeyChar();
        if(dtf4.getText().length() == 0)
        {
            if(ch >= '0' && ch <= '9' || ch == '+')
            ;
            else
            evt.consume();
        }
        else
        {
            if(dtf4.getText().charAt(0) == '+')
            {
                if(dtf4.getText().length() <= 12)
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
                if(dtf4.getText().length() <= 9)
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
    }//GEN-LAST:event_dtf4KeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField dtf1;
    private javax.swing.JTextField dtf2;
    private javax.swing.JTextField dtf3;
    private javax.swing.JTextField dtf4;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}