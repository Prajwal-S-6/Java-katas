package com.java.katas;

public enum ParrotTypeEnum {

    EUROPEAN,
    AFRICAN,
    NORWEGIAN_BLUE;

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
}