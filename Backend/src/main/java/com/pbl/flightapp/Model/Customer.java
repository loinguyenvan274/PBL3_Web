package com.pbl.flightapp.Model;

import java.util.ArrayList;
import java.util.Date;

import com.pbl.flightapp.Enum.CustomerCategory;
import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;


@Entity
@Table(name = "Customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_customer")
    private int idCustomer;

    @Column(name = "Full_Name")
    private String fullName;

    @Column(name = "phone")
    private String phone;

    @Column(name ="Card_Number")
    private String cardNumber;

    @Column(name = "address")
    private String address;

    @Column(name = "sex")
    private boolean sex;

    @Column(name = "Day_Of_Birth")
    private Date dayOfBirth;

    @Enumerated(EnumType.STRING)
    @Column(name = "Customer_Type")
    private CustomerCategory customerType;

    @OneToOne
    @JoinColumn(name = "account", referencedColumnName = "id_account")
    private Account account;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Booking> bookings = new ArrayList<>();

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

    public Date getDayOfBirth() {
        return dayOfBirth;
    }

    public void setDayOfBirth(Date dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    public CustomerCategory getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerCategory customerType) {
        this.customerType = customerType;
    }

    public Account getAccount() {
        return account;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Customer customer)) return false;
        return idCustomer == customer.idCustomer;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(idCustomer);
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }
}
