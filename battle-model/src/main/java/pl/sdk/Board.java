package pl.sdk;

import pl.sdk.creatures.Creature;

import java.util.*;

import static pl.sdk.GameEngine.BOARD_HEIGHT;
import static pl.sdk.GameEngine.BOARD_WIDTH;

class Board {

    private final Map<Point, Creature> map;
    private AStar aStar = new AStar(this);
    private final static double DEFAULT_COST = 10.0;

    Board() {
        map = new HashMap<>();
    }

    void add(Point aPoint, Creature aCreature) {
        throwExceptionWhenIsOutsideMap(aPoint);
        throwExceptionIfTileIsTaken(aPoint);
        map.put(aPoint,aCreature);
    }

    private void throwExceptionIfTileIsTaken(Point aPoint) {
        if (isTileTaken(aPoint)){
            throw new IllegalArgumentException("Tile isn't empty");
        }
    }

    private boolean isTileTaken(Point aPoint) {
        return map.containsKey(aPoint);
    }

    private void throwExceptionWhenIsOutsideMap(Point aPoint) {
        if (aPoint.getX() < 0 || aPoint.getX() > BOARD_WIDTH || aPoint.getY() < 0 || aPoint.getY() > BOARD_HEIGHT ) {
            throw new IllegalArgumentException("You are trying to works outside the map");
        }
    }

    Creature get(int aX, int aY) {
        return map.get(new Point(aX,aY));
    }

    Point get(Creature aCreature){
        return map.keySet().stream().filter(p -> map.get(p).equals(aCreature)).findAny().get();
    }

    Point[] getNeighbors(Point aPoint){
        int[][] dirs = {
                {1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        ArrayList<Point> result = new ArrayList<Point>();

        for(int[] dir: dirs){
            if (0 <= (aPoint.getX() + dir[0]) && (aPoint.getX() + dir[0]) < BOARD_WIDTH
                    && (0 <= (aPoint.getY() + dir[1]) && (aPoint.getY() + dir[1]) < BOARD_HEIGHT)){
                Point node = new Point(aPoint.getX() + dir[0], aPoint.getY() + dir[1]);
                if(isTileTaken(node)){
                    Point addPoint = new Point(aPoint.getX() + dir[0], aPoint.getY() + dir[1], Double.MAX_VALUE);
                    result.add(addPoint);
                } else {
                    Point addPoint = new Point(aPoint.getX() + dir[0], aPoint.getY() + dir[1], 10.0);
                    result.add(addPoint);
                }
            }
        }
        Point arr[] = new Point[result.size()];
        return result.toArray(arr);
    }

    Point getCurrentPointCost(Point aPoint) {
        if(isTileTaken(aPoint)) {
            return new Point(aPoint.getX(), aPoint.getY(), Double.MAX_VALUE);
        } else {
            return new Point(aPoint.getX(), aPoint.getY(), DEFAULT_COST);
        }
    }

//    HashMap<Point, Double> getCostMap(){
//        HashMap<Point, Double> result = new HashMap<>();
//
//        for(int height = 0; height < BOARD_HEIGHT; height++){
//            for(int width = 0; width < BOARD_WIDTH; width++) {
//                Point current = new Point(width, height);
//                if(isTileTaken(current)){
//                    Point addPoint = new Point(width, height, Double.MAX_VALUE);
//                    result.put(addPoint, addPoint.getCost());
//                } else {
//                    Point addPoint = new Point(width, height, 10.0);
//                    result.put(addPoint, addPoint.getCost());
//                }
//            }
//        }
//        return result;
//    }

    void move(Creature aCreature, Point aTargetPoint1){
        move(get(aCreature), aTargetPoint1);
    }

    void move(Point aSourcePoint, Point aTargetPoint1) {
        throwExceptionWhenIsOutsideMap(aTargetPoint1);
        throwExceptionIfTileIsTaken(aTargetPoint1);
        Creature creatureFromSourcePoint = map.get(aSourcePoint);
        map.remove(aSourcePoint);
        map.put(aTargetPoint1,creatureFromSourcePoint);
    }

    boolean canMove(Creature aCreature, int aX, int aY) {
        throwExceptionWhenIsOutsideMap(new Point(aX,aY));

        if (!map.containsValue(aCreature)){
            throw new IllegalStateException("Creature isn't in board");
        }
        Point currentPosition = get(aCreature);
        Point[] points = aStar.findPath(aX, aY, aCreature);
        double distance = currentPosition.distance(new Point(aX,aY));

        return distance <= aCreature.getMoveRange() && !isTileTaken(new Point(aX,aY)) && points.length - 1 <= aCreature.getMoveRange();
    }

}
