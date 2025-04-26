package com.example.demo.Model;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import java.sql.Timestamp;

/*
 * Id_Card string [primary key]
  Full_Name string
  Tel string
  Email string
  Country string
  Day_Of_Birth string
  Sex boolean 0:woman 1:man
  created_at timestamp
 */
@Entity
@Table(name = "Customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Card")
    private int idCard;

    @Column(name = "Full_Name")
    private String fullName;

    @Column(name = "Tel")
    private String tel;

    @Column(name = "Email")
    private String email;

    @Column(name = "Country")
    private String country;

    @Column(name = "Sex")
    private boolean sex;

    @Column(name = "Day_Of_Birth")
    private Date dayOfBirth;

    @Column(name = "created_at")
    private Timestamp createdAt;

    public Customer() {
    }

    public Customer(int idCard, String fullName) {
        this.idCard = idCard;
        this.fullName = fullName;
    }

    public Customer(int idCard, String fullName, String tel, String email, String country, Date dayOfBirth) {
        this.idCard = idCard;
        this.fullName = fullName;
        this.tel = tel;
        this.email = email;
        this.country = country;
        this.dayOfBirth = dayOfBirth;
        this.createdAt = new Timestamp(System.currentTimeMillis());

    }

    public Customer(String fullName, String tel, String email, String country, Date dayOfBirth) {
        this.fullName = fullName;
        this.tel = tel;
        this.email = email;
        this.country = country;
        this.dayOfBirth = dayOfBirth;
        this.createdAt = new Timestamp(System.currentTimeMillis());

    }

    public int getKey() {
        return idCard;
    }

    public List<String> valueString() {
        List<String> value = new ArrayList<>();
        value.add(fullName);
        value.add(tel);
        value.add(email);
        value.add(country);
        value.add(dayOfBirth != null ? dayOfBirth.toString() : "null");
        value.add(createdAt != null ? createdAt.toString() : "null");
        return value;
    }

    public int getIdCard() {
        return idCard;
    }

    public void setIdCard(int idCard) {
        this.idCard = idCard;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Date getDayOfBirth() {
        return dayOfBirth;
    }

    public void setDayOfBirth(Date dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "idCard=" + idCard +
                ", fullName='" + fullName + '\'' +
                ", tel='" + tel + '\'' +
                ", email='" + email + '\'' +
                ", country='" + country + '\'' +
                ", dayOfBirth=" + dayOfBirth +
                ", createdAt=" + createdAt +
                '}';
    }

    public void Copy(Customer customer) {
        this.idCard = customer.idCard;
        this.fullName = customer.fullName;
        this.tel = customer.tel;
        this.email = customer.email;
        this.country = customer.country;
        this.dayOfBirth = customer.dayOfBirth;
        this.createdAt = new Timestamp(System.currentTimeMillis());
    }
}
