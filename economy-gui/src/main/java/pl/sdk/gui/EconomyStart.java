package pl.sdk.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import pl.sdk.hero.EconomyHero;

import java.awt.*;
import java.util.List;

public class EconomyStart extends Application
{

    @Override
    public void start( Stage aStage ) throws Exception
    {
        pickFractionAndHeroDialog();
        startEconomy( aStage );
    }

    private void pickFractionAndHeroDialog() throws Exception
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(
            getClass().getClassLoader().getResource("fxml/pickFractionAndHeroDialog.fxml")
            );
        loader.setController( new PickFractionAndHeroDialogController (
            ) );

        Stage dialog = new Stage();
        dialog.setScene( new Scene( loader.load() ) );
        dialog.showAndWait();
    }

    private void startEconomy( Stage aStage ) throws Exception
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(
            getClass().getClassLoader().getResource("fxml/eco.fxml")
            );
        loader.setController( new EcoController (
            new EconomyHero(EconomyHero.Fraction.NECROPOLIS, 3000),
            new EconomyHero(EconomyHero.Fraction.NECROPOLIS, 3000)
            ) );

        Scene scene = new Scene( loader.load() );
        aStage.setScene(scene);
        aStage.setX(5);
        aStage.setY(5);
        aStage.show();
    }

    public static void main(String[] args)
    {
        launch();
    }
}
