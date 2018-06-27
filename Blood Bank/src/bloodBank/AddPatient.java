/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bloodBank;
import java.sql.*;
import javax.swing.*;
/**
 *
 * @author skh
 */
public class AddPatient extends javax.swing.JInternalFrame {

    /**
     * Creates new form AddPatient
     */
    public AddPatient() {
        initComponents();
        addIntoComboBox();
    }
    
    private void addIntoComboBox()
    {
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        String sql = "";
        try
        {
            try
            {
                Class.forName("java.sql.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bloodbank","root","admin");
                st = con.createStatement();
                DefaultComboBoxModel dcbm = (DefaultComboBoxModel)jComboBox1.getModel();
                sql = "select * from blood;";
                rs = st.executeQuery(sql);
                dcbm.removeAllElements();
                dcbm.addElement("--Select--");
                while(rs.next())
                {
                    dcbm.addElement(rs.getString("bloodgroup"));
                }
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
            JOptionPane.showMessageDialog(this,e.getMessage());
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        dtf1 = new javax.swing.JTextField();
        dtf2 = new javax.swing.JTextField();
        dtf4 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        dtf6 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        dtf7 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        dtf3 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        dtf5 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Add Patient", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tempus Sans ITC", 3, 36), new java.awt.Color(153, 0, 153))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Patient ID             : ");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Patient first name :  ");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("email                     : ");

        dtf1.setEditable(false);
        dtf1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        dtf2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        dtf2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                dtf2FocusGained(evt);
            }
        });

        dtf4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setText("add details");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton2.setText(" Clear ");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton3.setText("Close");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("address                 : ");

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("Mob 1                    : ");

        dtf6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        dtf6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                dtf6KeyTyped(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("Mob 2                    : ");

        dtf7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        dtf7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                dtf7KeyTyped(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setText("Blood group         : ");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setText("Patient last name :  ");

        dtf3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        dtf3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                dtf3FocusGained(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setText("Pincode                : ");

        dtf5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        dtf5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                dtf5KeyTyped(evt);
            }
        });

        jComboBox1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel()
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(44, 44, 44)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(dtf4)
                            .addComponent(jScrollPane1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(dtf2, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(83, 83, 83)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(dtf3, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(dtf1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(506, 506, 506))
                            .addComponent(dtf5, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dtf7)
                            .addComponent(dtf6))
                        .addContainerGap(33, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addGap(300, 300, 300)
                        .addComponent(jButton3)
                        .addGap(86, 86, 86))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(dtf1, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dtf2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dtf3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dtf4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                    .addComponent(dtf5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dtf6, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dtf7, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jComboBox1)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void dtf2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_dtf2FocusGained
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        String sql = "";
        try
        {
            try
            {
                Class.forName("java.sql.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bloodbank","root","admin");
                st = con.createStatement();
                sql = "select max(pid) as mx from patient;";
                rs = st.executeQuery(sql);
                if(rs.next())
                    dtf1.setText("" + (rs.getInt("mx") + 1));
                else
                    dtf1.setText("1");

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
            JOptionPane.showMessageDialog(this,e.getMessage());
        }
    }//GEN-LAST:event_dtf2FocusGained

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(dtf2.getText().equals(""))
        {
            JOptionPane.showMessageDialog(this,"Please enter the patient's first name.");
            return;
        }
        if(jTextArea1.getText().equals(""))
        {
            JOptionPane.showMessageDialog(this,"Please enter the patient's address.");
            return;
        }
        if(dtf4.getText().equals(""))
        {
            JOptionPane.showMessageDialog(this,"Please enter the patient's email Address");
            return;
        }
        if(dtf5.getText().length() != 6)
        {
            JOptionPane.showMessageDialog(this,"Please enter a valid pincode.");
            return;
        }
        
        if(dtf6.getText().length() != 10 && dtf6.getText().length() != 13)
        {
            JOptionPane.showMessageDialog(this,"Please enter a valid mobile number.");
            return;
        }
        if(dtf6.getText().length() != 10 && dtf6.getText().length() != 13)
        {
            JOptionPane.showMessageDialog(this,"Please enter a valid mobile number.");
            return;
        }
        
        if(jComboBox1.getSelectedIndex() == 0)
        {
            JOptionPane.showMessageDialog(this,"Please select a valid blood group.");
            return;
        }
        
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        String sql = "";
        try
        {
            try
            {
                Class.forName("java.sql.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bloodbank","root","admin");
                st = con.createStatement();
                sql = "select * from blood where bloodgroup = '" + jComboBox1.getSelectedItem()
                        + "';";
                rs = st.executeQuery(sql);
                rs.next();
                int bid = rs.getInt("bid");
                rs.close();
                
                sql = "insert into patient values(" + dtf1.getText() +
                ",'" +  dtf2.getText().trim().toUpperCase() +
                "','" +  dtf3.getText().trim().toUpperCase() + "','"
                + jTextArea1.getText().trim() + "','" +
                dtf4.getText().trim() + "','" +
                dtf5.getText()+ "','" +
                dtf6.getText()+ "','" +
                dtf7.getText()+ "','" +
                bid + "');";
                st.executeUpdate(sql);
                JOptionPane.showMessageDialog(this, "Record saved.");

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
            JOptionPane.showMessageDialog(this,e.getMessage());
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        dtf1.setText("");
        dtf2.setText("");
        dtf3.setText("");
        jTextArea1.setText("");
        dtf4.setText("");
        dtf5.setText("");
        dtf6.setText("");
        dtf7.setText("");
        addIntoComboBox();

        dtf2.requestFocus();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        new MDI().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void dtf6KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dtf6KeyTyped
        char ch = evt.getKeyChar();
        if(dtf6.getText().length() == 0)
        {
            if(ch >= '0' && ch <= '9' || ch == '+')
            ;
            else
            evt.consume();
        }
        else
        {
            if(dtf6.getText().charAt(0) == '+')
            {
                if(dtf6.getText().length() <= 12)
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
                if(dtf6.getText().length() <= 9)
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
    }//GEN-LAST:event_dtf6KeyTyped

    private void dtf7KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dtf7KeyTyped
        char ch = evt.getKeyChar();
        if(dtf7.getText().length() == 0)
        {
            if(ch >= '0' && ch <= '9' || ch == '+')
            ;
            else
            evt.consume();
        }
        else
        {
            if(dtf7.getText().charAt(0) == '+')
            {
                if(dtf7.getText().length() <= 12)
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
                if(dtf7.getText().length() <= 9)
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
    }//GEN-LAST:event_dtf7KeyTyped

    private void dtf3FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_dtf3FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_dtf3FocusGained

    private void dtf5KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dtf5KeyTyped
        char ch = evt.getKeyChar();
        if(ch >= '0' && ch <= '9' )
        {
            if(dtf5.getText().length() == 6)
            evt.consume();
        }
        else
        evt.consume();

    }//GEN-LAST:event_dtf5KeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField dtf1;
    private javax.swing.JTextField dtf2;
    private javax.swing.JTextField dtf3;
    private javax.swing.JTextField dtf4;
    private javax.swing.JTextField dtf5;
    private javax.swing.JTextField dtf6;
    private javax.swing.JTextField dtf7;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
