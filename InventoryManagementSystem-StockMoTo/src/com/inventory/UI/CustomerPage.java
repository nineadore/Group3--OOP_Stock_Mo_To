package com.inventory.UI;

import com.inventory.DAO.CustomerDAO;
import com.inventory.DTO.CustomerDTO;
import java.sql.SQLException;
import javax.swing.*;

public class CustomerPage extends javax.swing.JPanel {

    // UI Components
    private javax.swing.JButton addButton;
    private javax.swing.JButton clearButton;
    private javax.swing.JTextField codeText;
    private javax.swing.JTable custTable;
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton editButton;
    private javax.swing.JPanel entryPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField locationText;
    private javax.swing.JTextField nameText;
    private javax.swing.JTextField phoneText;
    private javax.swing.JTextField searchText;

    public CustomerPage() {
        initComponents();
        loadCustomerData();
    }

    private void initComponents() {
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        entryPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        phoneText = new javax.swing.JTextField();
        locationText = new javax.swing.JTextField();
        codeText = new javax.swing.JTextField();
        nameText = new javax.swing.JTextField();
        addButton = new javax.swing.JButton();
        editButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        clearButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        custTable = new javax.swing.JTable();
        searchText = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();

        jLabel1.setFont(new java.awt.Font("Impact", 0, 24));
        jLabel1.setText("CUSTOMERS");

        entryPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Enter Customer Details"));

        jLabel2.setText("Customer Code:");

        jLabel3.setText("Full Name:");

        jLabel4.setText("Location:");

        jLabel5.setText("Contact:");

        addButton.setText("Add");
        addButton.addActionListener(evt -> addButtonActionPerformed(evt));

        editButton.setText("Edit");
        editButton.addActionListener(evt -> editButtonActionPerformed(evt));

        deleteButton.setText("Delete");
        deleteButton.addActionListener(evt -> deleteButtonActionPerformed(evt));

        clearButton.setText("CLEAR");
        clearButton.addActionListener(evt -> clearButtonActionPerformed(evt));

        javax.swing.GroupLayout entryPanelLayout = new javax.swing.GroupLayout(entryPanel);
        entryPanel.setLayout(entryPanelLayout);
        entryPanelLayout.setHorizontalGroup(
            entryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(entryPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(entryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(clearButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(entryPanelLayout.createSequentialGroup()
                        .addGroup(entryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(entryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(phoneText)
                            .addComponent(locationText)
                            .addComponent(codeText)
                            .addComponent(nameText)))
                    .addGroup(entryPanelLayout.createSequentialGroup()
                        .addComponent(addButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(editButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deleteButton)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        entryPanelLayout.setVerticalGroup(
            entryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(entryPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(entryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(codeText, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(entryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameText, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(entryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(locationText, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(entryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phoneText, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(entryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addButton)
                    .addComponent(editButton)
                    .addComponent(deleteButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(clearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        custTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] {"Customer Code", "Full Name", "Location", "Phone"}
        ) {
            boolean[] canEdit = new boolean [] {false, false, false, false};
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        custTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                custTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(custTable);

        searchText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchTextKeyReleased(evt);
            }
        });

        jLabel8.setText("Search:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchText, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 445, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(entryPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(entryPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(67, Short.MAX_VALUE))
        );
    }

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {
        if (!validateInputs()) return;
        
        try {
            CustomerDTO customer = new CustomerDTO();
            customer.setCustCode(codeText.getText().trim());
            customer.setFullName(nameText.getText().trim());
            customer.setLocation(locationText.getText().trim());
            customer.setPhone(phoneText.getText().trim());
            
            CustomerDAO dao = new CustomerDAO();
            if (dao.addCustomerDAO(customer)) {
                JOptionPane.showMessageDialog(this, 
                    "Customer added successfully!", 
                    "Success", 
                    JOptionPane.INFORMATION_MESSAGE);
                loadCustomerData();
                clearFields();
            } else {
                JOptionPane.showMessageDialog(this,
                    "Failed to add customer",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            showDatabaseError(e);
        }
    }

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {
        if (custTable.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, 
                "Please select a customer first", 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (!validateInputs()) return;
        
        try {
            CustomerDTO customer = new CustomerDTO();
            customer.setCustCode(codeText.getText().trim());
            customer.setFullName(nameText.getText().trim());
            customer.setLocation(locationText.getText().trim());
            customer.setPhone(phoneText.getText().trim());
            
            CustomerDAO dao = new CustomerDAO();
            if (dao.editCustomerDAO(customer)) {
                JOptionPane.showMessageDialog(this,
                    "Customer updated successfully!",
                    "Success",
                    JOptionPane.INFORMATION_MESSAGE);
                loadCustomerData();
            }
        } catch (SQLException e) {
            showDatabaseError(e);
        }
    }

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {
        if (custTable.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this,
                "Please select a customer first",
                "Error",
                JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        String custCode = custTable.getValueAt(custTable.getSelectedRow(), 0).toString();
        int confirm = JOptionPane.showConfirmDialog(this,
            "Are you sure you want to delete customer " + custCode + "?",
            "Confirm Delete",
            JOptionPane.YES_NO_OPTION);
        
        if (confirm == JOptionPane.YES_OPTION) {
            try {
                CustomerDAO dao = new CustomerDAO();
                if (dao.deleteCustomerDAO(custCode)) {
                    JOptionPane.showMessageDialog(this,
                        "Customer deleted successfully!",
                        "Success",
                        JOptionPane.INFORMATION_MESSAGE);
                    loadCustomerData();
                    clearFields();
                }
            } catch (SQLException e) {
                showDatabaseError(e);
            }
        }
    }

    private void loadCustomerData() {
        try {
            CustomerDAO dao = new CustomerDAO();
            custTable.setModel(dao.getCustomerTableModel());
        } catch (SQLException e) {
            showDatabaseError(e);
        }
    }

    private void searchTextKeyReleased(java.awt.event.KeyEvent evt) {
        String searchText = this.searchText.getText().trim();
        if (searchText.isEmpty()) {
            loadCustomerData();
        } else {
            try {
                CustomerDAO dao = new CustomerDAO();
                custTable.setModel(dao.searchCustomers(searchText));
            } catch (SQLException e) {
                showDatabaseError(e);
            }
        }
    }

    private void custTableMouseClicked(java.awt.event.MouseEvent evt) {
        int row = custTable.getSelectedRow();
        if (row >= 0) {
            codeText.setText(custTable.getValueAt(row, 0).toString());
            nameText.setText(custTable.getValueAt(row, 1).toString());
            locationText.setText(custTable.getValueAt(row, 2).toString());
            phoneText.setText(custTable.getValueAt(row, 3).toString());
        }
    }

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {
        clearFields();
    }

    private void clearFields() {
        codeText.setText("");
        nameText.setText("");
        locationText.setText("");
        phoneText.setText("");
        searchText.setText("");
    }

    private boolean validateInputs() {
        if (codeText.getText().trim().isEmpty()) {
            showError("Customer Code is required", codeText);
            return false;
        }
        if (nameText.getText().trim().isEmpty()) {
            showError("Full Name is required", nameText);
            return false;
        }
        if (!phoneText.getText().matches("^[0-9\\-+() ]*$")) {
            showError("Invalid phone number format", phoneText);
            return false;
        }
        return true;
    }

    private void showError(String message, JTextField field) {
        JOptionPane.showMessageDialog(this, message, "Input Error", JOptionPane.ERROR_MESSAGE);
        if (field != null) {
            field.requestFocus();
        }
    }

    private void showDatabaseError(SQLException e) {
        String message = "Database error: " + 
            (e.getMessage().contains("Duplicate entry") 
                ? "Customer code already exists" 
                : e.getMessage());
        JOptionPane.showMessageDialog(this, message, "Database Error", JOptionPane.ERROR_MESSAGE);
    }
}