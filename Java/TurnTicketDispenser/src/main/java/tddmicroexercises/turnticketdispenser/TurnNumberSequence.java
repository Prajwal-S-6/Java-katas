package tddmicroexercises.turnticketdispenser;

public class TurnNumberSequence implements ITurnNumberGenerator<Integer>
{
    private int _turnNumber = 0;

    private static volatile ITurnNumberGenerator<Integer> INSTANCE = new TurnNumberSequence();

    private TurnNumberSequence() {}


    public static ITurnNumberGenerator<Integer> getINSTANCE() {
        if(INSTANCE == null) {
            synchronized (TurnNumberSequence.class) {
                if(INSTANCE == null) {
                    INSTANCE = new TurnNumberSequence();
                }

    @Override
    public Integer getNextTurnNumber()
    {
        return _turnNumber++;
    }


}
