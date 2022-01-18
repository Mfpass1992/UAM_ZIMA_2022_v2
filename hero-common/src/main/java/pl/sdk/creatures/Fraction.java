package pl.sdk.creatures;

public enum Fraction implements FractionsIf{

    NECROPOLIS("Necropolis"),
    CASTLE("Caste"),
    DUNGEON("Dungeon");


    private final String fraction;

    Fraction(String aFraction) {
        this.fraction = aFraction;
    }

    public String getFraction() {
        return fraction;
    }
}
