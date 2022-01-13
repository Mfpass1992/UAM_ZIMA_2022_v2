package pl.sdk.artifacts;

enum ArtifactInfo implements ArtifactInfoIf {

    // SPELL
    ORB_OF_THE_FIRMAMENT("Orb of the Firmament", "Hero's air spells deal extra 50% damage", ArtifactSlotType.MISC),
    ORB_OF_SLIT("Orb of Slit", "Hero's earth spells deal extra 50% damage", ArtifactSlotType.MISC),
    ORB_OF_TEMPESTUOUS_FIRE("Orb of Tempestuous Fire", "Hero's fire spells deal extra 50% damage", ArtifactSlotType.MISC),
    ORB_OF_DRIVING_RAIN("Orb of Driving Rain", "Hero's water spells deal extra 50% damage", ArtifactSlotType.MISC),
    TOME_OF_AIR_MAGIC("Tome of Air Magic", "All air spells are available to hero when equipped", ArtifactSlotType.MISC),
    TOME_OF_EARTH_MAGIC("Tome of Earth Magic", "All earth spells are available to hero when equipped", ArtifactSlotType.MISC),
    TOME_OF_FIRE_MAGIC("Tome of Fire Magic", "All fire spells are available to hero when equipped", ArtifactSlotType.MISC),
    TOME_OF_WATER_MAGIC("Tome of Water Magic", "All water spells are available to hero when equipped", ArtifactSlotType.MISC),

    // COMBAT
    RING_OF_VITALITY("Ring of Vitality", "Increases health of all your units by 1", ArtifactSlotType.FINGERS),
    VIAL_OF_LIFEBLOOD("Vial of Lifeblood", "Increases health of all your units by 2", ArtifactSlotType.MISC),
    NECKLACE_OF_SWIFTNESS("Necklace of Swiftness", "Increases the combat speed of all your units by 1", ArtifactSlotType.NECK),
    CAPE_OF_VELOCITY("Cape of Velocity", "Increases the combat speed of all your units by 2", ArtifactSlotType.SHOULDERS),

    // PRIMARY
    CENTAURS_AXE("Centaur's Axe", "+2 attack skill", ArtifactSlotType.RIGHT_HAND),
    TITANS_GLADIUS("Titan's Gladius", "+12 attack skill, -3 defence skill", ArtifactSlotType.RIGHT_HAND),
    SHIELD_OF_THE_DWARVEN_LORDS("Shield of the Dwarven Lords", "+2 defence skill", ArtifactSlotType.LEFT_HAND),
    SENTINELS_SHIELD("Sentinel's Shield", "+12 defence skill, -3 attack skill", ArtifactSlotType.LEFT_HAND);


    private final String name;
    private final String description;
    private final ArtifactSlotType slot;

    ArtifactInfo (String aName, String aDescription, ArtifactSlotType aSlot) {
        name = aName;
        description = aDescription;
        slot = aSlot;
    }

    public String getTranslatedName() {
        return name;
    }

    public String getDescription() { return description; }

    public ArtifactSlotType getSlot() { return slot; }

}
