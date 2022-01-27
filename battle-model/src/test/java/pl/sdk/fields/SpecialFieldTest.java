package pl.sdk.fields;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.sdk.GameEngine;
import pl.sdk.Hero;
import pl.sdk.MoveType;
import pl.sdk.Point;
import pl.sdk.creatures.Creature;
import pl.sdk.creatures.NecropolisFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SpecialFieldTest {
    private Hero hero1,hero2;
    private GameEngine engine;
    private Creature creature;
    @BeforeEach
    void init(){
        creature = NecropolisFactory.createDefaultForTests();
        hero1 = new Hero(List.of(creature));
        hero2 = new Hero(Collections.emptyList());
        engine = new GameEngine(hero1, hero2);
    }

    @Test
    void shouldFieldBePutOnBoard(){
        SpecialField field = SpecialFieldsFactory.createObstacleField(15);
        engine.insertSpecialFieldToBoard(new Point(1,3), field);

        assertEquals(field, engine.getField(1, 3));

    }

    @Test
    void shouldWalkingCreatureStepOnDamageField() {
        engine.insertSpecialFieldToBoard(new Point(5,5), SpecialFieldsFactory.createDamageField(1, 1, MoveType.WALKING));
        SpecialField field = engine.getField(5,5);
        int prevHp = engine.getActiveCreature().getCurrentHp();

        field.triggerEffect(engine.getActiveCreature());
        int afterHp = engine.getActiveCreature().getCurrentHp();

        assertEquals(prevHp - 1 , afterHp);
    }

    @Test
    void shouldCreatureMoveToFieldWithObstacle() {
        engine.insertSpecialFieldToBoard(new Point(1,2), SpecialFieldsFactory.createObstacleField(5));

        boolean canMove = engine.canMove(1, 2);

        assertFalse(canMove);
    }

    @Test
    void shouldDestroySpecialField() {
        SpecialField field = SpecialFieldsFactory.createObstacleField(3);
        engine.insertSpecialFieldToBoard(new Point(3, 3), field);

        engine.pass();
        engine.pass();
        engine.pass();

        assertNull(engine.getField(3, 3));
    }

    @Test
    void shouldDeal2DamageToDestructibleField() {
        DestructibleField field = SpecialFieldsFactory.createDestructibleField(5, 10);
        engine.insertSpecialFieldToBoard(new Point(1, 2), field);

        engine.attack(1, 2);

        assertEquals(8, field.getHp());
    }

    @Test
    void shouldDestroyDestructibleFieldAfterAttack() {
        DestructibleField field = SpecialFieldsFactory.createDestructibleField(5, 2);
        engine.insertSpecialFieldToBoard(new Point(1, 2), field);

        engine.attack(1, 2);

        assertNull(engine.getField(1,2));
    }

    @Test
    void shouldFlyingCreatureStepOnDamageField() {
        engine.insertSpecialFieldToBoard(new Point(5,5), SpecialFieldsFactory.createDamageField(1, 5, MoveType.FLYING));
        SpecialField field = engine.getField(5,5);
        int prevHp = engine.getActiveCreature().getCurrentHp();

        field.triggerEffect(engine.getActiveCreature());
        int afterHp = engine.getActiveCreature().getCurrentHp();

        assertEquals(prevHp - 1, afterHp);

    }

    @Test
    void shouldThrowIllegalArgumentExWhenFieldIsAddedOnNonEmptyField(){
        engine.insertSpecialFieldToBoard(new Point(5,5), SpecialFieldsFactory.createDamageField(1, 5, MoveType.FLYING));

        assertThrows(IllegalArgumentException.class, () -> engine.insertSpecialFieldToBoard(new Point(5,5), SpecialFieldsFactory.createObstacleField(2)));
    }
}