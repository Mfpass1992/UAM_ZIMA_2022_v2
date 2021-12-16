package pl.sdk.creatures;

import java.beans.PropertyChangeEvent;

import com.google.common.collect.Range;

class SplashDamageCreatureDecorator extends AbstractCreatureDecorator {

    private final boolean[][] splashDamageTable;

    public SplashDamageCreatureDecorator( final Creature aDecorated, final boolean[][] aSplashDamageTable) {
        super(aDecorated);
        splashDamageTable = aSplashDamageTable;
    }

    @Override
    public boolean[][] getSplashRange() {
        return splashDamageTable;
    }
}
