package pl.sdk.artifacts;

import com.google.common.collect.Range;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.sdk.creatures.Creature;
import pl.sdk.creatures.CreatureStatisticIf;
import pl.sdk.creatures.CreatureStatisticModifier;
import pl.sdk.creatures.NecropolisFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArtifactTest {
    private ArtifactFactory artifactFactory;
    private NecropolisFactory necropolisFactory;

    @BeforeEach
    void init(){
        artifactFactory = new ArtifactFactory();
        necropolisFactory = new NecropolisFactory();
    }

    @Test
    void creatureShouldHave1MoreHpWhenRingOfVitalityIsApplied() {
        CreatureStatisticIf modifier = artifactFactory.create(ArtifactInfo.RING_OF_VITALITY.getTranslatedName());
        necropolisFactory.addModifier(modifier);

        Creature modifiedCreature = necropolisFactory.create(false, 1, 1);

        assertEquals(7, modifiedCreature.getCurrentHp());
    }

    @Test
    void combinedArtifactsShouldAddUpTheirStats() {
        CreatureStatisticIf modifier1 = artifactFactory.create(ArtifactInfo.RING_OF_VITALITY.getTranslatedName());
        CreatureStatisticIf modifier2 = artifactFactory.create(ArtifactInfo.VIAL_OF_LIFEBLOOD.getTranslatedName());
        necropolisFactory.addModifier(modifier1);
        necropolisFactory.addModifier(modifier2);

        Creature creature = necropolisFactory.create(false, 1, 1);

        assertEquals(9, creature.getCurrentHp());
    }

    @Test
    void creatureShouldHave12MoreAttackAnd3LessArmorWhenTitansGladiusIsApplied() {
        CreatureStatisticIf modifier = artifactFactory.create(ArtifactInfo.TITANS_GLADIUS.getTranslatedName());
        necropolisFactory.addModifier(modifier);

        Creature creature = necropolisFactory.create(false, 1, 1);

        assertEquals(17, creature.getAttack());
        assertEquals(1, creature.getArmor());
    }
}
