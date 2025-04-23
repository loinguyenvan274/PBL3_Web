package com.example.demo.Model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;

enum TypeBaggage {
    CARRY_ON_BA,
    SPECIAL_BA,
    CHECKED_BA
}

@Entity
@Table(name = "Baggage")
public class Baggage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Baggage")
    private int idBaggage;

    @Enumerated(EnumType.STRING)
    @Column(name = "Baggage_Type")
    private TypeBaggage baggageType;

    @Column(name = "Baggage_Weight")
    private float baggageWeight;

    public Baggage() {
    }

    public Baggage(int idBaggage, TypeBaggage baggageType, float baggageWeight) {
        this.idBaggage = idBaggage;
        this.baggageType = baggageType;
        this.baggageWeight = baggageWeight;
    }

    public int getKey() {
        return idBaggage;
    }

    public List<String> valueString() {
        List<String> value = new ArrayList<>();
        value.add(baggageType.toString());
        value.add(String.valueOf(baggageWeight));
        return value;
    }

    public int getIdBaggage() {
        return idBaggage;
    }

    public void setIdBaggage(int idBaggage) {
        this.idBaggage = idBaggage;
    }

    public TypeBaggage getBaggageType() {
        return baggageType;
    }

    public void setBaggageType(TypeBaggage baggageType) {
        this.baggageType = baggageType;
    }

    public float getBaggageWeight() {
        return baggageWeight;
    }

    public void setBaggageWeight(float baggageWeight) {
        this.baggageWeight = baggageWeight;
    }

    @Override
    public String toString() {
        return "Baggage{" +
                "idBaggage=" + idBaggage +
                ", baggageType=" + baggageType +
                ", baggageWeight=" + baggageWeight +
                '}';
    }
}
