package pl.sdk.hero;

import pl.sdk.creatures.Fraction;

public interface HeroStatisticIf {
    Fraction getHeroFraction();
    String getHeroName();
    int getHeroAttack();
    int getHeroDefense();
    int getSpellPower();
    int getHeroKnowledge();
    int getHeroMorale();
    int getHeroLuck();
}
