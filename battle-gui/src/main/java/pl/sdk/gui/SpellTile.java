package pl.sdk.gui;

import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import pl.sdk.spells.DamageSpell;
import java.util.Objects;

class SpellTile extends StackPane {

    private final Rectangle rec;
    private final DamageSpell spell;

    public SpellTile(DamageSpell aSpell) {
        this.spell = aSpell;
        this.rec = new Rectangle(100, 100, Color.WHITE);
        rec.setStroke(Color.BLACK);
        getChildren().add(rec);
        addSpell(aSpell); //dodanie parametru- bardziej ogólne rozwiązanie
    }

    void selectSpell() {
        rec.setFill(Color.AQUAMARINE);
    }

    void unselectSpell() {
        rec.setFill(Color.WHITE);
    }

    public DamageSpell getSpell() {
        return spell;
    }

    void addSpell(DamageSpell aDamageSpell) {
        VBox vbox = new VBox();
        vbox.setAlignment(Pos.CENTER);
        ImageView image = new ImageView(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/spells/" + aDamageSpell.getName() + ".png"))));
        image.setFitHeight(70);
        image.setFitWidth(70);
        vbox.getChildren().add(image);
        getChildren().add(vbox);
    }

}
