
package tddmicroexercises.telemetrysystem;

import java.util.Random;

public class TelemetryClient implements IConnection
{

    private boolean onlineStatus;


    private final Random connectionEventsSimulator = new Random(42);


    public void connect(String telemetryServerConnectionString)
    {
        if (telemetryServerConnectionString == null || "".equals(telemetryServerConnectionString))
        {
            throw new IllegalArgumentException();
        }

        // simulate the operation on a real modem
        setOnlineStatus(connectionEventsSimulator.nextInt(10) <= 8);

    }

    public void disconnect()
    {
        setOnlineStatus(false);
    }

    @Override
    public void setOnlineStatus(boolean onlineStatus) {
        this.onlineStatus = onlineStatus;
    }

    public boolean getOnlineStatus()
    {
        return onlineStatus;
    }
}

