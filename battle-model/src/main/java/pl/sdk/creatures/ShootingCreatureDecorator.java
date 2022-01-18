package pl.sdk.creatures;

import com.google.common.collect.Range;

import java.beans.PropertyChangeEvent;

class ShootingCreatureDecorator extends AbstractCreatureDecorator {

    ShootingCreatureDecorator(Creature aDecorated){
        super(aDecorated);
    }

    @Override
    public double getAttackRange() {
        return Double.MAX_VALUE;
    }
}
