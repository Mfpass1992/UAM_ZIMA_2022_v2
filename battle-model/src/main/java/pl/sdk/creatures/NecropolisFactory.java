package pl.sdk.creatures;

import static pl.sdk.creatures.CreatureStatisticModifier.sumOfStatistics;

public class NecropolisFactory {

    private static final String EXCEPTION_MESSAGE = "We support tiers from 1 to 7";
    private CreatureStatisticModifier statisticModifier;

    public NecropolisFactory() {
        statisticModifier = new CreatureStatisticModifier.Builder().build();
    }

    public void addModifier(CreatureStatisticIf aModifier) {
        statisticModifier = sumOfStatistics(statisticModifier, aModifier);
    }

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
                            .statistic(statisticModifier.apply(CreatureStatistic.SKELETON))
                            .amount(aAmount)
                            .build();
                case 2:
                    return new Creature.Builder()
                            .statistic(statisticModifier.apply(CreatureStatistic.WALKING_DEAD))
                            .amount(aAmount)
                            .build();
                case 3:
                    return new Creature.Builder()
                            .statistic(statisticModifier.apply(CreatureStatistic.WIGHT))
                            .amount(aAmount)
                            .build();
                case 4:
                    return new Creature.Builder()
                            .statistic(statisticModifier.apply(CreatureStatistic.VAMPIRE))
                            .amount(aAmount)
                            .build();
                case 5:
                    Creature lich = new Creature.Builder()
                            .statistic(statisticModifier.apply(CreatureStatistic.LICH))
                            .amount(aAmount)
                            .build();
                    return new BlockCounterAttackCreatureDecorator(new ShootingCreatureDecorator(new SplashDamageCreatureDecorator(lich, getSplashForLich())));
                case 6:
                    return new Creature.Builder()
                            .statistic(statisticModifier.apply(CreatureStatistic.BLACK_KNIGHT))
                            .amount(aAmount)
                            .build();
                case 7:
                    return new Creature.Builder()
                            .statistic(statisticModifier.apply(CreatureStatistic.BONE_DRAGON))
                            .amount(aAmount)
                            .build();
                default:
                    throw new IllegalArgumentException(EXCEPTION_MESSAGE);
            }
        } else {
            switch (aTier) {
                case 1:
                    return new Creature.Builder()
                            .statistic(statisticModifier.apply(CreatureStatistic.SKELETON_WARRIOR))
                            .amount(aAmount)
                            .build();
                case 2:
                    return new Creature.Builder()
                            .statistic(statisticModifier.apply(CreatureStatistic.ZOMBIE))
                            .amount(aAmount)
                            .build();
                case 3:
                    return new RegenerationOnEndOfTurnCreatureDecorator(new Creature.Builder()
                            .statistic(statisticModifier.apply(CreatureStatistic.WRAITH))
                            .amount(aAmount)
                            .build());
                case 4:
                    return new Creature.Builder()
                            .statistic(statisticModifier.apply(CreatureStatistic.VAMPIRE_LORD))
                            .amount(aAmount)
                            .build();
                case 5:
                    Creature c = new Creature.Builder()
                            .statistic(statisticModifier.apply(CreatureStatistic.POWER_LICH))
                            .amount(aAmount)
                            .build();
                    boolean[][] splashDamageTable = getSplashForLich();
                    return new SplashDamageCreatureDecorator(new BlockCounterAttackCreatureDecorator(new ShootingCreatureDecorator(c)), splashDamageTable);
                case 6:
                    return new Creature.Builder()
                            .statistic(statisticModifier.apply(CreatureStatistic.DREAD_KNIGHT))
                            .amount(aAmount)
                            .build();
                case 7:
                    return new Creature.Builder()
                            .statistic(statisticModifier.apply(CreatureStatistic.GHOST_DRAGON))
                            .amount(aAmount)
                            .build();
                default:
                    throw new IllegalArgumentException(EXCEPTION_MESSAGE);
            }
        }
    }

    private boolean[][] getSplashForLich() {
        boolean[][] splashDamageTable = new boolean[3][3];
        splashDamageTable[0][1] = true;
        splashDamageTable[2][1] = true;
        splashDamageTable[1][1] = true;
        splashDamageTable[1][2] = true;
        splashDamageTable[1][0] = true;
        return splashDamageTable;
    }
}
