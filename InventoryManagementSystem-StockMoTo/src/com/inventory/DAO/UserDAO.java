package com.inventory.DAO;

import com.inventory.DTO.UserDTO;
import com.inventory.Database.ConnectionFactory;
import com.inventory.UI.UsersPage;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.Locale;
import java.util.Vector;

public class UserDAO {
    Connection conn = null;
    PreparedStatement prepStatement = null;
    Statement statement = null;
    ResultSet resultSet = null;

    public UserDAO() {
        try {
            conn = new ConnectionFactory().getConn();
            statement = conn.createStatement();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }


    public void addUserDAO(UserDTO userDTO, String userType) {
        try {
            String query = "SELECT * FROM users WHERE name='"
                    +userDTO.getFullName()
                    +"' AND location='"
                    +userDTO.getLocation()
                    +"' AND phone='"
                    +userDTO.getPhone()
                    +"' AND usertype='"
                    +userDTO.getUserType()
                    +"'";
            resultSet = statement.executeQuery(query);
            if(resultSet.next())
                JOptionPane.showMessageDialog(null, "User already exists");
            else
                addFunction(userDTO, userType);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public void addFunction(UserDTO userDTO, String userType) {
        try {
            String username = null;
            String password = null;
            String oldUsername = null;
            String resQuery = "SELECT * FROM users";
            resultSet = statement.executeQuery(resQuery);

            if(!resultSet.next()){
                username = "root";
                password = "root";
            }

            String query = "INSERT INTO users (name,location,phone,username,password,usertype) " +
                    "VALUES(?,?,?,?,?,?)";
            prepStatement = conn.prepareStatement(query);
            prepStatement.setString(1, userDTO.getFullName());
            prepStatement.setString(2, userDTO.getLocation());
            prepStatement.setString(3, userDTO.getPhone());
            prepStatement.setString(4, userDTO.getUsername());
            prepStatement.setString(5, userDTO.getPassword());
            prepStatement.setString(6, userDTO.getUserType());
            prepStatement.executeUpdate();

            if("ADMINISTRATOR".equals(userType))
                JOptionPane.showMessageDialog(null, "New administrator added.");
            else JOptionPane.showMessageDialog(null, "New employee added.");

        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public void editUserDAO(UserDTO userDTO) {

        try {
            String query = "UPDATE users SET name=?,location=?,phone=?,usertype=? WHERE username=?";
            prepStatement = conn.prepareStatement(query);
            prepStatement.setString(1, userDTO.getFullName());
            prepStatement.setString(2, userDTO.getLocation());
            prepStatement.setString(3, userDTO.getPhone());
            prepStatement.setString(4, userDTO.getUserType());
            prepStatement.setString(5, userDTO.getUsername());
            prepStatement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Updated Successfully.");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void deleteUserDAO(String username) {
        try {
            String query = "DELETE FROM users WHERE username=?";
            prepStatement = (PreparedStatement) conn.prepareStatement(query);
            prepStatement.setString(1, username);
            prepStatement.executeUpdate();
            JOptionPane.showMessageDialog(null, "User Deleted.");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        new UsersPage().loadDataSet();
    }

    public ResultSet getQueryResult() {
        try {
            String query = "SELECT * FROM users";
            resultSet = statement.executeQuery(query);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return resultSet;
    }

    public ResultSet getUserDAO(String username) {
        try {
            String query = "SELECT * FROM users WHERE username='" +username+ "'";
            resultSet = statement.executeQuery(query);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return resultSet;
    }
    public void getFullName(UserDTO userDTO, String username) {
        try {
            String query = "SELECT * FROM users WHERE username='" +username+ "' LIMIT 1";
            resultSet = statement.executeQuery(query);
            String fullName = null;
            if(resultSet.next()) fullName = resultSet.getString(2);
            userDTO.setFullName(fullName);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public ResultSet getUserLogsDAO() {
        try {
            String query = "SELECT users.name,userlogs.username,in_time,out_time,location FROM userlogs" +
                    " INNER JOIN users on userlogs.username=users.username";
            resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }
    public void addUserLogin(UserDTO userDTO) {
        try {
            String query = "INSERT INTO userlogs (username, in_time, out_time) values(?,?,?)";
            prepStatement = conn.prepareStatement(query);
            prepStatement.setString(1, userDTO.getUsername());
            prepStatement.setString(2, userDTO.getInTime());
            prepStatement.setString(3, userDTO.getOutTime());

            prepStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet getPassDAO(String username, String password){
        try {
            String query = "SELECT password FROM users WHERE username='"
                    +username
                    + "' AND password='"
                    +password
                    +"'";
            resultSet = statement.executeQuery(query);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return resultSet;
    }

    public void changePass(String username, String password) {
        try {
            String query = "UPDATE users SET password=? WHERE username='" +username+ "'";
            prepStatement = (PreparedStatement) conn.prepareStatement(query);
            prepStatement.setString(1, password);
            prepStatement.setString(2, username);
            prepStatement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Password has been changed.");
        } catch (SQLException ex){
            ex.printStackTrace();
        }
    }

    public DefaultTableModel buildTableModel(ResultSet resultSet) throws SQLException {
        ResultSetMetaData metaData = resultSet.getMetaData();
        Vector<String> columnNames = new Vector<String>();
        int colCount = metaData.getColumnCount();

        for (int col=1; col <= colCount; col++){
            columnNames.add(metaData.getColumnName(col).toUpperCase(Locale.ROOT));
        }

        Vector<Vector<Object>> data = new Vector<Vector<Object>>();
        while (resultSet.next()) {
            Vector<Object> vector = new Vector<Object>();
            for (int col=1; col<=colCount; col++) {
                vector.add(resultSet.getObject(col));
            }
            data.add(vector);
        }
        return new DefaultTableModel(data, columnNames);
    }

}
