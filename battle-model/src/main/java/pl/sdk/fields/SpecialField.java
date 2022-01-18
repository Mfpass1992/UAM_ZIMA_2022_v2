package pl.sdk.fields;

import pl.sdk.GameEngine;
import pl.sdk.creatures.Creature;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public abstract class SpecialField implements PropertyChangeListener {
    private SpecialFieldType type;
    private int turns;
    private final PropertyChangeSupport observerSupport;

    public SpecialField(SpecialFieldType type, int turns) {
        this.type = type;
        this.turns = turns;
        observerSupport = new PropertyChangeSupport(this);
    }

    @Override
    public void propertyChange(PropertyChangeEvent aPropertyChangeEvent) {
        if (aPropertyChangeEvent.getPropertyName().equals(GameEngine.END_OF_TURN)) {
            this.turns--;
            if (this.turns == 0) {
                notifyObservers();
            }
        }
    }

    public SpecialFieldType getType() {
        return type;
    }

    public void addObserver(PropertyChangeListener aObserver){
        observerSupport.addPropertyChangeListener(GameEngine.FIELD_DESTROYED, aObserver);
    }

    void notifyObservers(){
        observerSupport.firePropertyChange(new PropertyChangeEvent( this, GameEngine.FIELD_DESTROYED, null, null));
    }

    /**
     * That method is empty to ensure compatibility between derived classes
     */
    public void triggerEffect(Creature creature) {
    }

}
