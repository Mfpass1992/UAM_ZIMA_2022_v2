package pl.sdk.creatures;

public class EconomyDungeonFactory {
    private static final String EXCEPTION_MESSAGE = "We support tiers from 1 to 7";

    public EconomyCreature create(boolean aIsUpgraded, int aTier, int aAmount) {
        if (!aIsUpgraded) {
            switch (aTier) {
                case 1:
                    return new EconomyCreature(CreatureStatistic.TROGLODYTE, aAmount, 50);
                case 2:
                    return new EconomyCreature(CreatureStatistic.HARPY, aAmount, 130);
                case 3:
                    return new EconomyCreature(CreatureStatistic.BEHOLDER, aAmount, 250);
                case 4:
                    return new EconomyCreature(CreatureStatistic.MEDUSA, aAmount, 300);
                case 5:
                    return new EconomyCreature(CreatureStatistic.MINOTAUR, aAmount, 500);
                case 6:
                    return new EconomyCreature(CreatureStatistic.MANTICORE, aAmount, 850);
                case 7:
                    return new EconomyCreature(CreatureStatistic.RED_DRAGON, aAmount, 2500);
                default:
                    throw new IllegalArgumentException(EXCEPTION_MESSAGE);
            }
        } else {
            switch (aTier) {
                case 1:
                    return new EconomyCreature(CreatureStatistic.INFERNAL_TROGLODYTE, aAmount, 65);
                case 2:
                    return new EconomyCreature(CreatureStatistic.HARPY_HAG, aAmount, 170);
                case 3:
                    return new EconomyCreature(CreatureStatistic.EVIL_EYE, aAmount, 280);
                case 4:
                    return new EconomyCreature(CreatureStatistic.MEDUSA_QUEEN, aAmount, 330);
                case 5:
                    return new EconomyCreature(CreatureStatistic.MINOTAUR_KING, aAmount, 575);
                case 6:
                    return new EconomyCreature(CreatureStatistic.SCORPICORE, aAmount, 1050);
                case 7:
                    return new EconomyCreature(CreatureStatistic.BLACK_DRAGON, aAmount, 4000);
                default:
                    throw new IllegalArgumentException(EXCEPTION_MESSAGE);
            }
        }
    }
}
