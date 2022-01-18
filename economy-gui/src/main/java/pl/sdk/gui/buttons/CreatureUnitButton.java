package pl.sdk.gui.buttons;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import pl.sdk.creatures.EconomyCreature;
import pl.sdk.gui.ImageLoader;

import javax.annotation.Nullable;

public class CreatureUnitButton extends Button
{
// region fxml

    @FXML ImageView creatureImage;
    @FXML Label creatureAmountLabel;

    @FXML void initialize()
    {
        if( creature != null )
        {
            creatureImage.setImage( ImageLoader.loadCreature( creature.getName() ) );
            creatureAmountLabel.setText( ""+ creature.getAmount() );
        }
        else
        {
            creatureImage.setImage( null );
            creatureAmountLabel.setText( "" );
        }
    }

// endregion
// region class

    @Nullable private final EconomyCreature creature;

    public CreatureUnitButton(
        @Nullable EconomyCreature creature
        ) throws Exception
    {
        super();
        this.creature = creature;

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(
            getClass().getClassLoader().getResource("fxml/creatureUnitButton.fxml")
            );
        loader.setController( this );
        setGraphic( loader.load() );
    }

// endregion
}
