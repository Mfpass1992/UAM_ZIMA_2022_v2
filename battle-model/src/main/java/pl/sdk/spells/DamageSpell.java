package pl.sdk.spells;

import pl.sdk.creatures.Creature;

public class DamageSpell {
    private final SpellStatisticIf stats;
    private final DamageSpellStatisticIf damageSpellStatistics;
    private Creature targetCreature;
    private final int power;

    DamageSpell(SpellStatisticIf spellStatistic, DamageSpellStatisticIf damageSpellStats, int aPower) {
        stats = spellStatistic;
        damageSpellStatistics = damageSpellStats;
        targetCreature = null;
        power = aPower;
    }

    //zmienione na public
    public void addTargetCreature(Creature creature) {
        targetCreature = creature;
    }

    public void cast() {
        targetCreature.applyDamage(calculateDamage());
    }

    int calculateDamage() {
        return ( (power * damageSpellStatistics.getModifierA()) + damageSpellStatistics.getModifierB() );
    }

    public String getName() {
        return stats.getName();
    }

    String getSchool() {
        return stats.getSchool();
    }

    int getManaCost() {
        return stats.getManaCost();
    }

    int getDuration() {
        return getDuration();
    }

    int getTier() {
        return stats.getTier();
    }

    String getDescription() {
        return stats.getDescription();
    }

    String getBasicEffectDescription() {
        return stats.getBasicEffectDescription();
    }

    String getAdvancedEffectDescription() {
        return stats.getAdvancedEffectDescription();
    }

    String getExpertEffectDescription() {
        return stats.getExpertEffectDescription();
    }
}
