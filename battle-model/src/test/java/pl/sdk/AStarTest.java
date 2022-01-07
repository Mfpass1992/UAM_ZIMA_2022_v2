package pl.sdk;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.sdk.creatures.Creature;
import pl.sdk.creatures.NecropolisFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class AStarTest {

    private Board board;
    private Creature creature;
    private AStar astar;

    @BeforeEach
    void init(){
        board = new Board();
        astar = new AStar(board);
        creature = NecropolisFactory.createDefaultForTests2();
        board.add(new Point(0,1), creature);
    }

//    @Test
//    void astarSampleTest(){
//        Point creaturePoint = board.get(creature);
//        Point movePoint = new Point(0,1);
//        astar = new AStar(board);
//        assertEquals(astar.getCost(creaturePoint, movePoint), 1);
//    }

    @Test
    void creatureShouldMoveCorretly(){
        Point movePoint = new Point(0,3);
        Point[] path = astar.findPath(movePoint.getX(), movePoint.getY(), creature);
        assertEquals(path.length, 2);
    }

    @Test
    void creatureShouldAvoidObstacle(){
        Creature obstacle = NecropolisFactory.createDefaultForTests2();
        board.add(new Point(0,2), obstacle);
        Point movePoint = new Point(0,3);
        Point[] path = astar.findPath(movePoint.getX(), movePoint.getY(), creature);
        assertEquals(path.length, 4);
    }

    @Test
    void creatureShouldNotMove(){
        Creature obstacle = NecropolisFactory.createDefaultForTests2();
        board.add(new Point(0,2), obstacle);
        Point movePoint = new Point(0,5);
        assertFalse(board.canMove(creature, movePoint.getX(), movePoint.getY()));
    }

}
