package com.pbl.flightapp.DTO;

public class CustomerDTO {
    private int idCustomer;
    private String fullName;
    private String phone;
    private String address;
    private String email;
    private String dateOfBirth;

    public CustomerDTO() {
    }

    public CustomerDTO(int idCustomer, String fullName, String phone, String address, String email, String dateOfBirth) {
        this.idCustomer = idCustomer;
        this.fullName = fullName;
        this.phone = phone;
        this.address = address;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}