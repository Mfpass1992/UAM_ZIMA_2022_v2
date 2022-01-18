package pl.sdk.spells;

/**
 * TODO: Describe this class (The first line - until the first dot - will interpret as the brief description).
 */
public class SpellFactory {
    private final String EXCEPTION_MESSAGE_MASTERY = "No such mastery!";
    private final String EXCEPTION_MESSAGE_SPELL = "No such spell!";

    public DamageSpell createDamageSpell(int mastery, int power, SpellStatistics statistics) {
        switch (statistics.getName()) {
            case "Ice Bolt":{
                switch (mastery) {
                    case 1:
                        return new DamageSpell(statistics, DamageSpellStatistics.ICE_BOLT_MASTERY_1, power);
                    case 2:
                        return new DamageSpell(statistics, DamageSpellStatistics.ICE_BOLT_MASTERY_2, power);
                    case 3:
                        return new DamageSpell(statistics, DamageSpellStatistics.ICE_BOLT_MASTERY_3, power);
                    default:
                        throw new IllegalArgumentException(EXCEPTION_MESSAGE_MASTERY);
                }
            }
            case "Magic Arrow": {
                switch(mastery) {
                    case 1:
                        return new DamageSpell(statistics, DamageSpellStatistics.MAGIC_ARROW_MASTERY_1, power);
                    case 2:
                        return new DamageSpell(statistics, DamageSpellStatistics.MAGIC_ARROW_MASTERY_2, power);
                    case 3:
                        return new DamageSpell(statistics, DamageSpellStatistics.MAGIC_ARROW_MASTERY_3, power);
                    default:
                        throw new IllegalArgumentException(EXCEPTION_MESSAGE_MASTERY);
                }
            }
            case "Lightning Bolt": {
                switch(mastery) {
                    case 1:
                        return new DamageSpell(statistics, DamageSpellStatistics.LIGHTNING_BOLT_MASTERY_1, power);
                    case 2:
                        return new DamageSpell(statistics, DamageSpellStatistics.LIGHTNING_BOLT_MASTERY_2, power);
                    case 3:
                        return new DamageSpell(statistics, DamageSpellStatistics.LIGHTNING_BOLT_MASTERY_3, power);
                    default:
                        throw new IllegalArgumentException(EXCEPTION_MESSAGE_MASTERY);
                }
            }
            default:
                throw new IllegalArgumentException(EXCEPTION_MESSAGE_SPELL);
        }
    }
}

