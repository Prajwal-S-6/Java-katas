package tddmicroexercises.tirepressuremonitoringsystem;

public class Alarm implements IAlarm
{

    private static final double LOW_PRESSURE_THRESHOLD = 17;
    private static final double HIGH_PRESSURE_THRESHOLD = 21;

    private final ISensor sensor;
    private boolean alarmOn = false;

    public Alarm() {
        this(new Sensor());
    }

    public Alarm(ISensor sensor) {
        this.sensor = sensor;
    }


    @Override
    public void check()
    {
        double psiPressureValue = (double) sensor.getSensorValue();

        if (psiPressureValue < LOW_PRESSURE_THRESHOLD || HIGH_PRESSURE_THRESHOLD < psiPressureValue)
        {
            alarmOn = true;
        }
    }

    @Override
    public boolean isAlarmOn()
    {
        return alarmOn; 
    }
}
