package pl.sdk.creatures;


public class CastleFactory implements AbstractCreatureFactory{

    private static final String EXCEPTION_MESSAGE = "We support tiers from 1 to 7";

    public static Creature createDefaultForTests() {
        return new Creature.Builder()
                .statistic(CreatureStatistic.TEST)
                .build();
    }

    public Creature create(boolean aIsUpgraded, int aTier, int aAmount) {
        if (!aIsUpgraded) {
            switch (aTier) {
                case 1:
                    return new Creature.Builder()
                            .statistic(CreatureStatistic.PIKEMAN)
                            .amount(aAmount)
                            .build();
                case 2:
                    Creature archer = new Creature.Builder()
                            .statistic(CreatureStatistic.ARCHER)
                            .amount(aAmount)
                            .build();
                    return new BlockCounterAttackCreatureDecorator(new ShootingCreatureDecorator(archer));
                case 3:
                    return new Creature.Builder()
                            .statistic(CreatureStatistic.GRIFFIN)
                            .amount(aAmount)
                            .build();
                case 4:
                    return new Creature.Builder()
                            .statistic(CreatureStatistic.SWORDSMAN)
                            .amount(aAmount)
                            .build();
                case 5:
                    Creature monk = new Creature.Builder()
                            .statistic(CreatureStatistic.MONK)
                            .amount(aAmount)
                            .build();
                    return new BlockCounterAttackCreatureDecorator(new ShootingCreatureDecorator(monk));
                case 6:
                    return new Creature.Builder()
                            .statistic(CreatureStatistic.CAVALIER)
                            .amount(aAmount)
                            .build();
                case 7:
                    return new Creature.Builder()
                            .statistic(CreatureStatistic.ANGEL)
                            .amount(aAmount)
                            .build();
                default:
                    throw new IllegalArgumentException(EXCEPTION_MESSAGE);
            }
        } else {
            switch (aTier) {
                case 1:
                    return new Creature.Builder()
                            .statistic(CreatureStatistic.HALBERDIER)
                            .amount(aAmount)
                            .build();
                case 2:
                    Creature marksman = new Creature.Builder()
                            .statistic(CreatureStatistic.MARKSMAN)
                            .amount(aAmount)
                            .build();
                    return new BlockCounterAttackCreatureDecorator(new ShootingCreatureDecorator(marksman));
                case 3:
                    return new Creature.Builder()
                            .statistic(CreatureStatistic.ROYAL_GRIFFIN)
                            .amount(aAmount)
                            .build();
                case 4:
                    return new Creature.Builder()
                            .statistic(CreatureStatistic.CRUSADER)
                            .amount(aAmount)
                            .build();
                case 5:
                    Creature zealot = new Creature.Builder()
                            .statistic(CreatureStatistic.ZEALOT)
                            .amount(aAmount)
                            .build();
                    return new BlockCounterAttackCreatureDecorator(new ShootingCreatureDecorator(zealot));
                case 6:
                    return new Creature.Builder()
                            .statistic(CreatureStatistic.CHAMPION)
                            .amount(aAmount)
                            .build();
                case 7:
                    return new Creature.Builder()
                            .statistic(CreatureStatistic.ARCHANGEL)
                            .amount(aAmount)
                            .build();
                default:
                    throw new IllegalArgumentException(EXCEPTION_MESSAGE);
            }
        }
    }
}
