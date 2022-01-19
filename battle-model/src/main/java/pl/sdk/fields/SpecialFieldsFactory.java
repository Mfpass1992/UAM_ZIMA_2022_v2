package pl.sdk.fields;

import pl.sdk.MoveType;

public class SpecialFieldsFactory {

    public static DamageField createDamageField(int damage, int turns, MoveType moveType){
        return new DamageField(damage, turns, moveType);
    }

    public static ObstacleField createObstacleField(int turns){
        return new ObstacleField(turns);
    }

    public static DestructibleField createDestructibleField(int turns, int hp) {
        return new DestructibleField(turns, hp);
    }

}
