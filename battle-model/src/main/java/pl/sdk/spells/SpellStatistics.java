package pl.sdk.spells;

public enum SpellStatistics implements SpellStatisticIf {

    // TEST SPELL
    ICE_BOLT("Ice Bolt",
        "Water",
        8,
        0,
        2,
        "Drains the body heat from the selected enemy unit",
        "Target, enemy troop receives ((Power x 20) + 10) damage.",
        "Target, enemy troop receives ((Power x 20) + 20) damage.",
        "Target, enemy troop receives ((Power x 20) + 50) damage."),

    MAGIC_ARROW("Magic Arrow",
            "Water",
            5,
            0,
            1,
            "Causes a bolt of magical energy to strike the selected unit.",
            "Target, enemy troop receives ((Power x 10) + 10) damage.",
            "Target, enemy troop receives ((Power x 10) + 20) damage.",
            "Target, enemy troop receives ((Power x 10) + 30) damage."),

    LIGHTNING_BOLT("Lightning Bolt",
            "Air",
            10,
            0,
            2,
            "Causes a bolt of lightning to strike the selected unit.",
            "Target, enemy creature receives ((Power x 25) + 10) damage.",
            "Target, enemy creature receives ((Power x 25) + 20) damage.",
            "Target, enemy creature receives ((Power x 25) + 50) damage."
    );

    private final String name;
    private final String school;
    private final int manaCost;
    private final int duration;
    private final int tier;
    private final String description;
    private final String basicEffectDescription;
    private final String advancedEffectDescription;
    private final String expertEffectDescription;

    SpellStatistics(String aName,
                   String aSchool,
                   int aManaCost,
                   int aDuration,
                   int aTier,
                   String aDescription,
                   String aBasicEffectDescription,
                   String aAdvancedEffectDescription,
                   String aExpertEffectDescription
                   ) {
        name = aName;
        school = aSchool;
        manaCost = aManaCost;
        duration = aDuration;
        tier = aTier;
        description = aDescription;
        basicEffectDescription = aBasicEffectDescription;
        advancedEffectDescription = aAdvancedEffectDescription;
        expertEffectDescription = aExpertEffectDescription;
    }

    public String getName() {
        return name;
    }

    public String getSchool() {
        return school;
    }

    public int getManaCost() {
        return manaCost;
    }

    public int getDuration() {
        return duration;
    }

    public int getTier() {
        return tier;
    }

    public String getDescription() {
        return description;
    }

    public String getBasicEffectDescription() {
        return basicEffectDescription;
    }

    public String getAdvancedEffectDescription() {
        return advancedEffectDescription;
    }

    public String getExpertEffectDescription() {
        return expertEffectDescription;
    }
}
