package pl.sdk.creatures;

import com.google.common.collect.Range;

import java.beans.PropertyChangeEvent;

class BlockCounterAttackCreatureDecorator extends AbstractCreatureDecorator{


    public BlockCounterAttackCreatureDecorator(Creature aDecorated){
        super(aDecorated);
    }

    @Override
    public void attack(Creature aDefender) {
        if (getDecorated().isAlive()){
            int damageToDeal = getDecorated().calculateDamage(this,aDefender);
            aDefender.applyDamage(damageToDeal);
        }
    }

}
