package pl.sdk.hero;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.sdk.creatures.EconomyNecropolisFactory;

import static org.junit.jupiter.api.Assertions.*;

class EconomyHeroTest {

    private EconomyHeroFactory economyHeroFactory;
    private EconomyHero economyHero;

    @BeforeEach
    void init(){
        economyHeroFactory = new EconomyHeroFactory();
        economyHero = economyHeroFactory.create("Clavius", 1000);
    }
    @Test
    void heroShouldHave1AttackAnd2Defense(){
        assertEquals(economyHero.getHeroAttack(),1);
        assertEquals(economyHero.getHeroDefense(),2);
    }
    @Test
    void fractionOfHeroShouldBeNecropolis(){
        assertEquals(economyHero.getHeroFraction(), "NECROPOLIS");
    }

    @Test
    void shouldThrowExceptionWhileHeroHas7CreatureAndYoTryToAddNextOne(){
        EconomyNecropolisFactory factory = new EconomyNecropolisFactory();
        economyHero.addCreature(factory.create(true,1,1));
        economyHero.addCreature(factory.create(true,1,1));
        economyHero.addCreature(factory.create(true,1,1));
        economyHero.addCreature(factory.create(true,1,1));
        economyHero.addCreature(factory.create(true,1,1));
        economyHero.addCreature(factory.create(true,1,1));
        economyHero.addCreature(factory.create(true,1,1));

        assertThrows(IllegalStateException.class, () -> economyHero.addCreature(factory.create(true,1,1)));
    }

    @Test
    void shouldThrowExceptionWhileYouTrySubstractMoreGoldThanHeroHas(){
        assertThrows(IllegalStateException.class, () -> economyHero.substractGold(3001));
    }
}