package pl.sdk.creatures;

public class DoubleAttackCreatureDecorator extends AbstractCreatureDecorator {

    public DoubleAttackCreatureDecorator(Creature aDecorated) {
        super(aDecorated);
    }

    @Override
    public void attack(Creature aDefender, float modifier) {
        if (isAlive()){
            int damageToDeal = calculateDamage(this, aDefender);
            damageToDeal += calculateDamage(this, aDefender);
            aDefender.applyDamage((int) (damageToDeal * modifier));
            counterAttack(aDefender);
        }
    }
}
