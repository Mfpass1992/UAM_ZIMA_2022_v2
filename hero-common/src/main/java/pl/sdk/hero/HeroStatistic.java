package pl.sdk.hero;

import pl.sdk.creatures.Fraction;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum HeroStatistic implements HeroStatisticIf{
    // NECROPOLIS
    CLAVIUS(Fraction.NECROPOLIS,"Clavius", 1,2,2,1,0,0),
    GALTHRAN(Fraction.NECROPOLIS,"Galthran",1,2,2,1,0,0),
    ISRA(Fraction.NECROPOLIS,"Isra",1,2,2,1,0,0),
    AISLINN(Fraction.NECROPOLIS,"Aislinn", 1,0,2,2,0,0),
    NAGASH(Fraction.NECROPOLIS,"Nagash",1,0,2,2,0,0),
    NIMBUS(Fraction.NECROPOLIS,"Nimbus", 1,0,2,2,0,0),
    CASTLE_MOCK(Fraction.CASTLE,"Nimbus", 1,0,2,2,0,0);

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

    public static List<HeroStatistic> getHeroesByFraction(Fraction aFraction){
        return Stream.of(values()).filter(stats -> stats.heroFraction.equals(aFraction.getFraction()) ).collect(Collectors.toList());
    }
}
