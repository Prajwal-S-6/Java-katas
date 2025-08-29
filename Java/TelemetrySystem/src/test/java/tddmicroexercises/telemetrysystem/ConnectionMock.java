package tddmicroexercises.telemetrysystem;

public class ConnectionMock implements IConnection{
    boolean onlineStatus;

    @Override
    public void connect(String connectionString) {

    }

    @Override
    public void disconnect() {

    }

    @Override
    public void setOnlineStatus(boolean onlineStatus) {
        this.onlineStatus = onlineStatus;
    }

    @Override
    public boolean getOnlineStatus() {
        return this.onlineStatus;
    }
}
