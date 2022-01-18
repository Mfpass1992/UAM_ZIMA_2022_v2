package pl.sdk.creatures;

public enum Fractions implements FractionsIf{

    NECROPOLIS("Necropolis"),
    CASTLE("Caste"),
    DUNGEON("Dungeon");


    private final String fraction;

    Fractions(String aFraction) {
        this.fraction = aFraction;
    }

    public String getFraction() {
        return fraction;
    }
}
