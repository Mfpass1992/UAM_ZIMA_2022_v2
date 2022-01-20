package pl.sdk.fields;

import pl.sdk.MoveType;
import pl.sdk.creatures.Creature;

class DamageField extends EffectField {

    private final int damageToDeal;
    private final MoveType moveType;

    DamageField(int damageToDeal, int turns, MoveType moveType) {
        super(SpecialFieldType.DAMAGE_FIELD, turns);
        this.damageToDeal = damageToDeal;
        this.moveType = moveType;
    }

    @Override
    public void triggerEffect(Creature creature) {
        //if(creature.moveType == moveType)
        creature.applyDamage(damageToDeal);
    }
}
