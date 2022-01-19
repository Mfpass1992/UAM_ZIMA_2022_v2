package pl.sdk;

import pl.sdk.creatures.Creature;
import pl.sdk.fields.SpecialField;
import pl.sdk.fields.SpecialFieldType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static pl.sdk.GameEngine.BOARD_HEIGHT;
import static pl.sdk.GameEngine.BOARD_WIDTH;

class Board {

    private final Map<Point, Creature> creaturesMap;
    private final Map<Point, SpecialField> specialFieldsMap;
    private final AStar aStar = new AStar(this);
    private final static double DEFAULT_COST = 10.0;

    Board() {
        creaturesMap = new HashMap<>();
        specialFieldsMap = new HashMap<>();
    }

    void add(Point aPoint, Creature aCreature) {
        throwExceptionWhenIsOutsideMap(aPoint);
        throwExceptionIfTileIsTaken(aCreature, aPoint);
        creaturesMap.put(aPoint, aCreature);
    }

    void addField(Point point, SpecialField specialField) {
        throwExceptionWhenIsOutsideMap(point);
        throwExceptionIfTileIsTaken(specialField, point);
        specialFieldsMap.put(point, specialField);
    }

    private void throwExceptionIfTileIsTaken(Object object, Point aPoint) {
        if((object instanceof Creature && creaturesMap.containsKey(aPoint)) || (object instanceof SpecialField && specialFieldsMap.containsKey(aPoint)))
        {
            throw new IllegalArgumentException("Tile isn't empty");
        }
    }

    private boolean isTileTaken(Point aPoint) {
        return creaturesMap.containsKey(aPoint);
    }

    private void throwExceptionWhenIsOutsideMap(Point aPoint) {
        if (aPoint.getX() < 0 || aPoint.getX() > BOARD_WIDTH || aPoint.getY() < 0 || aPoint.getY() > BOARD_HEIGHT) {
            throw new IllegalArgumentException("You are trying to works outside the map");
        }
    }

    Creature get(int aX, int aY) {
        return creaturesMap.get(new Point(aX, aY));
    }

    SpecialField getField(int aX, int aY) {
        return specialFieldsMap.get(new Point(aX, aY));
    }

    Point get(Creature aCreature) {
        return creaturesMap.keySet().stream().filter(p -> creaturesMap.get(p).equals(aCreature)).findAny().get();
    }

    Point get(SpecialField specialField) {
        return specialFieldsMap.keySet().stream().filter(p -> specialFieldsMap.get(p).equals(specialField)).findAny().get();
    }

    Point[] getNeighborsForWalkingCreature(Point aPoint){
        int[][] dirs = {{1, 0}, {0, 1},
                        {-1, 0}, {0, -1}};
        ArrayList<Point> result = new ArrayList<>();

        for(int[] dir: dirs){
            if (0 <= (aPoint.getX() + dir[0]) && (aPoint.getX() + dir[0]) < BOARD_WIDTH
                    && (0 <= (aPoint.getY() + dir[1]) && (aPoint.getY() + dir[1]) < BOARD_HEIGHT)){

                Point node = returnPointWithCost(aPoint.getX() + dir[0], aPoint.getY() + dir[1]);
                result.add(node);
            }
        }
        Point[] arr = new Point[result.size()];
        return result.toArray(arr);
    }

    Point returnPointWithCost(int aX, int aY) {
        Point node = new Point(aX, aY);
        if(isTileTaken(node)){
            return new Point(aX, aY, Double.MAX_VALUE);
        } else {
            return new Point(aX, aY, DEFAULT_COST);
        }
    }

    Point[] getNeighborsForFlyingCreature(Point aPoint) {
        return null;
    }

    Point getCurrentPointCost(Point aPoint) {
        if(isTileTaken(aPoint)) {
            return new Point(aPoint.getX(), aPoint.getY(), Double.MAX_VALUE);
        } else {
            return new Point(aPoint.getX(), aPoint.getY(), DEFAULT_COST);
        }
    }

    void move(Creature aCreature, Point aTargetPoint1){
        move(get(aCreature), aTargetPoint1);
    }

    void move(Point aSourcePoint, Point aTargetPoint1) {
        throwExceptionWhenIsOutsideMap(aTargetPoint1);
        throwExceptionIfTileIsTaken(creaturesMap.get(aSourcePoint), aTargetPoint1);

        Creature creatureFromSourcePoint = creaturesMap.get(aSourcePoint);
        creaturesMap.remove(aSourcePoint);
        creaturesMap.put(aTargetPoint1, creatureFromSourcePoint);
    }

    boolean canMove(Creature aCreature, int aX, int aY) {
        throwExceptionWhenIsOutsideMap(new Point(aX, aY));
        if (!creaturesMap.containsValue(aCreature)) {
            throw new IllegalStateException("Creature isn't in board");
        }
        SpecialField field = specialFieldsMap.get(new Point(aX, aY));
        if(field!= null && field.getType() == SpecialFieldType.OBSTACLE_FIELD){
            return false;
        }
        Point currentPosition = get(aCreature);
        Point[] points = aStar.findPath(aX, aY, aCreature);
        double distance = currentPosition.distance(new Point(aX,aY));

        return distance <= aCreature.getMoveRange() && !isTileTaken(new Point(aX,aY)) && points.length <= aCreature.getMoveRange();
    }

    public void destroyField(SpecialField specialField) {
        specialFieldsMap.remove(get(specialField));
    }
}
