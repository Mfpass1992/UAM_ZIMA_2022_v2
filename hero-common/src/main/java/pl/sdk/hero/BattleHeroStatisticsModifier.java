package pl.sdk.hero;

public class BattleHeroStatisticsModifier {
    private final int heroAttack;
    private final int heroDefense;
    private final int heroSpellPower;
    private final int heroKnowledge;
    private final int heroMorale;
    private final int heroLuck;

    public BattleHeroStatisticsModifier(int heroAttack, int heroDefense, int spellPower, int heroKnowledge, int heroMorale, int heroLuck) {
        this.heroAttack = heroAttack;
        this.heroDefense = heroDefense;
        this.heroSpellPower = spellPower;
        this.heroKnowledge = heroKnowledge;
        this.heroMorale = heroMorale;
        this.heroLuck = heroLuck;
    }

    public static class Builder{
        private int heroAttack = 0;
        private int heroDefense = 0;
        private int heroSpellPower = 0;
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
        public Builder heroSpellPower(int aHeroSpellPower){
            this.heroSpellPower = aHeroSpellPower;
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
        public BattleHeroStatisticsModifier build(){
            return new BattleHeroStatisticsModifier(this.heroAttack, this.heroDefense, this.heroSpellPower, this.heroKnowledge, this.heroMorale,this.heroLuck);
        }
    }

    public int getHeroAttack() {
        return heroAttack;
    }

    public int getHeroDefense() {
        return heroDefense;
    }

    public int getHeroSpellPower() {
        return heroSpellPower;
    }

    public int getHeroKnowledge() {
        return heroKnowledge;
    }

    public int getHeroMorale() {
        return heroMorale;
    }

    public int getHeroLuck() {
        return heroLuck;
    }

}
