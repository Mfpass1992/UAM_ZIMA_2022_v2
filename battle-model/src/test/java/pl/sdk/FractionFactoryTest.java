package pl.sdk;

import org.junit.jupiter.api.Test;
import pl.sdk.creatures.*;

import static org.junit.jupiter.api.Assertions.*;

public class FractionFactoryTest {

    @Test
    public void ShouldCreateInstanceOfCastleFraction() {
        FractionFactory test = new FractionFactory();
        AbstractCreatureFactory factory = test.getInstance(Fractions.CASTLE);

        assertTrue(factory instanceof CastleFactory);
    }

    @Test
    public void ShouldNotCreateOtherInstaceFractionThanCastle() {
        FractionFactory test = new FractionFactory();
        AbstractCreatureFactory factory = test.getInstance(Fractions.CASTLE);

        assertFalse(factory instanceof DungeonFactory);
        assertFalse(factory instanceof NecropolisFactory);
    }

    @Test
    public void ShouldCreateInstanceOfDungeonFraction() {
        FractionFactory test = new FractionFactory();
        AbstractCreatureFactory factory = test.getInstance(Fractions.DUNGEON);

        assertTrue(factory instanceof DungeonFactory);
    }

    @Test
    public void ShouldNotCreateOtherInstaceFractionThanDungeon() {
        FractionFactory test = new FractionFactory();
        AbstractCreatureFactory factory = test.getInstance(Fractions.DUNGEON);

        assertFalse(factory instanceof CastleFactory);
        assertFalse(factory instanceof NecropolisFactory);
    }

    @Test
    public void ShouldCreateInstanceOfNecropolisFraction() {
        FractionFactory test = new FractionFactory();
        AbstractCreatureFactory factory = test.getInstance(Fractions.NECROPOLIS);

        assertTrue(factory instanceof NecropolisFactory);
    }

    @Test
    public void ShouldNotCreateOtherInstaceFractionThanNecropolis() {
        FractionFactory test = new FractionFactory();
        AbstractCreatureFactory factory = test.getInstance(Fractions.NECROPOLIS);

        assertFalse(factory instanceof DungeonFactory);
        assertFalse(factory instanceof CastleFactory);
    }
}
