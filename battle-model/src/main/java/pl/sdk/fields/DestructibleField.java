package pl.sdk.fields;

import pl.sdk.creatures.Creature;
import pl.sdk.creatures.NecropolisFactory;

public class DestructibleField extends SpecialField {

    private final Creature creature;

    public DestructibleField(int turns, int hp) {
        super(SpecialFieldType.DESTRUCTIBLE_FIELD, turns);
        creature = NecropolisFactory.createForDestructibleField(hp);
    }

    public void applyDamage(Creature attacker) {
        attacker.attack(creature);
        if(!creature.isAlive()) {
            notifyObservers();
        }
    }

    public int getHp() {
        return creature.getCurrentHp();
    }

}
