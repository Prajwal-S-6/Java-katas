package tddmicroexercises.turnticketdispenser;

public class TicketDispenser
{
    private final ITurnNumberGenerator<Integer> turnNumberSequence;

    public TicketDispenser(ITurnNumberGenerator<Integer> turnNumberSequence) {
        this.turnNumberSequence = turnNumberSequence;
    }

    public TurnTicket getTurnTicket()
    {
        return new TurnTicket(this.turnNumberSequence.getNextTurnNumber());
    }
}
