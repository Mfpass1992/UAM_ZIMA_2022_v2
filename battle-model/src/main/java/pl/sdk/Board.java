package pl.sdk;

import pl.sdk.creatures.Creature;

import java.util.*;

import static pl.sdk.GameEngine.BOARD_HEIGHT;
import static pl.sdk.GameEngine.BOARD_WIDTH;

class Board {

    private final Map<Point, Creature> map;

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

    Point[] getNeighbors(Creature aCreature){
        int[][] dirs = {
                {1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        ArrayList<Point> result = new ArrayList<Point>();
        Point currentPosition = get(aCreature);

        for(int[] dir: dirs){
            if (0 <= (currentPosition.getX() + dir[0]) && (currentPosition.getX() + dir[0]) < BOARD_WIDTH
                    && (0 <= (currentPosition.getY() + dir[1]) && (currentPosition.getY() + dir[1]) < BOARD_HEIGHT)){
                Point node = new Point(currentPosition.getX() + dir[0], currentPosition.getY() + dir[1]);
                if(isTileTaken(node)){
                    Point addPoint = new Point(currentPosition.getX() + dir[0], currentPosition.getY() + dir[1], Double.MAX_VALUE);
                    result.add(addPoint);
                } else {
                    Point addPoint = new Point(currentPosition.getX() + dir[0], currentPosition.getY() + dir[1], 10.0);
                    result.add(addPoint);
                }
                //result.add(node);
            }
        }
        Point arr[] = new Point[result.size()];
        return result.toArray(arr);
    }

    HashMap<Point, Double> getCostMap(){
        HashMap<Point, Double> result = new HashMap<>();

        for(int height = 0; height < BOARD_HEIGHT; height++){
            for(int width = 0; width < BOARD_WIDTH; width++) {
                Point current = new Point(width, height);
                if(isTileTaken(current)){
                    Point addPoint = new Point(width, height, Double.MAX_VALUE);
                    result.put(addPoint, addPoint.getCost());
                } else {
                    Point addPoint = new Point(width, height, 10.0);
                    result.put(addPoint, addPoint.getCost());
                }
            }
        }
        return result;
    }

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
        double distance = currentPosition.distance(new Point(aX,aY));
        return distance <= aCreature.getMoveRange() && !isTileTaken(new Point(aX,aY));
    }

}
