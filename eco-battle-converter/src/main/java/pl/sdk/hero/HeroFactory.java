package pl.sdk.hero;

import pl.sdk.creatures.CreatureStatisticIf;
import pl.sdk.creatures.CreatureStatisticModifier;

public class HeroFactory {
    CreatureStatisticIf create(EconomyHero aPlayer){
        return new CreatureStatisticModifier.Builder().armor(aPlayer.getHeroDefense()).attack(aPlayer.getHeroAttack()).build();
    }
}
