package pl.sdk.creatures;

import com.google.common.collect.Range;

enum CreatureStatistic implements CreatureStatisticIf{

    // TEST CREATURES
    TEST("name",2,1,10,1,Range.closed(2,2),0,"for unit testing",false, false),
    TEST2("name",2,1,10,5,Range.closed(2,2),0,"for unit testing",false, false),

    // NECROPILIS FRACTION
    SKELETON("Skeleton",5,4,6,4,Range.closed(1,3),1,"Average lvl1 foot soldier, but always in huge numbers thanks to necromancy skill and skeleton transformer.",false, false),
    WALKING_DEAD("Walking Dead",5,5,15,3,Range.closed(2,3),2,"Basically its the same skeleton with more hit points. I prefer buying 2 skeletons instead.",false, false),
    WIGHT("Wight",7,7,18,5,Range.closed(3,5),3,"Regenerating ability is really good when fighting weak enemies, especially shooters.\nSpecial: top wight of the stack regenerates all lost damage in the beginning of each round",false, true),
    VAMPIRE("Vampire",10,9,30,6,Range.closed(5,8),4,"NOTHING compared to their upgraded brothers. Keep the population growing and recruit after the upgrade.\nSpecial: no enemy retaliation.",false, true),
    LICH("Lich",13,10,30,6,Range.closed(11,15),5,"Now they last longer and are able to do more damage! A must for good necropolis army.\nSpecial: death cloud range attack - damages living creatures on adjacent hexes to target.\n",false, false),
    BLACK_KNIGHT("Black Knight",16,16,120,7,Range.closed(15,30),6,"Awesome ground unit. As any undead it cannot be blinded, so your enemies will have to look out.\nSpecial: 20% chance to curse enemy.\n",false, false),
    BONE_DRAGON("Bone Dragon",17,15,150,9,Range.closed(25,50),7,"They are truly fearsome for enemies with low morale. Simply keeping them on battlefield scares enemies.\nSpecial: -1 to enemy morale.\n",false, true),
    SKELETON_WARRIOR("Skeleton Warrior",6,6,6,5,Range.closed(1,3),1,"Numerous skeletons become even better, but running back to town and upgrading is a problem... If there is no room in your army for ordinary skeletons, necromancy skill will resurrect skeleton warriors, but there will be less of them than normal skeletons, so it might be a good idea not to upgrade cursed temple at all.",true, false),
    ZOMBIE("Zombie",5,5,20,4,Range.closed(2,3),2,"Attack ratings are way too low... In my opinion, necropolis has the worst lvl2 creature.\nSpecial: 20% chance to disease enemies (-2Att -2Def for 3 rounds)\n",true, false),
    WRAITH("Wraith",7,7,18,5,Range.closed(3,5),3,"Regenerating ability is really good when fighting weak enemies, especially shooters.\nSpecial: top wight of the stack regenerates all lost damage in the beginning of each round\n",true, true),
    VAMPIRE_LORD("Vampire Lord",10,10,40,9,Range.closed(5,8),4,"My favorite necropolis unit. Use them as main striking unit and you might end up with no losses!\nSpecial: no enemy retaliation ; resurrects members of their own stack by restoring health equal to the amount of damage they do to living enemies.\n",true, true),
    POWER_LICH("Power Lich",13,10,40,7,Range.closed(11,15),5,"Now they last longer and are able to do more damage! A must for good necropolis army.\nSpecial: death cloud range attack - damages living creatures on adjacent hexes to target.\n",true, false),
    DREAD_KNIGHT("Dread Knight",18,18,120,9,Range.closed(15,30),6,"I think it's the best lvl6 unit in the game! Double damage ability puts Dread Knights above Naga Queens.\nSpecial: 20% chance to curse enemy ; 20% chance to do double damage.\n",true, false),
    GHOST_DRAGON("Ghost Dragon",19,17,200,14,Range.closed(25,50),7,"When situation seems hopeless, take a chance on the best enemy stack! If you'll get lucky, half their hit points will be gone instantly!! Ageing ability makes ghost dragons as dangerous as other lvl7 creatures.\nSpecial: -1 to enemy morale ; 20% chance to age enemy (halve hit points of all stack members).\n",true, true),

