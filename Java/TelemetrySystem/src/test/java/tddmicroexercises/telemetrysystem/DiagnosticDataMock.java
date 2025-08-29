package tddmicroexercises.telemetrysystem;

public class DiagnosticDataMock implements IDiagnostic{

    private String diagnosticMessageResult = "";

    @Override
    public void send(String message) {
        setDiagnosticMessageResult(message);
    }

    @Override
    public String receive() {
        return getDiagnosticMessageResult();
    }

    public String getDiagnosticMessageResult() {
        return diagnosticMessageResult;
    }

    public void setDiagnosticMessageResult(String diagnosticMessageResult) {
        this.diagnosticMessageResult = diagnosticMessageResult;
    }
}
