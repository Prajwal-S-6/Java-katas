package tddmicroexercises.telemetrysystem;

public interface IDiagnostic {

    String DIAGNOSTIC_MESSAGE = "AT#UD";

    void send(String message);

    String receive();

    String getDiagnosticMessageResult();

    void setDiagnosticMessageResult(String messageResult);
}
