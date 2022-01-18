package pl.sdk.creatures;

public interface AbstractCreatureFactory {

    Creature create(boolean aIsUpgraded, int aTier, int aAmount);

}
