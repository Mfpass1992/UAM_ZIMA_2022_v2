package pl.sdk.fields;

import pl.sdk.creatures.Creature;

abstract class EffectField extends SpecialField {

    protected EffectField(SpecialFieldType type, int turns) {
        super(type, turns);
    }

    @Override
    public abstract void triggerEffect(Creature creature);
}
