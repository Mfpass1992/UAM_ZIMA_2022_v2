package pl.sdk.gui.dialogs;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import pl.sdk.creatures.EconomyCreature;
import pl.sdk.gui.ImageLoader;

public class BuyCreatureDialog
{
// region fxml

    @FXML Label dialogTitleLabel;
    @FXML ImageView creatureImage;
    @FXML Slider slider;

    @FXML Label costPerTroopLabel;
    @FXML Label totalCostLabel;
    @FXML Label recruitLabel;
    @FXML Label affordableLabel;

    @FXML Button cancelButton;
    @FXML Button takeAllButton;
    @FXML Button confirmButton;

    @FXML void initialize()
    {
        int maxCreaturesAffordable = availableMoney / creature.getGoldCost();

        dialogTitleLabel.setText( "Recruit "+creature.getName() );
        creatureImage.setImage( ImageLoader.loadCreature( creature.getName() ) );
        costPerTroopLabel.setText( ""+ creature.getGoldCost() );
        affordableLabel.setText( ""+ maxCreaturesAffordable );

        slider.setMajorTickUnit( 1 );
        slider.setMax( maxCreaturesAffordable );
        slider.setSnapToTicks( true );
        slider.valueProperty().addListener(
        ( observableValue, prevVal, newVal ) -> {
            newVal = Math.floor( newVal.intValue() );
            recruitLabel.setText( Integer.toString( newVal.intValue() ) );
            totalCostLabel.setText( ""+ newVal.intValue() * creature.getGoldCost() );
            } );

        cancelButton.setOnMouseClicked( (e) -> {
            this.recruitLabel.setText( ""+ 0 );
            dialog.close();
            } );
        takeAllButton.setOnMouseClicked( (e) ->
            slider.setValue( maxCreaturesAffordable )
            );
        confirmButton.setOnMouseClicked( (e) ->
            dialog.close()
            );
    }

// endregion

// region class

    private final EconomyCreature creature;
    private final int availableMoney;
    private final Stage dialog;

    public BuyCreatureDialog(
        EconomyCreature creature,
        int availableMoney
        )
    {
        this.creature = creature;
        this.availableMoney = availableMoney;

        this.dialog = new Stage();
    }

    public int showDialog() throws Exception
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(
            getClass().getClassLoader().getResource("fxml/buyCreatureDialog.fxml")
            );
        loader.setController( this );

        dialog.setScene( new Scene( loader.load() ) );
        dialog.setOnCloseRequest( null );
        dialog.showAndWait();

        return Integer.parseInt( recruitLabel.getText() );
    }

// endregion
}
