package com.example.jens.quartett;

/**
 * Created by Jens on 02/01/2018.
 */

public class Value {

    private int propertyId;
    private double value;

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

    public Value(int propertyId, double value) {

        this.propertyId = propertyId;
        this.value = value;
    }
}
