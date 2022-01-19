package pl.sdk.hero;

enum HeroStatistic implements HeroStatisticIf{
    CLAVIUS(Fraction.NECROPOLIS,"Clavius", 1,2,2,1,0,0),
    GALTHRAN(Fraction.NECROPOLIS,"Galthran",1,2,2,1,0,0),
    ISRA(Fraction.NECROPOLIS,"Isra",1,2,2,1,0,0),
    AISLINN(Fraction.NECROPOLIS,"Aislinn", 1,0,2,2,0,0),
    NAGASH(Fraction.NECROPOLIS,"Nagash",1,0,2,2,0,0),
    NIMBUS(Fraction.NECROPOLIS,"Nimbus", 1,0,2,2,0,0),
    // CASTLE
    EDRIC(Fraction.CASTLE, "Edric", 2,2,1,1,0,0),
    ORRIN(Fraction.CASTLE, "Orrin", 2,2,1,1,0,0),
    SORSHA(Fraction.CASTLE, "Sorsha", 2,2,1,1,0,0),
    CAITLIN(Fraction.CASTLE, "Caitlin", 1,0,2,2,0,0),
    LOYNIS(Fraction.CASTLE, "Loynis", 1,0,2,2,0,0),
    SANYA(Fraction.CASTLE, "Sanya", 1,0,2,2,0,0),
    // DUNGEON
    AJIT(Fraction.DUNGEON, "Ajit", 2,2,1,1,0,0),
    ARLACH(Fraction.DUNGEON, "Arlach", 2,2,1,1,0,0),
    DACE(Fraction.DUNGEON, "Dace", 2,2,1,1,0,0),
    ALMAR(Fraction.DUNGEON, "Alamar", 0,0,3,2,0,0),
    DARKSTORN(Fraction.DUNGEON, "Darkstorn", 0,0,3,2,0,0),
    DEEMER(Fraction.DUNGEON, "Deemer", 0,0,3,2,0,0);


    private final Fraction heroFraction;
    private final String heroName;
    private final int heroAttack;
    private final int heroDefense;
    private final int spellPower;
    private final int heroKnowledge;
    private final int heroMorale;
    private final int heroLuck;

    HeroStatistic(Fraction heroFraction, String heroName, int heroAttack, int heroDefense, int spellPower, int heroKnowledge, int heroMorale, int heroLuck) {
        this.heroFraction = heroFraction;
        this.heroName = heroName;
        this.heroAttack = heroAttack;
        this.heroDefense = heroDefense;
        this.spellPower = spellPower;
        this.heroKnowledge = heroKnowledge;
        this.heroMorale = heroMorale;
        this.heroLuck = heroLuck;
    }
    public Fraction getHeroFraction(){ return heroFraction; }

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
