package pl.sdk.creatures;

import com.google.common.collect.Range;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.sdk.GameEngine;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static pl.sdk.creatures.CreatureStatistic.TEST;

public class DoubleAttackCreatureTest {

    int NOT_IMPORTANT = 5;
    int MORE_THAN_SECOND_CREATURE = NOT_IMPORTANT+1;

    CalculateDamageStrategy calc = new DefaultCalculateStrategy();


    @Test
    void creatureShouldAttackTwice(){
        Creature doubleAttackCreature = new Creature.BuilderForTesting()
                .name("Double attack")
                .maxHp(100)
                .attack(NOT_IMPORTANT)
                .armor(NOT_IMPORTANT)
                .damage(Range.closed(NOT_IMPORTANT, NOT_IMPORTANT))
                .moveRange(MORE_THAN_SECOND_CREATURE)
                .amount(NOT_IMPORTANT)
                .build();
        doubleAttackCreature = new DoubleAttackCreatureDecorator(doubleAttackCreature);

        Creature normalCreature = new Creature.BuilderForTesting()
                .name("Normal unit")
                .maxHp(100)
                .attack(NOT_IMPORTANT)
                .armor(NOT_IMPORTANT)
                .damage(Range.closed(NOT_IMPORTANT, NOT_IMPORTANT))
                .moveRange(NOT_IMPORTANT)
                .amount(NOT_IMPORTANT)
                .build();

        CalculateDamageStrategy calc = new DefaultCalculateStrategy();

        int doubleAttackCreatureDamage = calc.calculateDamage(doubleAttackCreature, normalCreature);
        int normalCreatureDamage = calc.calculateDamage(normalCreature, doubleAttackCreature);
        assertEquals(normalCreatureDamage*2, doubleAttackCreatureDamage);



    }

}
