package com.java.katas;

public class AfricanParrot extends Parrot {

    public AfricanParrot(int numberOfCoconuts, double voltage, boolean isNailed) {
        super(numberOfCoconuts, voltage, isNailed);
    }

    @Override
    public double getSpeed() {
        return Math.max(0, getBaseSpeed() - getLoadFactor() * numberOfCoconuts);
    }

    @Override
    public String getCry() {
        return "Sqaark!";

    }
}
