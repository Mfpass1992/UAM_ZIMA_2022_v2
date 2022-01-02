package pl.sdk.pathfinder;

import pl.sdk.Point;

import java.util.ArrayList;

public class AStar {
    private Point creaturePoint;
    private Point movePoint;

    public AStar(Point creaturePoint, Point movePoint) {
        this.creaturePoint = creaturePoint;
        this.movePoint = movePoint;
    }

    public int getCost(Point aCreaturePoint, Point aMovePoint){
        return 1;
    }
}
