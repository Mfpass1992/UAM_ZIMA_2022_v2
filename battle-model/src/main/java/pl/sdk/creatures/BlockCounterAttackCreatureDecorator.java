package pl.sdk.creatures;

import com.google.common.collect.Range;

import java.beans.PropertyChangeEvent;

class BlockCounterAttackCreatureDecorator extends AbstractCreatureDecorator{


    public BlockCounterAttackCreatureDecorator(Creature aDecorated){
        super(aDecorated);
    }

    @Override
    public void attack(Creature aDefender, float modifier) {
        if (getDecorated().isAlive()){
            int damageToDeal = (int) (getDecorated().calculateDamage(this,aDefender) * modifier);
            System.out.println(damageToDeal);
            aDefender.applyDamage(damageToDeal);
        }
    }

}
