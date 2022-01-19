package pl.sdk.fields;

public enum SpecialFieldType {
    SPELL_FIELD(1),
    DAMAGE_FIELD(1),
    OBSTACLE_FIELD(1),
    DESTRUCTIBLE_FIELD(1);
    private int weight;

    SpecialFieldType(int weight){
        this.weight = weight;
    }

    public int getWeight(){
        return this.weight;
    }
}
