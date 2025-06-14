package com.inventory.UI;

import com.formdev.flatlaf.FlatLightLaf;
import com.inventory.DTO.UserDTO;
import com.inventory.Database.ConnectionFactory;

import java.awt.*;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class LoginPage extends javax.swing.JFrame {

    UserDTO userDTO;
    LocalDateTime inTime;

    public LoginPage() {
        initComponents();
        userDTO = new UserDTO();
        applyCustomStyles();
    }

    private void initComponents() {
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        userText = new javax.swing.JTextField();
        passText = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        loginButton = new javax.swing.JButton();
        clearButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Login");
        setBounds(new java.awt.Rectangle(500, 100, 0, 0));
        setName("loginFrame");

        jLabel1.setText("Username:");
        jLabel2.setText("Password:");

        passText.addActionListener(evt -> passTextActionPerformed(evt));

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("StockMoTo");

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Stock Monitoring And Tracking Operations");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ADMINISTRATOR", "EMPLOYEE" }));

        loginButton.setText("LOGIN");
        loginButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        loginButton.addActionListener(evt -> loginButtonActionPerformed(evt));

        clearButton.setText("CLEAR");
        clearButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        clearButton.addActionListener(evt -> clearButtonActionPerformed(evt));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(clearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(userText))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(passText))
                    .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE))
                .addContainerGap(52, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(userText, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(passText, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)))
                .addGap(18, 18, 18)
                .addComponent(jComboBox1, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(80, 80, 80))
        );

        pack();
    }

    private void applyCustomStyles() {
    getContentPane().setBackground(new Color(204, 255, 204)); 

    Font poppinsFont = new Font("Poppins", Font.PLAIN, 14);
    Font copperFont = new Font("Copperplate Gothic Bold", Font.PLAIN, 32);
    Font poppinsSub = new Font("Poppins", Font.PLAIN, 12);

    Color forestGreen = Color.decode("#013220"); 

    jLabel1.setFont(poppinsFont);
    jLabel2.setFont(poppinsFont);
    
    jLabel3.setFont(copperFont);   
    jLabel3.setForeground(forestGreen);
    
    jLabel4.setFont(poppinsSub);      
    jLabel4.setForeground(forestGreen);

    loginButton.setFont(poppinsFont);
    clearButton.setFont(poppinsFont);
    userText.setFont(poppinsFont);
    passText.setFont(poppinsFont);
    jComboBox1.setFont(poppinsFont);
}

    private String encryptPass(String pass){
        String encPass = null;
        if(pass == null) return null;

        try{
            MessageDigest mDigest = MessageDigest.getInstance("MD5");
            mDigest.update(pass.getBytes(), 0, pass.length());
            encPass = new BigInteger(1, mDigest.digest()).toString(16);
        } catch(Exception ex){
            ex.printStackTrace();
        }

        return encPass;
    }

    String userType;
    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {
        String username = userText.getText();
        String password = passText.getText();
        userType = (String)jComboBox1.getSelectedItem();

        if (new ConnectionFactory().checkLogin(username, password, userType)){
            inTime = LocalDateTime.now();
            userDTO.setInTime(String.valueOf(inTime));
            dispose();
            new Dashboard(username, userType, userDTO);
        } else {
            JOptionPane.showMessageDialog(null, "Invalid username or password.");
        }
    }

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {
        userText.setText("");
        passText.setText("");
    }

    private void passTextActionPerformed(java.awt.event.ActionEvent evt) {
        loginButtonActionPerformed(evt);
    }

    public static void main(String[] args) {
        UIManager.put("Button.arc", 15);
        UIManager.put("Component.arc", 15);
        UIManager.put("TextComponent.arc", 15);

        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(LoginPage.class.getName()).log(Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> new LoginPage().setVisible(true));
    }

    private javax.swing.JButton clearButton;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JButton loginButton;
    private javax.swing.JPasswordField passText;
    private javax.swing.JTextField userText;
}