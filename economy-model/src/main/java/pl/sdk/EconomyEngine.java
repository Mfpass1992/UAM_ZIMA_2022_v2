package pl.sdk;

import pl.sdk.creatures.EconomyCreature;
import pl.sdk.hero.CreatureShop;
import pl.sdk.hero.EconomyHero;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class EconomyEngine
{
    public static final String ACTIVE_HERO_CHANGED = "ACTIVE_HERO_CHANGED";
    public static final String ECONOMY_FINISHED = "ECONOMY_FINISHED";
    public static final String MONEY_TRANSFER = "MONEY_TRANSFER";
    public static final String CREATURE_BOUGHT_OR_SOLD = "CREATURE_BOUGHT_OR_SOLD";
    public static final String ARTIFACT_BOUGHT_OR_SOLD = "ARTIFACT_BOUGHT_OR_SOLD";
    public static final String SPELL_BOUGHT_OR_SOLD = "SPELL_BOUGHT_OR_SOLD";
    public static final String ABILITY_BOUGHT_OR_SOLD = "ABILITY_BOUGHT_OR_SOLD";

    private final EconomyHero hero1;
    private final EconomyHero hero2;
    private EconomyHero activeHero;
    private final CreatureShop creatureShop = new CreatureShop();
    private final PropertyChangeSupport observerSupport;

    public EconomyEngine(
        EconomyHero aHero1,
        EconomyHero aHero2
        )
    {
        hero1 = aHero1;
        hero2 = aHero2;
        activeHero = hero1;
        observerSupport = new PropertyChangeSupport(this);
    }

    public void buy( EconomyCreature aEconomyCreature )
    {
        creatureShop.buy(activeHero,aEconomyCreature);
        observerSupport.firePropertyChange( MONEY_TRANSFER, null, null );
        observerSupport.firePropertyChange( CREATURE_BOUGHT_OR_SOLD, null, null );
    }

    public EconomyHero getActiveHero() {
        return activeHero;
    }

    public void pass()
    {
        if( activeHero == hero1 ) {
            activeHero = hero2;
            observerSupport.firePropertyChange( ACTIVE_HERO_CHANGED, hero1, activeHero );
            }
        else {
            activeHero = hero1;
            observerSupport.firePropertyChange( ACTIVE_HERO_CHANGED, hero2, activeHero );
            observerSupport.firePropertyChange( ECONOMY_FINISHED, null, null );
            }
    }

    public void addObserver(String aPropertyName, PropertyChangeListener aObserver) {
        observerSupport.addPropertyChangeListener(aPropertyName, aObserver);
    }

    public EconomyHero getPlayer1() {
        //TODO make copy
        return hero1;
    }

    public EconomyHero getPlayer2() {
        //TODO make copy
        return hero2;
    }
}