    // CASTLE FRACTION
    PIKEMAN("Pikeman", 4, 5, 10, 4, Range.closed(1, 3), 1, "Toughest lvl1 unit, but a bit slow.", false, false),
    ARCHER("Archer", 6, 3, 10, 4, Range.closed(2, 3), 2, "Archer's upgrade is literally 2 times better. Upgrade them quickly.", false, false),
    GRIFFIN("Griffin", 8, 8, 25, 6, Range.closed(3, 6), 3, "High in population, griffins become castle's main unit for the midgame.\nSpecial: can retaliate against 2 attacks per turn.", false, true),
    SWORDSMAN("Swordsman", 10, 12, 35, 5, Range.closed(6, 9), 4, "Not too good unit the upgrade and also too slow.", false, false),
    MONK("Monk", 12, 7, 30, 5, Range.closed(10, 12), 5, "Good shooter, nice damage.", false, false),
    CAVALIER("Cavalier", 15, 15, 100, 7, Range.closed(15, 25), 6, "Make sure that the path is as long as possible - they need some speed!\nSpecial: +5% damage for each hex traveled to creature attacked.", false, false),
    ANGEL("Angel", 20, 20, 200, 9, Range.closed(50, 50), 7, "Nice combat ratings and great constant damage - no need to bless them. Note that before the update patches Angels and Archangels didn't cost any gems, just gold. This has been added to try to balance the castle a little. I think it's still too powerful.\nSpecial: 150% damage to devils", false, true),
    HALBERDIER("Halberdier", 6, 5, 10, 5, Range.closed(2, 3), 1, "Now they are faster and do more damage. Will make a good defence for shooters.", true, false),
    MARKSMAN("Marksman", 6, 3, 10, 6, Range.closed(2, 3), 2, "Awesome upgrade, but they still lack defence...\nSpecial: Fires 2 shots per ranged attack.", true, false),
    ROYAL_GRIFFIN("Royal Griffin", 9, 9, 25, 9, Range.closed(3, 6), 3, "Send them right in the middle of the battlefield. Everyone who comes will get some ;)\nSpecial: unlimited retaliations.", true, true),
    CRUSADER("Crusader", 12, 12, 35, 6, Range.closed(7, 10), 4, "Good upgrade, but still lacks speed. Seem undefeatable in large numbers.\nSpecial: attacks twice.", true, false),
    ZEALOT("Zealot", 12, 10, 30, 7, Range.closed(10, 12), 5, "Zealots are skilled enough to use the same magic powers at very close range. Better defence too.\nSpecial: no penalty for hand-to-hand attacks.", true, false),
    CHAMPION("Champion", 16, 16, 100, 9, Range.closed(20, 25), 6, "That's up to 45% extra damage possible! Champions also have better aiming skills.\nSpecial: +5% damage for each hex traveled to creature attacked.", true, false),
    ARCHANGEL("Archangel", 30, 30, 250, 18, Range.closed(50, 50), 7, "Best attack, defence and speed in a whole game! Resurrection is a very convenient abbility. Those fast wings take up a whole extra hex! :] Possibly the best creature in the game.\nSpecial: 150% damage to devils ; Resurrect dead allied troops once per combat.", true, true),

