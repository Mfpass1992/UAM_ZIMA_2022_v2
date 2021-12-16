package pl.sdk.gui.buttons;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import pl.sdk.creatures.EconomyCreature;
import pl.sdk.gui.ImageLoader;
import pl.sdk.gui.NewEcoController;

public class NewCreatureButton extends Button
{
// region fxml

    @FXML private ImageView creatureImage;
    @FXML private Label creatureNameLabel;
    @FXML private Label creatureCostLabel;

    @FXML void initialize()
    {
        creatureImage.setImage( ImageLoader.loadCreature( creature.getName() ) );
        creatureNameLabel.setText( this.creature.getName() );
        creatureCostLabel.setText( "cost: "+this.creature.getGoldCost() );
    }

// endregion
// region class

    private final EconomyCreature creature;

    public NewCreatureButton(
        EconomyCreature creature,
        NewEcoController controller
        ) throws Exception
    {
        super();
        this.setMaxWidth( Double.MAX_VALUE );
        this.creature = creature;

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(
            getClass().getClassLoader().getResource("fxml/creatureButton.fxml")
            );
        loader.setController( this );
        setGraphic( loader.load() );

        addEventHandler( MouseEvent.MOUSE_CLICKED, (e) -> {
            controller.buyCreatureDialog( creature );
            } );
    }

// endregion
}
