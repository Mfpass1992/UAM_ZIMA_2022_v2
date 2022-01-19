package pl.sdk.spells;

public interface SpellStatisticIf {
    String getName();

    String getSchool();

    int getManaCost();

    int getDuration();

    int getTier();

    String getDescription();

    String getBasicEffectDescription();

    String getAdvancedEffectDescription();

    String getExpertEffectDescription();
}
