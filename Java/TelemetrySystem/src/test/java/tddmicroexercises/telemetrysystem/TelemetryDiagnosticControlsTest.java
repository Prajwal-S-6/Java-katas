package tddmicroexercises.telemetrysystem;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TelemetryDiagnosticControlsTest
{

    private TelemetryDiagnosticControls telemetryDiagnosticControls;
    private IConnection connection;
    private IDiagnostic diagnostic;

    @BeforeEach
    void setUp() {
        connection = new ConnectionMock();
        diagnostic = new DiagnosticDataMock();
        telemetryDiagnosticControls = new TelemetryDiagnosticControls(connection, diagnostic);
    }

    @Test
    public void CheckTransmission_Before_should_send_a_diagnostic_message_and_receive_a_status_message_response() throws Exception {
        TelemetryDiagnosticControls telemetryDiagnosticControls = new TelemetryDiagnosticControls();
        telemetryDiagnosticControls.checkTransmission();
        assertNotNull(telemetryDiagnosticControls.getDiagnosticInfo());
    }

    @Test
    public void CheckTransmission_After_should_send_a_diagnostic_message_and_receive_a_status_message_response() throws Exception {
        connection.setOnlineStatus(true);
        telemetryDiagnosticControls.checkTransmission();


        assertEquals("AT#UD", telemetryDiagnosticControls.getDiagnosticInfo());
        assertEquals(diagnostic.getDiagnosticMessageResult(), telemetryDiagnosticControls.getDiagnosticInfo());
    }

    @Test
    public void CheckTransmission_After_should_throw_exception_unable_to_connect() throws Exception {
        connection.setOnlineStatus(false);

        Exception exception = assertThrows(Exception.class, () -> telemetryDiagnosticControls.checkTransmission());
        assertEquals("Unable to connect.", exception.getMessage());
    }



}