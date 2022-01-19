package pl.sdk.hero;

import pl.sdk.creatures.CreatureStatisticIf;
import static pl.sdk.hero.HeroStatsModifier.sumOfStatistics;

public class EconomyHeroFactory {
    private static final String MESSAGE = "No hero with given name";
    private HeroStatsModifier statisticModifier;

    public EconomyHeroFactory(){
        statisticModifier = new HeroStatsModifier.Builder().build();
    }

    public void addModifier(HeroStatsModifier aModifier) {
        statisticModifier = sumOfStatistics(statisticModifier, aModifier);
    }

    public EconomyHero create(String name, int gold){
        if(HeroStatistic.CLAVIUS.getHeroName().equals(name)){
            return new EconomyHero(statisticModifier.applyStats(HeroStatistic.CLAVIUS), gold);
        }
        else if (HeroStatistic.GALTHRAN.getHeroName().equals(name)){
            return new EconomyHero(statisticModifier.applyStats(HeroStatistic.GALTHRAN), gold);
        }
        else if (HeroStatistic.ISRA.getHeroName().equals(name)){
            return new EconomyHero(statisticModifier.applyStats(HeroStatistic.ISRA), gold);
        }
        else if (HeroStatistic.AISLINN.getHeroName().equals(name)){
            return new EconomyHero(statisticModifier.applyStats(HeroStatistic.AISLINN), gold);
        }
        else if (HeroStatistic.NAGASH.getHeroName().equals(name)){
            return new EconomyHero(statisticModifier.applyStats(HeroStatistic.NAGASH), gold);
        }
        else if (HeroStatistic.NIMBUS.getHeroName().equals(name)){
            return new EconomyHero(statisticModifier.applyStats(HeroStatistic.NIMBUS), gold);
        }
        else if (HeroStatistic.EDRIC.getHeroName().equals(name)){
            return new EconomyHero(statisticModifier.applyStats(HeroStatistic.EDRIC), gold);
        }

        else if (HeroStatistic.ORRIN.getHeroName().equals(name)){
            return new EconomyHero(statisticModifier.applyStats(HeroStatistic.ORRIN), gold);
        }

        else if (HeroStatistic.SORSHA.getHeroName().equals(name)){
            return new EconomyHero(statisticModifier.applyStats(HeroStatistic.SORSHA), gold);
        }

        else if (HeroStatistic.CAITLIN.getHeroName().equals(name)){
            return new EconomyHero(statisticModifier.applyStats(HeroStatistic.CAITLIN), gold);
        }

        else if (HeroStatistic.LOYNIS.getHeroName().equals(name)){
            return new EconomyHero(statisticModifier.applyStats(HeroStatistic.LOYNIS), gold);
        }

        else if (HeroStatistic.SANYA.getHeroName().equals(name)){
            return new EconomyHero(statisticModifier.applyStats(HeroStatistic.SANYA), gold);
        }

        else if (HeroStatistic.AJIT.getHeroName().equals(name)){
            return new EconomyHero(statisticModifier.applyStats(HeroStatistic.AJIT), gold);
        }

        else if (HeroStatistic.ARLACH.getHeroName().equals(name)){
            return new EconomyHero(statisticModifier.applyStats(HeroStatistic.ARLACH), gold);
        }

        else if (HeroStatistic.DACE.getHeroName().equals(name)){
            return new EconomyHero(statisticModifier.applyStats(HeroStatistic.DACE), gold);
        }

        else if (HeroStatistic.ALMAR.getHeroName().equals(name)){
            return new EconomyHero(statisticModifier.applyStats(HeroStatistic.ALMAR), gold);
        }
        else if (HeroStatistic.DARKSTORN.getHeroName().equals(name)){
            return new EconomyHero(statisticModifier.applyStats(HeroStatistic.DARKSTORN), gold);
        }
        else if (HeroStatistic.DEEMER.getHeroName().equals(name)){
            return new EconomyHero(statisticModifier.applyStats(HeroStatistic.DEEMER), gold);
        }
        else{
            throw new IllegalArgumentException(MESSAGE);
        }
    }
}
