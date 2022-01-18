package pl.sdk.hero;

public class EconomyHeroFactory {
    private static final String MESSAGE = "No hero with given name";

    public EconomyHero create(String name, int gold){
        if(HeroStatistic.CLAVIUS.getHeroName().equals(name)){
            return new EconomyHero(HeroStatistic.CLAVIUS, gold);
        }
        else if (HeroStatistic.GALTHRAN.getHeroName().equals(name)){
            return new EconomyHero(HeroStatistic.GALTHRAN, gold);
        }
        else if (HeroStatistic.ISRA.getHeroName().equals(name)){
            return new EconomyHero(HeroStatistic.ISRA, gold);
        }
        else if (HeroStatistic.AISLINN.getHeroName().equals(name)){
            return new EconomyHero(HeroStatistic.AISLINN, gold);
        }
        else if (HeroStatistic.NAGASH.getHeroName().equals(name)){
            return new EconomyHero(HeroStatistic.NAGASH, gold);
        }
        else if (HeroStatistic.NIMBUS.getHeroName().equals(name)){
            return new EconomyHero(HeroStatistic.NIMBUS, gold);
        }
        else{
            throw new IllegalArgumentException(MESSAGE);
        }
    }
}
