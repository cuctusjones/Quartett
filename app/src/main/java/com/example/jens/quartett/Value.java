package com.example.jens.quartett;

/**
 * Created by Jens on 02/01/2018.
 */

public class Value {

    private double value;

    @Override
    public String toString() {
        return "Value{" +
                "value=" + value +
                ", propertyId=" + propertyId +
                '}';
    }

    private int propertyId;


    public int getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(int propertyId) {
        this.propertyId = propertyId;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public Value(double value,int propertyId) {

        this.propertyId = propertyId;
        this.value = value;
    }
}
