package com.java.katas;

public class EuropeanParrot extends Parrot {

    public EuropeanParrot(int numberOfCoconuts, double voltage, boolean isNailed) {
        super(ParrotTypeEnum.EUROPEAN, numberOfCoconuts, voltage, isNailed);
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
