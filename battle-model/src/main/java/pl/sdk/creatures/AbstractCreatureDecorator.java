package pl.sdk.creatures;

import com.google.common.collect.Range;

import java.beans.PropertyChangeEvent;

public class AbstractCreatureDecorator extends Creature{

    private final Creature decorated;

    public Creature getDecorated() {
        return decorated;
    }

    public AbstractCreatureDecorator(Creature aDecorated){
        decorated = aDecorated;
    }

    @Override
    protected void setCurrentHpToMaximum() {
        decorated.setCurrentHpToMaximum();
    }

    @Override
    public void attack(Creature aDefender, float modifier) {
        decorated.attack(aDefender, modifier);
    }

    @Override
    protected void counterAttack(Creature aDefender) {
        decorated.counterAttack(aDefender);
    }

    @Override
    public void applyDamage(int aDamageToApply) {
        decorated.applyDamage(aDamageToApply);
    }

    @Override
    int calculateDamage(Creature aAttacker, Creature aDefender) {
        return decorated.calculateDamage(aAttacker, aDefender);
    }

    @Override
    public boolean isAlive() {
        return decorated.isAlive();
    }

    @Override
    public boolean[][] getSplashRange() {
        return decorated.getSplashRange();
    }

    @Override
    public int getCurrentHp() {
        return decorated.getCurrentHp();
    }

    @Override
    public String getName() {
        return decorated.getName();
    }

    @Override
    public boolean canCounterAttack() {
        return decorated.canCounterAttack();
    }

    @Override
    public int getMoveRange() {
        return decorated.getMoveRange();
    }

    @Override
    public void propertyChange(PropertyChangeEvent aPropertyChangeEvent) {
        decorated.propertyChange(aPropertyChangeEvent);
    }

    @Override
    public int getAttack() {
        return decorated.getAttack();
    }

    @Override
    public int getArmor() {
        return decorated.getArmor();
    }

    @Override
    public Range<Integer> getDamage() {
        return decorated.getDamage();
    }

    @Override
    public int getAmount() {
        return decorated.getAmount();
    }

    @Override
    public String currentHealth() {
        return decorated.currentHealth();
    }

    @Override
    public String toString() {
        return decorated.toString();
    }

    @Override
    public double getAttackRange() {
        return decorated.getAttackRange();
    }
}

