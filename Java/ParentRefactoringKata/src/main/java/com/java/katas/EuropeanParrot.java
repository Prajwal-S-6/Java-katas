package com.java.katas;

public class EuropeanParrot extends Parrot {

    public EuropeanParrot(double voltage, boolean isNailed) {
        super(voltage, isNailed);
    }

    @Override
    public double getSpeed() {
        return getBaseSpeed();

    }

    @Override
    public String getCry() {
        return "Sqoork!";
    }
}
