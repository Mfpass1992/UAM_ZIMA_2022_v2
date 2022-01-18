package pl.sdk.artifacts;

import pl.sdk.creatures.CreatureStatisticIf;
import pl.sdk.creatures.CreatureStatisticModifier;


class ArtifactFactory {
    CreatureStatisticIf create(String aName) {
        if(ArtifactInfo.RING_OF_VITALITY.getTranslatedName().equals(aName))
            return new CreatureStatisticModifier.Builder().maxHp(1).build();
        if(ArtifactInfo.VIAL_OF_LIFEBLOOD.getTranslatedName().equals(aName))
            return new CreatureStatisticModifier.Builder().maxHp(2).build();
        if(ArtifactInfo.NECKLACE_OF_SWIFTNESS.getTranslatedName().equals(aName))
            return new CreatureStatisticModifier.Builder().moveRange(1).build();
        if(ArtifactInfo.CAPE_OF_VELOCITY.getTranslatedName().equals(aName))
            return new CreatureStatisticModifier.Builder().moveRange(2).build();
        if(ArtifactInfo.CENTAURS_AXE.getTranslatedName().equals(aName))
            return new CreatureStatisticModifier.Builder().attack(2).build();
        if(ArtifactInfo.TITANS_GLADIUS.getTranslatedName().equals(aName))
            return new CreatureStatisticModifier.Builder().attack(12).armor(-3).build();
        if(ArtifactInfo.SHIELD_OF_THE_DWARVEN_LORDS.getTranslatedName().equals(aName))
            return new CreatureStatisticModifier.Builder().armor(2).build();
        if(ArtifactInfo.SENTINELS_SHIELD.getTranslatedName().equals(aName))
            return new CreatureStatisticModifier.Builder().armor(12).attack(-3).build();

        return new CreatureStatisticModifier.Builder().build();
    }
}
