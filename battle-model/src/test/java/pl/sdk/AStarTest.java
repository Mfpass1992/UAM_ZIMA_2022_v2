package pl.sdk;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.sdk.creatures.Creature;
import pl.sdk.creatures.NecropolisFactory;
//import pl.sdk.pathfinder.AStar;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AStarTest {

    private Board board;
    private Creature creature;
    private AStar astar;

    @BeforeEach
    void init(){
        board = new Board();
        creature = NecropolisFactory.createDefaultForTests2();
        board.add(new Point(0,1), creature);
    }

    @Test
    void astarSampleTest(){
        Point creaturePoint = board.get(creature);
        Point movePoint = new Point(0,1);
        astar = new AStar(creaturePoint, movePoint);
        assertEquals(astar.getCost(creaturePoint, movePoint), 1);
    }

    @Test
    void creatureShouldMoveCorretly(){
        Point creaturePoint = board.get(creature);
        Point movePoint = new Point(0,3);
        path = astar.findPath(creaturePoint, movePoint);
        assertEquals(path.length(), 3);
        assertEquals(path.get(path.size()-1), movePoint);
    }

    @Test
    void creatureShouldAvoidObstacle(){
        Point creaturePoint = board.get(creature);
        Creature obstacle = NecropolisFactory.createDefaultForTests2();
        board.add(new Point(0,2), obstacle);
        Point movePoint = new Point(0,3);
        path = astar.findPath(creaturePoint, movePoint);
        assertEquals(path.length(), 5);
        assertEquals(path.get(path.size()-1), movePoint);
    }

    @Test
    void astarShouldNotMoveCorretly(){
        Point creaturePoint = board.get(creature);
        Creature obstacle = NecropolisFactory.createDefaultForTests2();
        board.add(new Point(0,2), obstacle);
        Point movePoint = new Point(0,5);
        path = astar.findPath(creaturePoint, movePoint);
        Assertions.assertFalse(path.length(), 0);
    }

}
