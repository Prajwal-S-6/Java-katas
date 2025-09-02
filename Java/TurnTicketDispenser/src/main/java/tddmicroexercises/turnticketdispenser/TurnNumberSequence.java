package tddmicroexercises.turnticketdispenser;

public class TurnNumberSequence implements ITurnNumberGenerator<Integer>
{
    private int _turnNumber = 0;

    private static volatile ITurnNumberGenerator<Integer> INSTANCE = new TurnNumberSequence();

    private TurnNumberSequence() {}



    @Override
    public Integer getNextTurnNumber()
    {
        return _turnNumber++;
    }


}
