package tddmicroexercises.tirepressuremonitoringsystem;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class AlarmTest {

    @InjectMocks
    private Alarm alarm;

    @Mock
    private Sensor sensor;

    @Test
    public void shouldBeOffInitially() {
        Alarm alarm = new Alarm();
        assertFalse(alarm.isAlarmOn());
    }

    @Test
    public void shouldTurnOnAlarmWhenPressureIsBelowThreshold() {
        when(sensor.getSensorValue()).thenReturn(16D);
        alarm.check();
        assertTrue(alarm.isAlarmOn());
    }

    @Test
    public void shouldTurnOnAlarmWhenPressureIsAboveThreshold() {
        when(sensor.getSensorValue()).thenReturn(22D);
        alarm.check();
        assertTrue(alarm.isAlarmOn());
    }

    @Test
    public void shouldNotTurnOnAlarmWhenPressureIsNormal() {
        when(sensor.getSensorValue()).thenReturn(18D);
        alarm.check();
        assertFalse(alarm.isAlarmOn());
    }





}
