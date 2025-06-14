package com.inventory.DAO;

import com.inventory.DTO.CustomerDTO;
import com.inventory.Database.ConnectionFactory;
import java.sql.*;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

public class CustomerDAO {
    
    public boolean addCustomerDAO(CustomerDTO customerDTO) throws SQLException {
        String query = "INSERT INTO customers (customercode, fullname, location, phone) VALUES (?, ?, ?, ?)";
        
        try (Connection conn = new ConnectionFactory().getConn();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            
            pstmt.setString(1, customerDTO.getCustCode());
            pstmt.setString(2, customerDTO.getFullName());
            pstmt.setString(3, customerDTO.getLocation());
            pstmt.setString(4, customerDTO.getPhone());
            
            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        }
    }

    public boolean editCustomerDAO(CustomerDTO customerDTO) throws SQLException {
        String query = "UPDATE customers SET fullname=?, location=?, phone=? WHERE customercode=?";
        
        try (Connection conn = new ConnectionFactory().getConn();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            
            pstmt.setString(1, customerDTO.getFullName());
            pstmt.setString(2, customerDTO.getLocation());
            pstmt.setString(3, customerDTO.getPhone());
            pstmt.setString(4, customerDTO.getCustCode());
            
            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        }
    }

    public boolean deleteCustomerDAO(String custCode) throws SQLException {
        String query = "DELETE FROM customers WHERE customercode=?";
        
        try (Connection conn = new ConnectionFactory().getConn();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            
            pstmt.setString(1, custCode);
            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        }
    }

    public DefaultTableModel getCustomerTableModel() throws SQLException {
        String query = "SELECT customercode, fullname, location, phone FROM customers";
        
        try (Connection conn = new ConnectionFactory().getConn();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            
            return buildTableModel(rs);
        }
    }

    public DefaultTableModel searchCustomers(String text) throws SQLException {
        String query = "SELECT customercode, fullname, location, phone FROM customers " +
                      "WHERE customercode LIKE ? OR fullname LIKE ? OR " +
                      "location LIKE ? OR phone LIKE ?";
        
        try (Connection conn = new ConnectionFactory().getConn();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            
            String searchParam = "%" + text + "%";
            pstmt.setString(1, searchParam);
            pstmt.setString(2, searchParam);
            pstmt.setString(3, searchParam);
            pstmt.setString(4, searchParam);
            
            try (ResultSet rs = pstmt.executeQuery()) {
                return buildTableModel(rs);
            }
        }
    }

    private DefaultTableModel buildTableModel(ResultSet rs) throws SQLException {
        ResultSetMetaData metaData = rs.getMetaData();
        Vector<String> columnNames = new Vector<>();
        int columnCount = metaData.getColumnCount();

        for (int column = 1; column <= columnCount; column++) {
            columnNames.add(metaData.getColumnName(column));
        }

        Vector<Vector<Object>> data = new Vector<>();
        while (rs.next()) {
            Vector<Object> vector = new Vector<>();
            for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                vector.add(rs.getObject(columnIndex));
            }
            data.add(vector);
        }
        
        return new DefaultTableModel(data, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
    }
}
