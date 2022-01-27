package pl.sdk;

import com.google.common.collect.Range;
import org.junit.jupiter.api.Test;
import pl.sdk.GameEngine;
import pl.sdk.creatures.Creature;
import pl.sdk.creatures.NecropolisFactory;

import java.beans.PropertyChangeEvent;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

public class EndOfTurnTests {
    final static float NO_HAND_TO_HAND_PENALTY = 1.0F;
    final static float HAND_TO_HAND_PENALTY = 0.5F;
    Hero hero1,hero2;

    @Test
    void shouldResetCounterAttackFlagAfterEndOfTurn(){
        Creature attacker = NecropolisFactory.createDefaultForTests();
        Creature defender = NecropolisFactory.createDefaultForTests();
        hero1 = new Hero(List.of(attacker));
        hero2 = new Hero(List.of(defender));
        GameEngine engine = new GameEngine(hero1, hero2);

        assertEquals(true, defender.canCounterAttack());
        attacker.attack(defender);
        assertEquals(false, defender.canCounterAttack());

        engine.pass();
        engine.pass();
        assertEquals(true, defender.canCounterAttack());
    }

    @Test
    void shouldCallPropertyChangeAfterEndOfTurn(){
        Creature attacker = spy(Creature.class);
        Creature defender = NecropolisFactory.createDefaultForTests();
        hero1 = new Hero(List.of(attacker));
        hero2 = new Hero(List.of(defender));
        GameEngine engine = new GameEngine(hero1, hero2);

        engine.pass();
        engine.pass();
        verify(attacker).propertyChange(any(PropertyChangeEvent.class));
    }
}
