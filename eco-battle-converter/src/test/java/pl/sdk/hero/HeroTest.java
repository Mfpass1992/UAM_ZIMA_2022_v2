package pl.sdk.hero;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.sdk.EconomyEngine;
import pl.sdk.creatures.Creature;
import pl.sdk.creatures.CreatureStatisticIf;
import pl.sdk.creatures.CreatureStatisticModifier;
import pl.sdk.creatures.NecropolisFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HeroTest {
    private EconomyHero economyHero;
    private EconomyHeroFactory economyHeroFactory;
    private HeroFactory heroFactory;
    private NecropolisFactory necropolisFactory;

    @BeforeEach
    void init(){
        economyHeroFactory = new EconomyHeroFactory();
        heroFactory = new HeroFactory();
        necropolisFactory = new NecropolisFactory();
    }

    @Test
    void heroShouldHave2MoreAttackand2MoreDefense(){
        HeroStatsModifier heroModifier = new HeroStatsModifier.Builder().heroAttack(2).heroDefense(2).build();
        economyHeroFactory.addModifier(heroModifier);

        EconomyHero economyHero = economyHeroFactory.create(HeroStatistic.SANYA.getHeroName(), 2000);
        // Hero Stats - attack = 1, defense = 0
        assertEquals(economyHero.getHeroAttack(), 3);
        assertEquals(economyHero.getHeroDefense(), 2);
    }

    @Test
    void creatureShouldHave2MoreDefenseAnd1MoreAttack(){

        economyHero = economyHeroFactory.create(HeroStatistic.CLAVIUS.getHeroName(), 2000);
        CreatureStatisticIf modifier = heroFactory.create(economyHero);
        necropolisFactory.addModifier(modifier);

        Creature modified = necropolisFactory.create(false,1,1);
        // creature stats - attack = 5, armor = 4

        assertEquals(modified.getAttack(), 6);
        assertEquals(modified.getArmor(), 6);
    }
}

