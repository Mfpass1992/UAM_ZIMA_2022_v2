package pl.sdk;

import lombok.Getter;
import pl.sdk.creatures.Creature;

import java.util.List;

public class Hero {
    @Getter
    private final List<Creature> creatures;

    public Hero(List<Creature> aCreatures) {
        creatures = aCreatures;
    }
}
