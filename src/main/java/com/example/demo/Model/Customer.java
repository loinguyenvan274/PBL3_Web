package com.example.demo.Model;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

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

    @Column(name = "Day_Of_Birth")
    private Date dayOfBirth;

    @Column(name = "created_at")
    private Time createdAt;

    public Customer() {
    }

    public Customer(int idCard, String fullName) {
        this.idCard = idCard;
        this.fullName = fullName;
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

    public Time getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Time createdAt) {
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
}
