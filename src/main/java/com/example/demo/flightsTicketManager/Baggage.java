package com.example.demo.flightsTicketManager;

import java.util.ArrayList;
import java.util.List;

enum TypeBaggage {
    CARRY_ON_BA,
    SPECIAL_BA,
    CHECKED_BA
}

public class Baggage {
    private String Id_Baggage;
    private TypeBaggage Baggage_Type;
    private float Baggage_Weight;

    public Baggage() {
    }

    public Baggage(String Id_Baggage, TypeBaggage Baggage_Type, float Baggage_Weight) {
        this.Id_Baggage = Id_Baggage;
        this.Baggage_Type = Baggage_Type;
        this.Baggage_Weight = Baggage_Weight;
    }

    public String getKey() {
        return Id_Baggage;
    }

    public List<String> valueString() {
        List<String> value = new ArrayList<>();
        value.add(Baggage_Type.toString());
        value.add(Float.toString(Baggage_Weight));
        return value;
    }

    public String getId_Baggage() {
        return Id_Baggage;
    }

    public void setId_Baggage(String Id_Baggage) {
        this.Id_Baggage = Id_Baggage;
    }

    public TypeBaggage getBaggage_Type() {
        return Baggage_Type;
    }

    public void setBaggage_Type(TypeBaggage Baggage_Type) {
        this.Baggage_Type = Baggage_Type;
    }

    public float getBaggage_Weight() {
        return Baggage_Weight;
    }

    public void setBaggage_Weight(float Baggage_Weight) {
        this.Baggage_Weight = Baggage_Weight;
    }
}
