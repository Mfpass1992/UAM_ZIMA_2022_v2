package pl.sdk.creatures;

import com.google.common.collect.Range;

import java.beans.PropertyChangeEvent;

class HealAfterAttackCreatureDecorator extends AbstractCreatureDecorator{

    private double selfHealingPercentage;

    HealAfterAttackCreatureDecorator(Creature aDecorated, double aSelfHealingPercentage) {
        super(aDecorated);
        selfHealingPercentage = aSelfHealingPercentage;
    }

    @Override
    public void attack(Creature aDefender, float modifier) {
        if (getDecorated().isAlive()){
            int damageToDeal = (int) (getDecorated().calculateDamage(this, aDefender) * modifier);
            aDefender.applyDamage(damageToDeal);
            healAfterAttack(damageToDeal);
            getDecorated().counterAttack(aDefender);
        }
    }

    private void healAfterAttack(int aDamageToDeal) {
        applyDamage((int)(-aDamageToDeal * selfHealingPercentage));
    }

}
