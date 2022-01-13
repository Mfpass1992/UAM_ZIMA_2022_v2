package pl.sdk;

import org.junit.jupiter.api.Test;
import pl.sdk.creatures.CastleFactory;
import pl.sdk.creatures.Creature;
import pl.sdk.creatures.NecropolisFactory;

import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.*;

public class HandToHandPenaltyTest {

    @Test
    void checkHandToHandPenalty(){
        Creature rangeCreature = new NecropolisFactory().create(true, 5 , 1);
        Creature defender = spy(new NecropolisFactory().create(false, 2 , 1));

        Board board = new Board();
        board.add(new Point(1, 1), rangeCreature);
        board.add(new Point(1,3), defender);

        GameEngine gameEngine = new GameEngine(List.of(rangeCreature), Collections.emptyList(), board);
        gameEngine.attack(1,3);
    }
}
