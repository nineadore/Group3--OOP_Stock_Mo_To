package com.inventory.DTO;

public class CustomerDTO {
    private int custID;
    private String custCode;
    private String fullName;
    private String location;
    private String phone;

    // Constructors
    public CustomerDTO() {}

    public CustomerDTO(String custCode, String fullName, String location, String phone) {
        this.custCode = custCode;
        this.fullName = fullName;
        this.location = location;
        this.phone = phone;
    }

    // Getters and Setters with validation
    public int getCustID() {
        return custID;
    }

    public void setCustID(int custID) {
        this.custID = custID;
    }

    public String getCustCode() {
        return custCode;
    }

    public void setCustCode(String custCode) {
        if (custCode == null || custCode.trim().isEmpty()) {
            throw new IllegalArgumentException("Customer code cannot be empty");
        }
        this.custCode = custCode;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        if (fullName == null || fullName.trim().isEmpty()) {
            throw new IllegalArgumentException("Full name cannot be empty");
        }
        this.fullName = fullName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        if (phone != null && !phone.matches("^[0-9\\-+() ]+$")) {
            throw new IllegalArgumentException("Invalid phone number format");
        }
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "CustomerDTO{" +
                "custID=" + custID +
                ", custCode='" + custCode + '\'' +
                ", fullName='" + fullName + '\'' +
                ", location='" + location + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}