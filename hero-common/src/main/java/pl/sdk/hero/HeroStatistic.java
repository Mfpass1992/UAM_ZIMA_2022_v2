package pl.sdk.hero;

enum HeroStatistic implements HeroStatisticIf{
    // NECROPOLIS
    CLAVIUS("NECROPOLIS","Clavius", 1,2,2,1,0,0),
    GALTHRAN("NECROPOLIS","Galthran",1,2,2,1,0,0),
    ISRA("NECROPOLIS","Isra",1,2,2,1,0,0),
    AISLINN("NECROPOLIS","Aislinn", 1,0,2,2,0,0),
    NAGASH("NECROPOLIS","Nagash",1,0,2,2,0,0),
    NIMBUS("NECROPOLIS","Nimbus", 1,0,2,2,0,0);

    private final String heroFraction;
    private final String heroName;
    private final int heroAttack;

    private final int heroDefense;
    private final int spellPower;
    private final int heroKnowledge;
    private final int heroMorale;
    private final int heroLuck;

    HeroStatistic(String heroFraction, String heroName, int heroAttack, int heroDefense, int spellPower, int heroKnowledge, int heroMorale, int heroLuck) {
        this.heroFraction = heroFraction;
        this.heroName = heroName;
        this.heroAttack = heroAttack;
        this.heroDefense = heroDefense;
        this.spellPower = spellPower;
        this.heroKnowledge = heroKnowledge;
        this.heroMorale = heroMorale;
        this.heroLuck = heroLuck;
    }
    public String getHeroFraction(){ return heroFraction; }

    public String getHeroName(){
        return heroName;
    }

    public int getHeroAttack(){
        return heroAttack;
    }

    public int getHeroDefense() {
        return heroDefense;
    }

    public int getSpellPower() {
        return spellPower;
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
