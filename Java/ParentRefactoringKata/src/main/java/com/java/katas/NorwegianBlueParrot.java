package com.java.katas;

public class NorwegianBlueParrot extends Parrot {
    public NorwegianBlueParrot(int numberOfCoconuts, double voltage, boolean isNailed) {
        super(ParrotTypeEnum.NORWEGIAN_BLUE, numberOfCoconuts, voltage, isNailed);
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
