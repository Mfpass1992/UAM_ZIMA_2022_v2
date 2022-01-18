package pl.sdk.creatures;

import com.google.common.collect.Range;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class DefaultDamageCalculatorWithSelfHealingTest {

    private int NOT_IMPORTANT = 5;
    private int THE_SAME_FOR_BOTH_CREATURES = 10;
    private Creature attacker;
    private Creature defender;
    private Random rand;
    final static float NO_HAND_TO_HAND_PENALTY = 1.0F;
    final static float HAND_TO_HAND_PENALTY = 0.5F;

    @BeforeEach
    void init(){
        rand = mock(Random.class);
        when(rand.nextInt(anyInt())).thenReturn(0);
        attacker = new Creature.BuilderForTesting()
                .name("Selfheal Test Unit")
                .maxHp(30)
                .attack(THE_SAME_FOR_BOTH_CREATURES)
                .armor(THE_SAME_FOR_BOTH_CREATURES)
                .damage(Range.closed(10, 20))
                .damageCalculator(new DefaultCalculateStrategy(rand))
                .moveRange(NOT_IMPORTANT)
                .amount(10)
                .build();
        attacker = new HealAfterAttackCreatureDecorator(attacker, 0.5);
        defender = new Creature.BuilderForTesting()
                .name("Defender")
                .maxHp(NOT_IMPORTANT)
                .attack(THE_SAME_FOR_BOTH_CREATURES)
                .armor(THE_SAME_FOR_BOTH_CREATURES)
                .damage(Range.closed(0, 0))
                .moveRange(NOT_IMPORTANT)
                .amount(NOT_IMPORTANT)
                .build();
    }

    @Test
    void shouldHeal50HpBecauseAttackedFor100(){
        attacker.attack(defender, NO_HAND_TO_HAND_PENALTY);

        assertEquals(11,attacker.getAmount());
        assertEquals(20,attacker.getCurrentHp());
    }

}