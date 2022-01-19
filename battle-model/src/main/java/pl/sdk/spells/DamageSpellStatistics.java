package pl.sdk.spells;

enum DamageSpellStatistics implements DamageSpellStatisticIf{
    // ICE BOLT SPELLS
    ICE_BOLT_MASTERY_1(20, 10),
    ICE_BOLT_MASTERY_2(20,20),
    ICE_BOLT_MASTERY_3(20, 50),

    MAGIC_ARROW_MASTERY_1(10,10),
    MAGIC_ARROW_MASTERY_2(10,20),
    MAGIC_ARROW_MASTERY_3(10,20),

    LIGHTNING_BOLT_MASTERY_1(25,10),
    LIGHTNING_BOLT_MASTERY_2(25,20),
    LIGHTNING_BOLT_MASTERY_3(25,50);

 private final int modifierA;
    private final int modifierB;

    DamageSpellStatistics(int aModifierA, int aModifierB) {
        modifierA = aModifierA;
        modifierB = aModifierB;
    }

    public int getModifierA() {
        return modifierA;
    }

    public int getModifierB() {
        return modifierB;
    }
}
