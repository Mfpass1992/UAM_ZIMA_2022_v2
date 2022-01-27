package pl.sdk;

import lombok.Getter;
import pl.sdk.creatures.Creature;
import pl.sdk.hero.BattleHeroStatistics;

import java.util.List;

public class Hero {
    @Getter
    private final List<Creature> creatures;
    private BattleHeroStatistics heroStats;

    public Hero(List<Creature> aCreatures) {
        creatures = aCreatures;
    }

    public Hero(List<Creature> aCreatures, BattleHeroStatistics aBattleHeroStatistics) {
        creatures = aCreatures;
        heroStats = aBattleHeroStatistics;
    }

    public BattleHeroStatistics getHeroStats() {
        return heroStats;
    }
}