    // DUNGEON Fraction
    TROGLODYTE("Troglodyte", 4, 3, 5, 4, Range.closed(1,3), 1, "Average level 1 creature. Strongly affected by bless and curse.\nSpecial: immune to blind spell.", false, false),
    HARPY("Harpy", 6, 5, 14, 6, Range.closed(1,4),2 ,"Quite a weak creature with huge damage range (bless and curse do well), but the abbility is very unique, not very useful before the upgrade though. Once enemy stack has used up their retaliation, it's harpy time! ;)\nSpecial: return to the hex they started from after an attack.", false, true),
    BEHOLDER("Beholder", 9, 7, 22, 5,Range.closed(3,5), 3, "Good shooter, plenty of hit points and no fear of close combat.\nSpecial: no hand-to-hand penalty.", false, false),
    MEDUSA("Medusa", 9, 9, 25, 5, Range.closed(6,8), 4, "Very good creature, would be a better deal than beholder if had more than 4 shots... Keep an ammo cart handy and if your enemy has medusas, make sure it's the first machine you destroy. But when their shots run out, they still make great fighters with the stoning abbility, no match for basilisks though.\nSpecial: no hand-to-hand penalty, hand-to-hand attacks have 20% chance to turn enemies to stone: 3 rounds, take 50% damage, unstoned when attacked.", false, false),
    MINOTAUR("Minotaur", 14, 12, 50, 6, Range.closed(12,20), 5, "Good level 5 fighter with a reasonable price. Minotaur's strategy is pretty simple: just go and smash, although a little blessing would be very useful. With the moral bonus, there's always a hope for a second turn.\nSpecial: minotaur's morale is never below 1.", false, false),
    MANTICORE("Manticore", 15, 13, 80, 7, Range.closed(14,20), 6, "The only dungeon creature without a special abbility, manticores are below-average for level 6 and lack hit points.", false, true),
    RED_DRAGON("Red Dragon", 19, 19, 180, 11,Range.closed(40,50), 7, "Stronger than green dragon, but otherways a dragon like any other.\nSpecial: immune to spells level 1-3.",false, true),
    INFERNAL_TROGLODYTE("Infernal Troglodyte", 5, 4, 6, 5, Range.closed(1,3), 1, "Upgrade is expensive but quite reasonable. Damage range is still huge.\nSpecial: immune to blind spell.", true, false),
    HARPY_HAG("Harpy Hag", 6, 6, 14, 9, Range.closed(1,4), 2, "Great upgrade. Now you can annoy your enemies from 9 hexes away, like from the other side of castle walls without loosing any harpy hags. Take note that both harpies and harpy hags retreat back when attacking shooters, so sometimes it's better to move close without attacking to prevent the more powerful range attacks.\nSpecial: return to the hex they started from after an attack, no enemy retaliation.", true, true),
    EVIL_EYE("Evil Eye", 10, 8, 22, 7, Range.closed(3,5), 3, "Little all-around upgrade. Evil eyes make a good shooter unit and they don't die as quick as most low level shooters.\nSpecial: no hand-to-hand penalty.", true, false),
    MEDUSA_QUEEN("Medusa Queen", 10, 10, 30, 6, Range.closed(6,8), 4, "Definitely worth upgrading: double shots, extra health and other minor upgrades for only 30 gold. Medusa queens and evil eyes make a good shooting combo together, especially at such early levels.\nSpecial: no hand-to-hand penalty, hand-to-hand attacks have 20% chance to turn enemies to stone: 3 rounds, take 50% damage, unstoned when attacked.", true, false),
    MINOTAUR_KING("Minotaur King", 15, 15, 50, 8, Range.closed(12,20), 5, "Good upgrade: 2 extra speed and much better defence rating. Smash strategy remains.\nSpecial: minotaur's morale is never below 1.", true, false),
    SCORPICORE("Scorpicore", 16, 14, 80, 11, Range.closed(14,20), 6, "Is there any actual difference between stoning and paralyzing? Hmmm... 200 gold for paralyzing, speed and 2 combat points... Scorpicores are a bit too expensive and 80 hit points is not enough - that's what happens when you breed a lion-bat-scorpion.\nSpecial: 20% chance to paralyze: take 50% damage, unparalyzed after 3 rounds or when attacked.", true, true),
    BLACK_DRAGON("Black Dragon", 25, 25, 300, 15, Range.closed(40,50), 7, "Little trick: titans do 150% damage to black dragons, but giants don't, so if you attack some giants, there's a definite bonus! Stronger than gold dragon, but not than archangel. Great for armageddon casters. Black dragons are terror of those heroes who have chosen magic over might, although there is one artifact that can break black dragon's spell immunity.\nSpecial: immune to all spells, 150% damage to giants and titans.", true, true);

    private final String name;
    private final int attack;
    private final int armor;
    private final int maxHp;
    private final int moveRange;
    private final Range<Integer> damage;
    private final int tier;
    private final String description;
    private final boolean isUpgraded;
    private final boolean flying;

    CreatureStatistic(String aName, int aAttack, int aArmor, int aMaxHp, int aMoveRange, Range<Integer> aDamage, int aTier, String aDescription, boolean aIsUpgraded, boolean aFlying) {
        name = aName;
        attack = aAttack;
        armor = aArmor;
        maxHp = aMaxHp;
        moveRange = aMoveRange;
        damage = aDamage;
        tier = aTier;
        description = aDescription;
        isUpgraded = aIsUpgraded;
        flying = aFlying;
    }

    public String getTranslatedName() {
        return name;
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

    public int getTier() {
        return tier;
    }

    public String getDescription() {
        return description;
    }

    boolean isUpgraded() {
        return isUpgraded;
    }

    public boolean isFlying() {
        return flying;
    }

}
