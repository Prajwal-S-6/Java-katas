package com.java.katas;

public abstract class Parrot {

    public Parrot() {
    }

    public static Parrot createParrot(ParrotTypeEnum type, int numberOfCoconuts, double voltage, boolean isNailed) {
        Parrot parrot;
        switch (type) {
            case EUROPEAN -> parrot = new EuropeanParrot();
            case AFRICAN -> parrot = new AfricanParrot(numberOfCoconuts);
            case NORWEGIAN_BLUE -> parrot = new NorwegianBlueParrot(voltage, isNailed);
            default -> throw new IllegalArgumentException("Invalid Parrot type");
        };
        return parrot;
    }

    public abstract double getSpeed();

    protected double getBaseSpeed(double voltage) {
        return Math.min(24.0, voltage * getBaseSpeed());
    }

    protected double getLoadFactor() {
        return 9.0;
    }

    protected double getBaseSpeed() {
        return 12.0;
    }

    public abstract String getCry();
}