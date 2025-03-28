package com.example.demo.flightsTicketManager;

enum TypeBaggage {
    CARRY_ON_BA,
    SPECIAL_BA,
    CHECKED_BA
};

public class Baggage {
    private String idBaggage;
    private TypeBaggage typeBaggage;
    private float baWeight;

    public String getIdBaggage() {
        return idBaggage;
    }

    public void setIdBaggage(String idBaggage) {
        this.idBaggage = idBaggage;
    }

    public TypeBaggage getTypeBaggage() {
        return typeBaggage;
    }

    public void setTypeBaggage(TypeBaggage typeBaggage) {
        this.typeBaggage = typeBaggage;
    }

    public float getBaWeight() {
        return baWeight;
    }

    public void setBaWeight(float baWeight) {
        this.baWeight = baWeight;
    }

    public Baggage(String idBaggage, TypeBaggage typeBaggage, float baWeight) {
        this.idBaggage = idBaggage;
        this.typeBaggage = typeBaggage;
        this.baWeight = baWeight;
    }

    public Baggage() {
    }
}
