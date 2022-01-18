package pl.sdk.creatures;

import com.google.common.collect.Range;

import java.beans.PropertyChangeEvent;

class RegenerationOnEndOfTurnCreatureDecorator extends AbstractCreatureDecorator{

    RegenerationOnEndOfTurnCreatureDecorator(Creature aDecorated) {
        super(aDecorated);
    }

    @Override
    public void propertyChange(PropertyChangeEvent aPropertyChangeEvent) {
        getDecorated().propertyChange(aPropertyChangeEvent);
        getDecorated().setCurrentHpToMaximum();
    }

}
