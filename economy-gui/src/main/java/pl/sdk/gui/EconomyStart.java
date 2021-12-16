package pl.sdk.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pl.sdk.hero.EconomyHero;

import java.util.List;

public class EconomyStart extends Application
{
    @Override
    public void start( Stage aStage ) throws Exception
    {
        /* TODO : uncomment after testing
        List< EconomyHero > heroes = (new PickFractionAndHeroDialog(
            20000
            )).showDialog();
        */
        List< EconomyHero > heroes = List.of(
            new EconomyHero( EconomyHero.Fraction.NECROPOLIS, 20000 ),
            new EconomyHero( EconomyHero.Fraction.NECROPOLIS, 20000 )
            );

        // loadOldEconomy( aStage, heroes );
        loadNewEconomy( aStage, heroes );
    }

    private void loadOldEconomy( Stage aStage, List<EconomyHero> heroes ) throws Exception
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(
            getClass().getClassLoader().getResource("fxml/eco.fxml")
            );
        loader.setController( new EcoController (
            heroes.get( 0 ),
            heroes.get( 1 )
            ) );

        Scene scene = new Scene( loader.load() );
        aStage.setScene(scene);
        aStage.setX(5);
        aStage.setY(5);
        aStage.show();
    }

    private void loadNewEconomy( Stage aStage, List<EconomyHero> heroes ) throws Exception
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(
            getClass().getClassLoader().getResource("fxml/economyWindow.fxml")
            );
        loader.setController( new NewEcoController (
            heroes.get( 0 ),
            heroes.get( 1 ),
            aStage
            ) );

        Scene scene = new Scene( loader.load() );
        aStage.setResizable( false );
        aStage.setScene(scene);
        aStage.setX(200);
        aStage.setY(70);
        aStage.show();
    }

    public static void main(String[] args)
    {
        launch();
    }
}
