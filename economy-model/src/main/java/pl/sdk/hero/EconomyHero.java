package pl.sdk.hero;

import pl.sdk.creatures.EconomyCreature;
import pl.sdk.creatures.Fraction;

import java.util.ArrayList;
import java.util.List;

public class EconomyHero {

    private HeroStatistic heroStatistic;

    // private List<EconomyArtifact> artifactsList;
    // private List<Spell> spellList;
    private final List<EconomyCreature> creatureList;
    private int gold;

    public EconomyHero(HeroStatistic aHeroStatistics, int aGold) {
        heroStatistic = aHeroStatistics;
        gold = aGold;
        creatureList = new ArrayList<>();
    }

    void addCreature(EconomyCreature aCreature){
        if (creatureList.size()>=7){
            throw new IllegalStateException("Hero has not empty slot for creature");
        }
        creatureList.add(aCreature);
    }

    public int getGold() {
        return gold;
    }

    public void addGold(int aAmount){
        gold += aAmount;
    }

    public Fraction getFraction() { return heroStatistic.getHeroFraction(); }

    public List<EconomyCreature> getCreatures() {
        return List.copyOf(creatureList);
    }


    void subtractGold(int aAmount){
        if (aAmount > gold){
            throw new IllegalStateException("Hero has not enought money");
        }
        gold -= aAmount;
    }

    public HeroStatistic getHeroStatistic() { return heroStatistic; }

    public String getHeroName(){ return heroStatistic.getHeroName(); }

    public int getHeroAttack(){ return heroStatistic.getHeroAttack(); }

    public int getHeroDefense(){ return heroStatistic.getHeroDefense(); }

    public int getHeroSpellPower(){ return heroStatistic.getSpellPower(); }

    public int getHeroKnowledge() {
        return heroStatistic.getHeroKnowledge();
    }

    public int getHeroMorale() { return heroStatistic.getHeroMorale(); }

    public int getHeroLuck() { return heroStatistic.getHeroLuck(); }
}
