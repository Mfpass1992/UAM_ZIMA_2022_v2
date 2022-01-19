package pl.sdk.gui.dialogs;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import pl.sdk.creatures.Fraction;
import pl.sdk.hero.EconomyHero;
import pl.sdk.hero.EconomyHeroFactory;
import pl.sdk.hero.HeroStatistic;

import java.util.Arrays;
import java.util.List;

public class PickFractionAndHeroDialog {
// region fxml

    @FXML
    private ComboBox<Fraction> fractionPlayer1ComboBox;
    @FXML
    private ComboBox<Fraction> fractionPlayer2ComboBox;
    @FXML
    private ComboBox<String> heroPlayer1ComboBox;
    @FXML
    private ComboBox<String> heroPlayer2ComboBox;
    @FXML
    private Button beginButton;

    @FXML
    void initialize() {
        beginButton.setDisable(true); // checks if to enable on every hero combo choice
        beginButton.setOnMouseClicked(mouseEvent -> {
            if (canContinue()) {
                ((Stage) beginButton.getScene().getWindow()).close();
            }
        });

        fractionPlayer1ComboBox.setItems(
                FXCollections.observableList(Arrays.asList(initFractions()))
        );
        fractionPlayer1ComboBox.valueProperty().addListener(
                (observableValue, prevVal, newVal) ->
                        heroPlayer1ComboBox.setItems(
                                FXCollections.observableList(initHeroes(newVal))
                        )
        );
        heroPlayer1ComboBox.valueProperty().addListener(
                (observableValue, prevVal, newVal) ->
                        beginButton.setDisable(!canContinue())
        );

        fractionPlayer2ComboBox.setItems(
                FXCollections.observableList(Arrays.asList(initFractions()))
        );
        fractionPlayer2ComboBox.valueProperty().addListener(
                (observableValue, prevVal, newVal) ->
                        heroPlayer2ComboBox.setItems(
                                FXCollections.observableList(initHeroes(newVal))
                        )
        );
        heroPlayer2ComboBox.valueProperty().addListener(
                (observableValue, prevVal, newVal) ->
                        beginButton.setDisable(!canContinue())
        );
    }

    private Fraction[] initFractions() {
        return Fraction.values();
    }

    // TODO : connect with other modules
    private List<String> initHeroes(Fraction fraction) {
        List<String> herosNecropolis = Arrays.asList("hero necropolis 1", "hero necropolis 2");
        List<String> herosCastle = Arrays.asList("hero castle 1", "hero castle 2");

        switch (fraction) {
            case NECROPOLIS:
                return herosNecropolis;
            default:
                return List.of();
        }
    }

    private boolean canContinue() {
        if (fractionPlayer1ComboBox.getValue() == null) {
            return false;
        }
        if (fractionPlayer2ComboBox.getValue() == null) {
            return false;
        }
        if (heroPlayer1ComboBox.getValue() == null) {
            return false;
        }
        if (heroPlayer2ComboBox.getValue() == null) {
            return false;
        }

        return true;
    }

// endregion
// region class

    private final int startingMoney;

    public PickFractionAndHeroDialog(int startingMoney) {
        this.startingMoney = startingMoney;
    }

    public List<EconomyHero> showDialog() throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(
                getClass().getClassLoader().getResource("fxml/pickFractionAndHeroDialog.fxml")
        );
        loader.setController(this);

        Stage dialog = new Stage();
        dialog.setScene(new Scene(loader.load()));
        dialog.setOnCloseRequest(null);
        dialog.showAndWait();

        EconomyHeroFactory heroFactory = new EconomyHeroFactory();
        //TODO need one more combobox -> pick fracion -> pick hero
        // HeroStatistic.getHeroesByFraction(choosenFraction)
        return List.of(
                heroFactory.create(HeroStatistic.CLAVIUS.getHeroName(), startingMoney),
                heroFactory.create(HeroStatistic.CLAVIUS.getHeroName(), startingMoney)
        );
    }

// endregion
}
