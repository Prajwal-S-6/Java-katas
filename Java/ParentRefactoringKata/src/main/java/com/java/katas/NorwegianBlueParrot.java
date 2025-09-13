package com.java.katas;

public class NorwegianBlueParrot extends Parrot {

    protected final double voltage;
    protected final boolean isNailed;

    public NorwegianBlueParrot(double voltage, boolean isNailed) {
        super();
        this.isNailed = isNailed;
        this.voltage = voltage;
    }

    @Override
    public double getSpeed() {
        return (isNailed) ? 0 : getBaseSpeed(voltage);
    }

    @Override
    public String getCry() {
        return voltage > 0 ? "Bzzzzzz" : "...";
    }
}
