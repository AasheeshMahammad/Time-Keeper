/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package timekeeper;

import java.awt.Toolkit;
import java.awt.event.WindowEvent;

public class Profile extends javax.swing.JFrame {

    /**
     * Creates new form Profile
     */
    String name;
    int flag = 0;
    
    public Profile(String name) {
        initComponents();
        this.setVisible(true);
        this.name = name;
        setDetails();
        
    }
    public void close(){
        WindowEvent closewindow=new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closewindow);
    } 

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPasswordField1 = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1090, 620));
        setMinimumSize(new java.awt.Dimension(1090, 620));
        setPreferredSize(new java.awt.Dimension(1090, 620));
        setResizable(false);
        setSize(new java.awt.Dimension(1090, 620));

        jPanel1.setBackground(new java.awt.Color(54, 48, 98));
        jPanel1.setInheritsPopupMenu(true);

        jLabel1.setFont(new java.awt.Font("Uberlin", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(233, 213, 218));
        jLabel1.setText("PROFILE");

        jLabel2.setFont(new java.awt.Font("Uberlin", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(233, 213, 218));
        jLabel2.setText("Name:");

        jLabel3.setFont(new java.awt.Font("Uberlin", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(233, 213, 218));
        jLabel3.setText("Email:");

        jTextField1.setEditable(false);
        jTextField1.setBackground(new java.awt.Color(130, 115, 151));
        jTextField1.setFont(new java.awt.Font("Uberlin", 1, 12)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(255, 255, 0));

        jTextField2.setEditable(false);
        jTextField2.setBackground(new java.awt.Color(130, 115, 151));
        jTextField2.setFont(new java.awt.Font("Uberlin", 1, 12)); // NOI18N
        jTextField2.setForeground(new java.awt.Color(255, 255, 0));

        jButton1.setBackground(new java.awt.Color(77, 76, 125));
        jButton1.setFont(new java.awt.Font("Uberlin", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(233, 213, 218));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-edit-50.png"))); // NOI18N
        jButton1.setText("EDIT");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(77, 76, 125));
        jButton2.setFont(new java.awt.Font("Uberlin", 1, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(233, 213, 218));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-save-50.png"))); // NOI18N
        jButton2.setText("SAVE");
        jButton2.setEnabled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jPasswordField1.setEditable(false);
        jPasswordField1.setBackground(new java.awt.Color(130, 115, 151));
        jPasswordField1.setFont(new java.awt.Font("Uberlin", 1, 12)); // NOI18N
        jPasswordField1.setForeground(new java.awt.Color(255, 255, 0));

        jLabel4.setFont(new java.awt.Font("Uberlin", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(233, 213, 218));
        jLabel4.setText("Password:");

        jButton3.setBackground(new java.awt.Color(77, 76, 125));
        jButton3.setFont(new java.awt.Font("Uberlin", 1, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(233, 213, 218));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-back-50.png"))); // NOI18N
        jButton3.setText("Goto CRUD");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(228, 228, 228)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(102, 102, 102)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(445, 445, 445)
                                .addComponent(jLabel1))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(313, 313, 313)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(50, 50, 50)
                .addComponent(jButton3)
                .addGap(98, 98, 98))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(48, 48, 48)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(81, 81, 81)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(189, 189, 189))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
                // Edit button
//        jTextField1.setEditable(true);
        flag= 1;
        jTextField2.setEditable(true);
        jPasswordField1.setEditable(true);
        
        jButton1.setEnabled(false);
        jButton2.setEnabled(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // save button
//        jTextField1.setEditable(false);
        jTextField2.setEditable(false);
        jPasswordField1.setEditable(false);
        //update the values in database..
        //...
        String em = jTextField2.getText();
        String pass = new String(jPasswordField1.getPassword());
        Controller.updateProfile(name, em, pass);
        jButton1.setEnabled(true);
        jButton2.setEnabled(false);
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        Controller.profiletocrud(this);
    }//GEN-LAST:event_jButton3ActionPerformed
    private void setDetails(){
//        jTextField1.setText(name);
//        String email, password;
//        //get email and password from database
//        
//        
//        
//        jTextField2.setText(email);
//        jPasswordField1.setText(password);
        jTextField1.setText(name);
        String[] vals = Controller.loadProfile(name);
        jTextField2.setText(vals[0]);
        jPasswordField1.setText(vals[1]);
        jPasswordField1.show();
        
    }
    /**
     * @param args the command line arguments
     */
//textfield1 = username
//textfield2 = email
//passwordfield1 = password
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
