package pl.sdk.gui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import pl.sdk.*;
import pl.sdk.spells.DamageSpell;
import pl.sdk.spells.SpellFactory;
import pl.sdk.spells.SpellStatistics;
import pl.sdk.creatures.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BattleMapController implements PropertyChangeListener {

    @FXML
    private GridPane gridMap;

    @FXML
    private Button passButton;

    @FXML
    private Button spellBookButton;

    private final GameEngine gameEngine;


    public BattleMapController() {
        List<Creature> notUpgradedCreatures = new ArrayList<>();
        List<Creature> upgradedCreatures = new ArrayList<>();
        FractionFactory fractionFactory = new FractionFactory();
        AbstractCreatureFactory castleFactory = fractionFactory.getInstance(Fractions.CASTLE);

        for (int i = 1; i <= 7; i++) {
            notUpgradedCreatures.add(castleFactory.create(false, i, 10));
        }

        for (int i = 1; i <= 7; i++) {
            upgradedCreatures.add(castleFactory.create(true, i, 10));
        }

        gameEngine = new GameEngine(notUpgradedCreatures, upgradedCreatures);

    }

    public BattleMapController(List<Creature> aCreatures1, List<Creature> aCreatures2){
        gameEngine = new GameEngine(aCreatures1, aCreatures2);
    }

    @FXML
    void initialize() {
        gameEngine.addObserver(GameEngine.CURRENT_CREATURE_CHANGED, this);
        gameEngine.addObserver(GameEngine.CREATURE_MOVED, this);
        gameEngine.addObserver(GameEngine.CREATURE_ATTACKED, this);
        gameEngine.addObserver(GameEngine.SPELL_CASTED, this);

        passButton.addEventHandler(MouseEvent.MOUSE_CLICKED, (e) -> {
            gameEngine.pass();
        });

        refreshGui();

        VBox availableSpells = new VBox();
        SpellFactory spellFactory = new SpellFactory();
        spellBookButton.addEventHandler(MouseEvent.MOUSE_CLICKED, (e) -> {
            availableSpells.getChildren().add(new SpellBookWindow(new LinkedList<>(List.of(//Ta lista będzie przekazywana na starcie gry z hero, ta jest testowa
                    spellFactory.createDamageSpell(1,1, SpellStatistics.MAGIC_ARROW),
                    spellFactory.createDamageSpell(1,1, SpellStatistics.ICE_BOLT),
                    spellFactory.createDamageSpell(1,1, SpellStatistics.LIGHTNING_BOLT),
                    spellFactory.createDamageSpell(1,1, SpellStatistics.LIGHTNING_BOLT),
                    spellFactory.createDamageSpell(1,1, SpellStatistics.MAGIC_ARROW),
                    spellFactory.createDamageSpell(1,1, SpellStatistics.ICE_BOLT),
                    spellFactory.createDamageSpell(1,1, SpellStatistics.LIGHTNING_BOLT),
                    spellFactory.createDamageSpell(1,1, SpellStatistics.MAGIC_ARROW),
                    spellFactory.createDamageSpell(1,1, SpellStatistics.ICE_BOLT)
            )), this, gridMap.getScene()));
        });
    }

    void refreshGui() {

        for (int x = 0; x < 20; x++) {
            for (int y = 0; y < 15; y++) {
                MapTile rec = new MapTile();
                gridMap.add(rec, x, y);

                Creature c = gameEngine.get(x, y);
                if (c != null) {
                    rec.addCreature(c.getName(), c.getAmount());

                    if (c == gameEngine.getActiveCreature()) {
                        rec.setBackground(Color.GREEN);
                    } else if (gameEngine.canAttack(x, y)) {
                        final int x1 = x;
                        final int y1 = y;
                        rec.setBackground(Color.RED);
                        rec.addEventHandler(MouseEvent.MOUSE_CLICKED, (e) -> gameEngine.attack(x1, y1));
                    }
                } else if (gameEngine.canMove(x, y)) {
                    final int x1 = x;
                    final int y1 = y;
                    rec.setBackground(Color.GREY);
                    rec.addEventHandler(MouseEvent.MOUSE_CLICKED, (e) -> gameEngine.move(new Point(x1, y1)));
                }

            }
        }



        //KOM 1
        // tutaj zakomentowana ładniejsza wersja ale niestety nie działa :( Za drugim razem jak się nacisnie przyciask
        // spellbook to nie pokazuje się okienko,
        // przez to że Lista spelli przekazuje się jako pusta
//        VBox availableSpells = new VBox();
//        SpellFactory spellFactory = new SpellFactory();
//        LinkedList<DamageSpell> spells = new LinkedList<>();
//        for (int i = 0; i < 9; i++) {
//            spells.add(spellFactory.createDamageSpell(1,1, SpellStatistics.MAGIC_ARROW));
//        }
//
//        spellBookButton.addEventHandler(MouseEvent.MOUSE_CLICKED, (e) -> {
//            availableSpells.getChildren().add(new SpellBookWindow(spells, this, gridMap.getScene()));
//        });
    }

    void refreshGUISpells (DamageSpell activeSpell){
        for (int x = 0; x < 20; x++) {
            for (int y = 0; y < 15; y++) {
                MapTile rec = new MapTile();
                gridMap.add(rec, x, y);

                Creature c = gameEngine.get(x, y);
                if (c != null) {
                    rec.addCreature(c.getName(), c.getAmount());
                }
                if (gameEngine.canBeTargetedBySPell(x,y)){
                    final int x1 = x;
                    final int y1 = y;
                    rec.setBackground(Color.BLUE);
                    rec.addEventHandler(MouseEvent.MOUSE_CLICKED, (e) -> gameEngine.cast(activeSpell,new Point(x1, y1)));

                }

            }
        }


    }

    public void triggeredBySpellBookWindow(DamageSpell spell) {
        //KOM 2
        // tutaj wywoływane metody z game enginu/naszej własnej fasady
        System.out.println("Spell passed successfully! " + spell.getName());

        refreshGUISpells(spell);






    }

    @Override
    public void propertyChange(PropertyChangeEvent aPropertyChangeEvent) {
        refreshGui();
    }
}
