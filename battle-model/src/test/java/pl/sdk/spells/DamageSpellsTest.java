package pl.sdk.spells;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.sdk.creatures.Creature;
import pl.sdk.creatures.NecropolisFactory;
import static org.junit.jupiter.api.Assertions.*;

class DamageSpellsTest {
    private Creature defender;
    private NecropolisFactory creatureFactory;
    private SpellFactory spellFactory;

    @BeforeEach
    void init() {
        creatureFactory = new NecropolisFactory();
        defender = creatureFactory.create(false,7,1);
        spellFactory = new SpellFactory();
    }

    @Test
    void creatureShouldLost30HpFromIceBoltIfHeroHas1PowerAnd1Mastery() {
        DamageSpell iceBolt = spellFactory.createDamageSpell(1,1,SpellStatistics.ICE_BOLT);

        iceBolt.addTargetCreature(defender);
        iceBolt.cast();

        assertEquals(120,defender.getCurrentHp());
    }

    @Test
    void creatureShouldLost20HpFromMagicArrowIfHeroHas1PowerAnd1Mastery() {
        DamageSpell magicArrow = spellFactory.createDamageSpell(1,1,SpellStatistics.MAGIC_ARROW);

        magicArrow.addTargetCreature(defender);
        magicArrow.cast();

        assertEquals(130,defender.getCurrentHp());
    }

    @Test
    void creatureShouldLost35HpFromLightningBoltIfHeroHas1PowerAnd1Mastery(){
        DamageSpell lightningBolt = spellFactory.createDamageSpell(1,1,SpellStatistics.LIGHTNING_BOLT);

        lightningBolt.addTargetCreature(defender);
        lightningBolt.cast();

        assertEquals(115,defender.getCurrentHp());
    }

    @Test
    void creatureShouldLost35HpFromLightningBoltIfHeroHas2PowerAnd1Mastery(){
        DamageSpell lightningBolt = spellFactory.createDamageSpell(2,2,SpellStatistics.LIGHTNING_BOLT);

        lightningBolt.addTargetCreature(defender);
        lightningBolt.cast();

        assertEquals(80,defender.getCurrentHp());
    }
}
