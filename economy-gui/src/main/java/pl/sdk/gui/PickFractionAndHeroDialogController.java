package pl.sdk.gui;

import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.util.Arrays;
import java.util.List;

public class PickFractionAndHeroDialogController
{

    @FXML ComboBox<String> fractionPlayer1ComboBox;
    @FXML ComboBox<String> fractionPlayer2ComboBox;
    @FXML ComboBox<String> heroPlayer1ComboBox;
    @FXML ComboBox<String> heroPlayer2ComboBox;
    @FXML Button beginButton;

    List<String> fractions;
    List<String> herosNecropolis;
    List<String> herosCastle;

    @FXML void initialize()
    {
        // TODO : load fractions & heroes
        fractions = Arrays.asList( "necropolis", "castle" );
        herosNecropolis = Arrays.asList( "hero necropolis 1", "hero necropolis 2" );
        herosCastle = Arrays.asList( "hero castle 1", "hero castle 2" );

        fractionPlayer1ComboBox.setItems( FXCollections.observableList( fractions ) );
        fractionPlayer1ComboBox.valueProperty().addListener(
            ( observableValue, prevVal, newVal ) -> fractionPlayer1Changed( newVal )
            );
        fractionPlayer2ComboBox.setItems( FXCollections.observableList( fractions ) );
        fractionPlayer1ComboBox.valueProperty().addListener(
            ( observableValue, prevVal, newVal ) -> fractionPlayer2Changed( newVal )
            );

        // heroPlayer1ComboBox.setItems( FXCollections.observableList( herosNecropolis ) );
        // heroPlayer2ComboBox.setItems( FXCollections.observableList( herosNecropolis ) );
    }

    private void fractionPlayer1Changed( String fraction )
    {
        switch( fraction )
        {
            case "necropolis":
                heroPlayer1ComboBox.setItems( FXCollections.observableList( herosNecropolis ) );
                break;
            case "castle":
                heroPlayer1ComboBox.setItems( FXCollections.observableList( herosCastle ) );
                break;
        }
    }

    private void fractionPlayer2Changed( String fraction )
    {
        System.out.println( "changed" );
    }
}
