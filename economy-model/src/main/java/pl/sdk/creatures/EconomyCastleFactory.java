package pl.sdk.creatures;

public class EconomyCastleFactory {

    private static final String EXCEPTION_MESSAGE = "We support tiers from 1 to 7";

    public EconomyCreature create(boolean aIsUpgraded, int aTier, int aAmount) {
        if (!aIsUpgraded) {
            switch (aTier) {
                case 1:
                    return new EconomyCreature(CreatureStatistic.PIKEMAN, aAmount, 60);
                case 2:
                    return new EconomyCreature(CreatureStatistic.ARCHER, aAmount, 100);
                case 3:
                    return new EconomyCreature(CreatureStatistic.GRIFFIN, aAmount, 200);
                case 4:
                    return new EconomyCreature(CreatureStatistic.SWORDSMAN, aAmount, 300);
                case 5:
                    return new EconomyCreature(CreatureStatistic.MONK, aAmount, 400);
                case 6:
                    return new EconomyCreature(CreatureStatistic.CAVALIER, aAmount, 1000);
                case 7:
                    return new EconomyCreature(CreatureStatistic.ANGEL, aAmount, 3000);
                default:
                    throw new IllegalArgumentException(EXCEPTION_MESSAGE);
            }
        } else {
            switch (aTier) {
                case 1:
                    return new EconomyCreature(CreatureStatistic.HALBERDIER, aAmount, 75);
                case 2:
                    return new EconomyCreature(CreatureStatistic.MARKSMAN, aAmount, 150);
                case 3:
                    return new EconomyCreature(CreatureStatistic.ROYAL_GRIFFIN, aAmount, 240);
                case 4:
                    return new EconomyCreature(CreatureStatistic.CRUSADER, aAmount, 400);
                case 5:
                    return new EconomyCreature(CreatureStatistic.ZEALOT, aAmount, 450);
                case 6:
                    return new EconomyCreature(CreatureStatistic.CHAMPION, aAmount, 1200);
                case 7:
                    return new EconomyCreature(CreatureStatistic.ARCHANGEL, aAmount, 5000);
                default:
                    throw new IllegalArgumentException(EXCEPTION_MESSAGE);
            }
        }
    }
}
