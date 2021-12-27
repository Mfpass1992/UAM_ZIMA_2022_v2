package pl.sdk.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pl.sdk.gui.dialogs.PickFractionAndHeroDialog;
import pl.sdk.hero.EconomyHero;

import java.util.List;

public class EconomyStart extends Application
{
    @Override
    public void start( Stage aStage ) throws Exception
    {
        List< EconomyHero > heroes = (new PickFractionAndHeroDialog(
            20000
            )).showDialog();
        loadNewEconomy( aStage, heroes );
    }

    private void loadNewEconomy( Stage aStage, List<EconomyHero> heroes ) throws Exception
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(
            getClass().getClassLoader().getResource("fxml/economyWindow.fxml")
            );
        loader.setController( new EcoController (
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
