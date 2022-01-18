package pl.sdk.creatures;

import com.google.common.collect.Range;

public class CreatureStatisticModifier implements CreatureStatisticIf {
    private String translatedName;
    private final int attack;
    private final int armor;
    private final int maxHp;
    private final int moveRange;
    private final Range<Integer> damage;
    private int tier;
    private String description;

    private CreatureStatisticModifier(int aAttack, int aArmor, int aMaxHp, int aMoveRange, Range<Integer> aDamage) {
        attack = aAttack;
        armor = aArmor;
        maxHp = aMaxHp;
        moveRange = aMoveRange;
        damage = aDamage;
    }

    public static class Builder {
        private int attack = 0;
        private int armor = 0;
        private int maxHp = 0;
        private int moveRange = 0;
        private Range<Integer> damage = Range.closed(0, 0);

        public Builder attack(int aAttack) {
            this.attack = aAttack;
            return this;
        }
        public Builder armor(int aArmor) {
            this.armor = aArmor;
            return this;
        }
        public Builder maxHp(int maxHp) {
            this.maxHp = maxHp;
            return this;
        }
        public Builder moveRange(int aMoveRange) {
            this.moveRange = aMoveRange;
            return this;
        }
        public Builder damage(Range<Integer> aDamage) {
            this.damage = aDamage;
            return this;
        }

        public CreatureStatisticModifier build() {
            return new CreatureStatisticModifier(this.attack, this.armor, this.maxHp, this.moveRange, this.damage);
        }
    }

    public static CreatureStatisticModifier sumOfStatistics(CreatureStatisticIf aStatistic1, CreatureStatisticIf aStatistic2) {
        return new CreatureStatisticModifier(
                aStatistic1.getAttack() + aStatistic2.getAttack(),
                aStatistic1.getArmor() + aStatistic2.getArmor(),
                aStatistic1.getMaxHp() + aStatistic2.getMaxHp(),
                aStatistic1.getMoveRange() + aStatistic2.getMoveRange(),
                Range.closed(
                        aStatistic1.getDamage().lowerEndpoint() + aStatistic2.getDamage().lowerEndpoint(),
                        aStatistic1.getDamage().upperEndpoint() + aStatistic2.getDamage().upperEndpoint()
                        )
            );
    }

    public CreatureStatisticIf apply(CreatureStatisticIf aCreatureStats) {
        CreatureStatisticModifier ret = sumOfStatistics(this, aCreatureStats);
        ret.translatedName = aCreatureStats.getTranslatedName();
        ret.description = aCreatureStats.getDescription();
        ret.tier = aCreatureStats.getTier();

        return ret;
    }

    @Override
    public String getTranslatedName() {
        if (translatedName == null) throw new UnsupportedOperationException();
        return translatedName;
    }

    @Override
    public int getAttack() {
        return attack;
    }

    @Override
    public int getArmor() {
        return armor;
    }

    @Override
    public int getMaxHp() {
        return maxHp;
    }

    @Override
    public int getMoveRange() {
        return moveRange;
    }

    @Override
    public Range<Integer> getDamage() {
        return damage;
    }

    @Override
    public int getTier() {
        if (tier == 0) throw new UnsupportedOperationException();
        return tier;
    }

    @Override
    public String getDescription() {
        if (description == null) throw new UnsupportedOperationException();
        return description;
    }
}
