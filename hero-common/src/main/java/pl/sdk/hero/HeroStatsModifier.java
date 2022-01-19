package pl.sdk.hero;

import pl.sdk.creatures.Fraction;

public class HeroStatsModifier implements HeroStatisticIf{
    private Fraction heroFraction;
    private String heroName;
    private final int heroAttack;
    private final int heroDefense;
    private final int spellPower;
    private final int heroKnowledge;
    private final int heroMorale;
    private final int heroLuck;

    public HeroStatsModifier(int aHeroAttack, int aHeroDefense, int aSpellPower, int aHeroKnowledge, int aHeroMorale, int aHeroLuck){
        this.heroAttack = aHeroAttack;
        this.heroDefense = aHeroDefense;
        this.spellPower = aSpellPower;
        this.heroKnowledge = aHeroKnowledge;
        this.heroMorale = aHeroMorale;
        this.heroLuck = aHeroLuck;
    }


    public static class Builder {
        private int heroAttack = 0;
        private int heroDefense = 0;
        private int spellPower = 0;
        private int heroKnowledge = 0;
        private int heroMorale = 0;
        private int heroLuck = 0;

        public Builder heroAttack(int aHeroAttack){
            this.heroAttack = aHeroAttack;
            return this;
        }
        public Builder heroDefense(int aHeroDefense){
            this.heroDefense = aHeroDefense;
            return this;
        }
        public Builder spellPower(int aSpellPower){
            this.spellPower = aSpellPower;
            return this;
        }
        public Builder heroKnowledge(int aHeroKnowledge){
            this.heroKnowledge = aHeroKnowledge;
            return this;
        }
        public Builder heroMorale(int aHeroMorale){
            this.heroMorale = aHeroMorale;
            return this;
        }
        public Builder heroLuck(int aHeroLuck){
            this.heroLuck = aHeroLuck;
            return this;
        }
        public HeroStatsModifier build(){
            return new HeroStatsModifier(this.heroAttack, this.heroDefense, this.spellPower, this.heroKnowledge, this.heroMorale, this.heroLuck);
        }
    }

    public static HeroStatsModifier sumOfStatistics(HeroStatisticIf aStatistic1, HeroStatisticIf aStatistic2){
        return new HeroStatsModifier(
                aStatistic1.getHeroAttack() + aStatistic2.getHeroAttack(),
                aStatistic1.getHeroDefense() + aStatistic2.getHeroDefense(),
                aStatistic1.getSpellPower() + aStatistic2.getSpellPower(),
                aStatistic1.getHeroKnowledge() + aStatistic2.getHeroKnowledge(),
                aStatistic1.getHeroMorale() + aStatistic2.getHeroMorale(),
                aStatistic1.getHeroLuck() + aStatistic2.getHeroLuck()
        );
    }

    public HeroStatisticIf applyStats(HeroStatisticIf aHero){
        HeroStatsModifier out = sumOfStatistics(this, aHero);
        out.heroName = aHero.getHeroName();
        out.heroFraction = aHero.getHeroFraction();

        return out;
    }

    @Override
    public Fraction getHeroFraction() {
        return heroFraction;
    }

    @Override
    public String getHeroName() {
        return heroName;
    }

    @Override
    public int getHeroAttack() {
        return heroAttack;
    }

    @Override
    public int getHeroDefense() {
        return heroDefense;
    }

    @Override
    public int getSpellPower() {
        return spellPower;
    }

    @Override
    public int getHeroKnowledge() {
        return heroKnowledge;
    }

    @Override
    public int getHeroMorale() {
        return heroMorale;
    }

    @Override
    public int getHeroLuck() {
        return heroLuck;
    }
}
