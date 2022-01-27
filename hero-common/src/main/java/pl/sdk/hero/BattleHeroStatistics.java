package pl.sdk.hero;

import lombok.Getter;

public class BattleHeroStatistics {
    @Getter
    private int heroAttack;
    @Getter
    private int heroDefense;
    @Getter
    private int heroSpellPower;
    @Getter
    private int heroKnowledge;
    @Getter
    private int heroMorale;
    @Getter
    private int heroLuck;

    public BattleHeroStatistics(HeroStatistic aHeroStatistics) {
        this.heroAttack = aHeroStatistics.getHeroAttack();
        this.heroDefense = aHeroStatistics.getHeroDefense();
        this.heroSpellPower = aHeroStatistics.getSpellPower();
        this.heroKnowledge = aHeroStatistics.getHeroKnowledge();
        this.heroMorale = aHeroStatistics.getHeroMorale();
        this.heroLuck = aHeroStatistics.getHeroLuck();
    }

    void increaseStatistics(BattleHeroStatisticsModifier aModifier){
        this.heroAttack += aModifier.getHeroAttack();
        this.heroDefense += aModifier.getHeroDefense();
        this.heroSpellPower += aModifier.getHeroSpellPower();
        this.heroKnowledge += aModifier.getHeroKnowledge();
        this.heroMorale += aModifier.getHeroMorale();
        this.heroLuck += aModifier.getHeroLuck();
    }
}
