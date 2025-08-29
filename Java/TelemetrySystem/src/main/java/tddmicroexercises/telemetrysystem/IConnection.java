package tddmicroexercises.telemetrysystem;

public interface IConnection {

    void connect(String connectionString);

    void disconnect();

    void setOnlineStatus(boolean onlineStatus);

    boolean getOnlineStatus();
}
