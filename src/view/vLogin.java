/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Irawan
 */
public class vLogin extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    public vLogin() {
        initComponents();
        this.setLocationRelativeTo(null);
        setSize(640, 480);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        p1 = new javax.swing.JPanel();
        tfEmail = new javax.swing.JTextField();
        bLogin = new javax.swing.JButton();
        lSepotify = new javax.swing.JLabel();
        bSignup = new javax.swing.JButton();
        pfPassword = new javax.swing.JPasswordField();
        bForget = new javax.swing.JButton();
        lForgetPw = new javax.swing.JLabel();
        lName = new javax.swing.JLabel();
        lPassword = new javax.swing.JLabel();
        lLogin = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        p1.setBackground(new java.awt.Color(0, 0, 0));
        p1.setPreferredSize(new java.awt.Dimension(640, 480));

        tfEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfEmailActionPerformed(evt);
            }
        });

        bLogin.setText("LOGIN");
        bLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bLoginActionPerformed(evt);
            }
        });

        lSepotify.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icon/iSepotify.png"))); // NOI18N

        bSignup.setText("SIGN-UP");
        bSignup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSignupActionPerformed(evt);
            }
        });

        bForget.setText("FORGET");
        bForget.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bForgetActionPerformed(evt);
            }
        });

        lForgetPw.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        lForgetPw.setForeground(new java.awt.Color(255, 255, 255));
        lForgetPw.setText("Forget Password?");

        lName.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        lName.setForeground(new java.awt.Color(255, 255, 255));
        lName.setText("Name");

        lPassword.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        lPassword.setForeground(new java.awt.Color(255, 255, 255));
        lPassword.setText("Password");

        lLogin.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        lLogin.setForeground(new java.awt.Color(255, 255, 255));
        lLogin.setText("Login");

        javax.swing.GroupLayout p1Layout = new javax.swing.GroupLayout(p1);
        p1.setLayout(p1Layout);
        p1Layout.setHorizontalGroup(
            p1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p1Layout.createSequentialGroup()
                .addGroup(p1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(p1Layout.createSequentialGroup()
                        .addGap(170, 170, 170)
                        .addGroup(p1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(bSignup)
                            .addGroup(p1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lName)
                                .addGroup(p1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tfEmail)
                                    .addComponent(pfPassword)
                                    .addComponent(bLogin, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(lPassword))))
                    .addGroup(p1Layout.createSequentialGroup()
                        .addGap(220, 220, 220)
                        .addComponent(lSepotify)))
                .addGap(26, 170, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, p1Layout.createSequentialGroup()
                .addGap(300, 300, 300)
                .addGroup(p1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, p1Layout.createSequentialGroup()
                        .addGroup(p1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bForget, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lForgetPw, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, p1Layout.createSequentialGroup()
                        .addComponent(lLogin)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        p1Layout.setVerticalGroup(
            p1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(lForgetPw, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bForget)
                .addGap(7, 7, 7)
                .addComponent(lSepotify, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lLogin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lPassword)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pfPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bLogin)
                .addGap(18, 18, 18)
                .addComponent(bSignup)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(p1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(p1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfEmailActionPerformed

    private void bSignupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSignupActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bSignupActionPerformed

    private void bForgetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bForgetActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bForgetActionPerformed

    private void bLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bLoginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bLoginActionPerformed

    /**
     * @param args the command line arguments
     */
    

    public String getTfEmail() {
        return tfEmail.getText();
    }

    public String getPfPassword() {
        return pfPassword.getText();
    }
    
    

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bForget;
    private javax.swing.JButton bLogin;
    private javax.swing.JButton bSignup;
    private javax.swing.JLabel lForgetPw;
    private javax.swing.JLabel lLogin;
    private javax.swing.JLabel lName;
    private javax.swing.JLabel lPassword;
    private javax.swing.JLabel lSepotify;
    private javax.swing.JPanel p1;
    private javax.swing.JPasswordField pfPassword;
    private javax.swing.JTextField tfEmail;
    // End of variables declaration//GEN-END:variables
    
    public void addActionListener (ActionListener e) {
        bLogin.addActionListener(e);
        bSignup.addActionListener(e);
        bForget.addActionListener(e);

    }

    public JButton getbLogin() {
        return bLogin;
    }

    public JButton getbSignup() {
        return bSignup;
    }

    public JButton getbForget() {
        return bForget;
    }
    
    
    public void showMessage(String message, String title, int type){
        JOptionPane.showMessageDialog(null, message, title, type);
    }
}
