package pl.sdk.gui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import pl.sdk.EconomyEngine;
import pl.sdk.converter.EcoBattleConverter;
import pl.sdk.creatures.EconomyCreature;
import pl.sdk.creatures.EconomyNecropolisFactory;
import pl.sdk.gui.buttons.CreatureButton;
import pl.sdk.gui.buttons.CreatureUnitButton;
import pl.sdk.gui.dialogs.BuyCreatureDialog;
import pl.sdk.hero.EconomyHero;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class EcoController implements PropertyChangeListener
{
// region fxml

    @FXML private ImageView heroImage;
    @FXML private Label playerNumberLabel;
    @FXML private Label heroNameLabel;
    @FXML private Label fractionLabel;
    @FXML private Label moneyLabel;
    @FXML private Button readyButton;

    @FXML private HBox abilitiesHBox;
    @FXML private HBox spellsHBox;
    @FXML private HBox artifactsHBox;
    @FXML private HBox creaturesHBox;

    @FXML private VBox creaturesVBox;

    @FXML void initialize() throws Exception
    {
        readyButton.setOnMouseClicked( (e) -> { economyEngine.pass(); } );
        readyButton.setDisable( true );

        refreshHeroPane( 1 );
        refreshCreaturesBox();
        refreshMoney();

        initCreaturesTab();
    }

    private void initCreaturesTab() throws Exception
    {
        // TODO : use correct factory
        EconomyNecropolisFactory factory = new EconomyNecropolisFactory();
        for (int i = 1; i < 8; i++) {
            creaturesVBox.getChildren().add( new CreatureButton(
                factory.create( false, i,1 ),
                this
                ) );
            creaturesVBox.getChildren().add( new CreatureButton(
                factory.create( true, i,1 ),
                this
                ) );
            }
    }

    private void refreshReadyButton()
    {
        readyButton.setDisable(
            economyEngine.getActiveHero().getCreatures().isEmpty()
            );
    }

    private void refreshHeroPane( int playerNumber )
    {
        fractionLabel.setText( economyEngine.getActiveHero().getFraction().name() );
        heroImage.setImage( ImageLoader.loadHero( "none" ) ); // TODO : connect hero images
        heroNameLabel.setText( "none" ); // TODO : connect hero names
        switch( playerNumber )
        {
            case 1: { playerNumberLabel.setText( "PLAYER I" ); break; }
            case 2: { playerNumberLabel.setText( "PLAYER II" ); break; }
            default: throw new IllegalArgumentException( "playerNumber should be 1 or 2" );
        }
    }

    private void refreshCreaturesBox()
    {
        creaturesHBox.getChildren().clear();
        for( EconomyCreature creature: economyEngine.getActiveHero().getCreatures() )
        {
            try {
                creaturesHBox.getChildren().add( new CreatureUnitButton( creature ) );
                }
            catch( Exception e ) { e.printStackTrace(); }
        }
    }

    private void refreshMoney()
    {
        moneyLabel.setText( ""+ economyEngine.getActiveHero().getGold() );
    }

// endregion
// region class

    private final EconomyEngine economyEngine;
    private final Stage stage;

    public EcoController(
        EconomyHero hero1,
        EconomyHero hero2,
        Stage stage
        )
    {
        this.stage = stage;
        this.economyEngine = new EconomyEngine( hero1, hero2 );
        economyEngine.addObserver(EconomyEngine.ACTIVE_HERO_CHANGED,this);
        economyEngine.addObserver(EconomyEngine.CREATURE_BOUGHT_OR_SOLD,this);
        economyEngine.addObserver(EconomyEngine.ECONOMY_FINISHED,this);
    }

    public void goToBattle()
    {
        stage.close();
        EcoBattleConverter.startBattle(economyEngine.getPlayer1(), economyEngine.getPlayer2());
    }

    @Override
    public void propertyChange( PropertyChangeEvent evt )
    {
        switch( evt.getPropertyName() )
        {
            case EconomyEngine.ACTIVE_HERO_CHANGED: {
                refreshReadyButton();
                refreshHeroPane( 2 );
                refreshMoney();
                refreshCreaturesBox();
                break; }
            case EconomyEngine.ECONOMY_FINISHED: {
                goToBattle();
                break; }
            case EconomyEngine.MONEY_TRANSFER: {
                refreshMoney();
                break; }
            case EconomyEngine.CREATURE_BOUGHT_OR_SOLD: {
                refreshCreaturesBox();
                refreshReadyButton();
                break; }
        }
    }

// endregion
// region dialogs

    public void buyCreatureDialog(
        EconomyCreature creature
        )
    {
        int amount = 0;
        try {
            amount = ( new BuyCreatureDialog(
                creature,
                economyEngine.getActiveHero().getGold()
                ) ).showDialog();
            }
        catch( Exception e ) { e.printStackTrace(); }
        if( amount != 0 ) {
            economyEngine.buy( ( new EconomyNecropolisFactory() ).create(
                creature.isUpgraded(),
                creature.getTier(),
                amount
                ) );
            }
    }

// endregion
}
