package pl.sdk.artifacts;

public class EconomyArtifactFactory {

    private static final String EXCEPTION_MESSAGE = "Artifact of such name doesn't exist";

    public EconomyArtifact create(String name) {
        if(ArtifactInfo.ORB_OF_THE_FIRMAMENT.getTranslatedName().equals(name))
            return new EconomyArtifact(ArtifactInfo.ORB_OF_THE_FIRMAMENT, 6000);
        if(ArtifactInfo.ORB_OF_SLIT.getTranslatedName().equals(name))
            return new EconomyArtifact(ArtifactInfo.ORB_OF_SLIT, 6000);
        if(ArtifactInfo.ORB_OF_TEMPESTUOUS_FIRE.getTranslatedName().equals(name))
            return new EconomyArtifact(ArtifactInfo.ORB_OF_TEMPESTUOUS_FIRE, 6000);
        if(ArtifactInfo.ORB_OF_DRIVING_RAIN.getTranslatedName().equals(name))
            return new EconomyArtifact(ArtifactInfo.ORB_OF_DRIVING_RAIN, 6000);
        if(ArtifactInfo.TOME_OF_AIR_MAGIC.getTranslatedName().equals(name))
            return new EconomyArtifact(ArtifactInfo.TOME_OF_AIR_MAGIC, 20000);
        if(ArtifactInfo.TOME_OF_EARTH_MAGIC.getTranslatedName().equals(name))
            return new EconomyArtifact(ArtifactInfo.TOME_OF_EARTH_MAGIC, 20000);
        if(ArtifactInfo.TOME_OF_FIRE_MAGIC.getTranslatedName().equals(name))
            return new EconomyArtifact(ArtifactInfo.TOME_OF_FIRE_MAGIC, 20000);
        if(ArtifactInfo.TOME_OF_WATER_MAGIC.getTranslatedName().equals(name))
            return new EconomyArtifact(ArtifactInfo.TOME_OF_WATER_MAGIC, 20000);
        if(ArtifactInfo.RING_OF_VITALITY.getTranslatedName().equals(name))
            return new EconomyArtifact(ArtifactInfo.RING_OF_VITALITY, 5000);
        if(ArtifactInfo.VIAL_OF_LIFEBLOOD.getTranslatedName().equals(name))
            return new EconomyArtifact(ArtifactInfo.VIAL_OF_LIFEBLOOD, 10000);
        if(ArtifactInfo.NECKLACE_OF_SWIFTNESS.getTranslatedName().equals(name))
            return new EconomyArtifact(ArtifactInfo.NECKLACE_OF_SWIFTNESS, 5000);
        if(ArtifactInfo.CAPE_OF_VELOCITY.getTranslatedName().equals(name))
            return new EconomyArtifact(ArtifactInfo.CAPE_OF_VELOCITY, 10000);
        if(ArtifactInfo.CENTAURS_AXE.getTranslatedName().equals(name))
            return new EconomyArtifact(ArtifactInfo.CENTAURS_AXE, 2000);
        if(ArtifactInfo.TITANS_GLADIUS.getTranslatedName().equals(name))
            return new EconomyArtifact(ArtifactInfo.TITANS_GLADIUS, 10000);
        if(ArtifactInfo.SHIELD_OF_THE_DWARVEN_LORDS.getTranslatedName().equals(name))
            return new EconomyArtifact(ArtifactInfo.SHIELD_OF_THE_DWARVEN_LORDS, 2000);
        if(ArtifactInfo.SENTINELS_SHIELD.getTranslatedName().equals(name))
            return new EconomyArtifact(ArtifactInfo.SENTINELS_SHIELD, 10000);

        throw new IllegalArgumentException(EXCEPTION_MESSAGE);
    }
}
