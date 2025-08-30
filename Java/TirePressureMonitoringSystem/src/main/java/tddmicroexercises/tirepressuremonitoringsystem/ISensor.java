package tddmicroexercises.tirepressuremonitoringsystem;

public interface ISensor<T extends Number> {

    T getSensorValue();
}
