package pl.sdk;

import org.junit.jupiter.api.Test;
import pl.sdk.creatures.Creature;
import pl.sdk.creatures.NecropolisFactory;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.spy;

class GameEngineTest {

    private Hero hero1,hero2;

    @Test
    void shouldRecognizeFriendlyCreatureAndDoNotAttackHer(){
        NecropolisFactory factory = new NecropolisFactory();
        hero1 = new Hero(List.of(factory.create(true, 5,1), spy(Creature.class)));
        hero2 = new Hero(List.of(spy(Creature.class)));


        GameEngine engine = new GameEngine(hero1,hero2);
        assertTrue(engine.canAttack(GameEngine.BOARD_WIDTH-1, 1));
        assertFalse(engine.canAttack(0,1));
        assertFalse(engine.canAttack(0,1));
    }

    @Test
    void shouldRecognizeFriedlyCreatureAndDoNotCastSpell(){
        NecropolisFactory factory = new NecropolisFactory();
        hero1 = new Hero(List.of(factory.create(true, 5,1), spy(Creature.class)));
        hero2 = new Hero(List.of(spy(Creature.class)));

        GameEngine engine = new GameEngine(hero1,hero2);
        assertTrue(engine.canBeTargetedBySPell(GameEngine.BOARD_WIDTH-1, 1));
        assertFalse(engine.canBeTargetedBySPell(0,1));
    }

    //Przetestować metodę cast, kiedy pojawi się dodatkowa logika



}