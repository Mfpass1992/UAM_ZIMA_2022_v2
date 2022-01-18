package pl.sdk.creatures;

public class FractionFactory {
    final static String EXCEPTION_MESSAGE = "Fraction doesn't exist!";

    public AbstractCreatureFactory getInstance(Fraction aFraction) {

        switch (aFraction) {
            case CASTLE:
                return new CastleFactory();
            case NECROPOLIS:
                return new NecropolisFactory();
            case DUNGEON:
                return new DungeonFactory();
            default:
                throw new IllegalArgumentException(EXCEPTION_MESSAGE);
        }
    }
}
