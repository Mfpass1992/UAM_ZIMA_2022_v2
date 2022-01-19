package pl.sdk.gui;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Modality;
import javafx.stage.Stage;
import pl.sdk.spells.DamageSpell;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

//KOM 3
// tutaj jednak button bo nie powinno sie bezposrednio dziedziczyc po Nodzie
public class SpellBookWindow extends Button {

    private Stage dialog;
    private final List<DamageSpell> spells;
    private final BattleMapController controller;
    private SpellTile selectedTile;
    private final Scene parentScene;

    public SpellBookWindow(LinkedList<DamageSpell> spells, BattleMapController controller, Scene parentScene) {
        super();
        this.spells = spells;
        this.controller = controller;
        this.parentScene = parentScene;
        this.selectedTile = null;


        //KOM 4
        //sprawdzenie czy lista jest pusta jakbyśmy zdecydowali się przekazywać czary tak jak w KOM 1
        // System.out.println("List size: " + spells.size());
        startDialog(spells);
    }

    Optional<SpellTile> getSelectedTile() {
        return Optional.ofNullable(selectedTile);
    }

    private void startDialog(LinkedList<DamageSpell> spellsList) {
        GridPane centerPane = new GridPane();
        centerPane.setAlignment(Pos.CENTER);
        HBox bottomPane = new HBox();
        HBox topPane = new HBox();
        Stage dialog = prepareWindow(centerPane, bottomPane, topPane);
        prepareConfirmAndCancelButton(bottomPane);
        prepareTop(topPane);
        prepareCenter(centerPane,spellsList);
        dialog.showAndWait();
    }

    private void setSelectedTile(SpellTile rec) {
        if (getSelectedTile().isPresent()) {
            selectedTile.unselectSpell();
        }
        selectedTile = rec;
        rec.selectSpell();

        //KOM 5
        //drukuje lokalizacje wybranego kafelka w pixelach
        System.out.println("X: " + rec.getLayoutX() + "Y: " + rec.getLayoutY());
    }

    private void prepareTop(HBox aTopPane) {
        //TODO creature cops should be visible here
        aTopPane.getChildren().add(new Label ("Spell Book"));
    }

    private void prepareCenter(GridPane aCenterPane, final LinkedList<DamageSpell> spells) {
        LinkedList<DamageSpell> damageSpells = new LinkedList<>(spells);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                SpellTile rec = new SpellTile(damageSpells.pop());
                aCenterPane.add(rec,i,j);

                rec.addEventHandler(MouseEvent.MOUSE_CLICKED, (e) -> setSelectedTile(rec));
            }
        }
    }

    private Stage prepareWindow(Pane aCenter, Pane aBottom, Pane aTop) {
        dialog = new Stage();
        BorderPane pane = new BorderPane();
        Scene scene = new Scene(pane, 800,800);
        scene.getStylesheets().add("fxml/main.css");
        dialog.setScene(scene);
        dialog.initOwner(parentScene.getWindow());
        dialog.initModality(Modality.APPLICATION_MODAL);

        pane.setTop(aTop);
        pane.setCenter(aCenter);
        pane.setBottom(aBottom);

        return dialog;
    }

    private void prepareConfirmAndCancelButton(HBox aBottomPane) {
        Button okButton = new Button("OK");
        aBottomPane.setAlignment(Pos.CENTER);
        okButton.addEventHandler(MouseEvent.MOUSE_CLICKED, (e) -> {
            dialog.close();
            getSelectedTile().ifPresent(spellTile -> controller.triggeredBySpellBookWindow(spellTile.getSpell()));

        });
        okButton.setPrefWidth(200);
        Button cancelButton = new Button("CLOSE");
        cancelButton.addEventHandler(MouseEvent.MOUSE_CLICKED, (e) ->
                dialog.close());
        cancelButton.setPrefWidth(200);
        HBox.setHgrow(okButton, Priority.ALWAYS);
        HBox.setHgrow(cancelButton, Priority.ALWAYS);
        aBottomPane.getChildren().add(okButton);
        aBottomPane.getChildren().add(cancelButton);
    }
}
