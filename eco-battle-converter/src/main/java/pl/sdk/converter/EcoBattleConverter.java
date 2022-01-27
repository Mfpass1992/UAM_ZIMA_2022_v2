package pl.sdk.converter;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pl.sdk.Hero;
import pl.sdk.creatures.NecropolisFactory;
import pl.sdk.gui.BattleMapController;
import pl.sdk.hero.BattleHeroStatistics;
import pl.sdk.hero.EconomyHero;

import java.io.IOException;
import java.util.stream.Collectors;

public class EcoBattleConverter {

    public static void startBattle(EconomyHero aPlayer1, EconomyHero aPlayer2) {
        Scene scene = null;
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(EcoBattleConverter.class.getClassLoader().getResource("fxml/battleMap.fxml"));
            loader.setController(new BattleMapController(convert(aPlayer1), convert(aPlayer2)));
            scene = new Scene(loader.load());
            Stage aStage = new Stage();
            aStage.setScene(scene);
            aStage.setX(5);
            aStage.setY(5);
            aStage.show();
        } catch (IOException aE) {
            aE.printStackTrace();
        }
    }

    public static Hero convert(EconomyHero aPlayer1) {
        NecropolisFactory factory = new NecropolisFactory();
        BattleHeroStatistics battleHeroStatistics = new BattleHeroStatistics(aPlayer1.getHeroStatistic());
        Hero hero = new Hero(aPlayer1.getCreatures().stream().map(ecoCreature ->
                factory.create(ecoCreature.isUpgraded(), ecoCreature.getTier(), ecoCreature.getAmount())).collect(Collectors.toList()),
                battleHeroStatistics);
        return hero;
    }
}
