package pl.sdk.creatures;

import com.google.common.collect.Range;

    class CreatureStatisticForTesting implements CreatureStatisticIf{

        private final String name;
        private final int attack;
        private final int armor;
        private final int maxHp;
        private final int moveRange;
        private final Range<Integer> damage;
        private final boolean isFlying;

        CreatureStatisticForTesting(String aName, int aAttack, int aArmor, int aMaxHp, int aMoveRange, Range<Integer> aDamage, boolean aIsFlying) {
            name = aName;
            attack = aAttack;
            armor = aArmor;
            maxHp = aMaxHp;
            moveRange = aMoveRange;
            damage = aDamage;
            isFlying = aIsFlying;
        }

        String getName() {
            return name;
        }

        @Override
        public String getTranslatedName() {
            return getName();
        }

        public int getAttack() {
            return attack;
        }

        public int getArmor() {
            return armor;
        }

        public int getMaxHp() {
            return maxHp;
        }

        public int getMoveRange() {
            return moveRange;
        }

        public Range<Integer> getDamage(){
            return damage;
        }

        @Override
        public int getTier() {
            return 0;
        }

        @Override
        public String getDescription() {
            return "Creature for testing";
        }

        @Override
        public boolean isFlying() {
            return isFlying;
        }
    }

