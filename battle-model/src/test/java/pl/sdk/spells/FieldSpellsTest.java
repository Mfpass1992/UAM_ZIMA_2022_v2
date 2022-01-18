//package pl.sdk.spells;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import pl.sdk.creatures.Creature;
//import pl.sdk.creatures.NecropolisFactory;
//import pl.sdk.Board;
//import static org.junit.jupiter.api.Assertions.*;
//
//class FieldSpellsTest {
//
//    private GameEngine engine;
//    private Creature creature;
//
//    @BeforeEach
//    void init(){
//        creature = NecropolisFactory.createDefaultForTests();
//        engine = new GameEngine(new ArrayList<>(List.of(creature)), Collections.emptyList());
//    }
//
//
//    @Test
//    void shouldBeTrueIfRemoveObstaclesWorksCorrectly() {
//        SpecialField field = SpecialFieldFactory.createImpassableField();
//        engine.createSpecialField(new Point(5,5), field);
//
//        Spell removeObstacles = SpellFactory.getSpell(Spells.REMOVE_OBSTACLES);
//        hero.cast(removeObstacles).onField(engine.getField(new Point(5,5)));
//
//        boolean canMove = engine.canMove(5, 5);
//
//        assertTrue(canMove);
//    }
//
//
//    @Test
//    void shouldBeTrueIfForceFieldWorksCorrectly() {
//        SpecialField expectedFieldType = SpecialFieldFactory.createImpassableField();
//
//        Spell forceField = SpellFactory.getSpell(Spells.FORCE_FIELD);
//        hero.cast(forceField).onField(new Point(5,5));
//
//        assertEquals(expectedFieldType, engine.getField(new Point(5,5)));
//        assertEquals(expectedFieldType, engine.getField(new Point(5,6)));
//    }
//
//    @Test
//    void shouldBeTrueIfFireWallWorksCorrectly() {
//        SpecialField expectedFieldType = SpecialFieldFactory.createFireField();
//
//        Spell fireWall = SpellFactory.getSpell(Spells.FIRE_WALL);
//        hero.cast(fireWall).onField(new Point(5,5));
//
//        assertEquals(expectedFieldType, engine.getField(new Point(5,5)));
//        assertEquals(expectedFieldType, engine.getField(new Point(5,6)));
//    }
//}
