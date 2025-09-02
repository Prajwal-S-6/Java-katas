package tddmicroexercises.turnticketdispenser;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class TicketDispenserTest {


    private final MockTurnNumberSequence mockTurnNumber = new MockTurnNumberSequence();
    private final TicketDispenser ticketDispenser = new TicketDispenser(mockTurnNumber);


    @Test
    void foo() {
        TurnTicket ticket = ticketDispenser.getTurnTicket();
        assertEquals(0, ticket.getTurnNumber());
    }

    @Test
    void shouldReturnNextTurnNumber() {
        ticketDispenser.getTurnTicket();
        ticketDispenser.getTurnTicket();
        assertEquals(2, ticketDispenser.getTurnTicket().getTurnNumber());
    }




}

class MockTurnNumberSequence implements ITurnNumberGenerator<Integer>{

    private int turnNumber = 0;
    @Override
    public Integer getNextTurnNumber() {
        return turnNumber++;
    }
}
