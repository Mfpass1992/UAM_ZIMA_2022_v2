package pl.sdk;

import pl.sdk.creatures.Creature;

import java.util.*;

public class AStar {
    private final Board board;

    public AStar(Board aBoard) {
        this.board = aBoard;
    }

    public Point[] findPath(int aX, int aY, Creature aCreature) {
        Point creaturePoint = board.get(aCreature);
        Point startPoint = new Point(creaturePoint.getX(), creaturePoint.getY(), 0.0);
        Point movePoint = board.getCurrentPointCost(new Point(aX, aY));

        LinkedList<Point> openList = new LinkedList<>();
        openList.add(startPoint);

        LinkedList<Point> closedList = new LinkedList<>();

        HashMap<Point, Point> cameFrom = new HashMap<>();

        HashMap<Point, Double> gScore = new HashMap<>();
        gScore.put(startPoint, startPoint.getCost());

        HashMap<Point, Double> fScore = new HashMap<>();

        // For node n, fScore[n] := gScore[n] + h(n).
        // fScore[n] represents our current best guess as to
        // how short a path from start to finish can be if it goes through n.
        fScore.put(startPoint, startPoint.distance(movePoint));

        Point current;
        while (!openList.isEmpty()) {
            Point minKey = getMinKey(fScore, openList);
            current = minKey;
            openList.remove(current);
            closedList.add(current);
            if (current.equals(movePoint)) {
//                System.out.println("Path to " + "[" + aX + ", " + aY + "]");
                return reconstructPath(cameFrom, current);
            }

            Point[] neighboursCostless = board.getNeighbors(current);

            ArrayList<Point> neighbours = new ArrayList<>();
            for(Point neighbor : neighboursCostless) {
                Point toAdd = board.getCurrentPointCost(neighbor);
                neighbours.add(toAdd);
            }

//            openSet.remove(current);
            for(Point neighbor : neighbours) {
                if (closedList.contains(neighbor)) {
                    continue;
                }

                double tentativeGScore = gScore.get(current) + neighbor.getCost();

                if(!openList.contains(neighbor) || tentativeGScore < gScore.getOrDefault(neighbor, Double.MAX_VALUE)) {
                    cameFrom.put(neighbor, current);
                    gScore.put(neighbor, tentativeGScore);
//                    fScore.put(neighbor, neighbor.getCost() + gScore.get(neighbor));
                    fScore.put(neighbor, neighbor.getCost() + neighbor.distance(movePoint));
                    if (!openList.contains(neighbor)) {
                        openList.add(neighbor);
                    }
                }
            }
        }

        return null;
    }

    public Point[] reconstructPath(HashMap<Point, Point> cameFrom, Point current){
        ArrayList<Point> totalPath = new ArrayList<>();
        totalPath.add(current);

        while(cameFrom.containsKey(current)){
            current = cameFrom.get(current);
            totalPath.add(current);
        }

        Point[] arr = new Point[totalPath.size()];
        return totalPath.toArray(arr);
    }

    private Point getMinKey(Map<Point, Double> fScore, LinkedList<Point> openlist) {
        Point minKey = null;
        double minValue = Integer.MAX_VALUE;
        for (Point key : openlist) {
            double value = fScore.getOrDefault(key, (double) Integer.MAX_VALUE);
            if (value < minValue) {
                minValue = value;
                minKey = key;
            }
        }
        return minKey;
    }
//    public Point[] reconstructPath(HashMap<Point, Point> cameFrom, Point current){
//        ArrayList<Point> totalPath = new ArrayList<>();
//        totalPath.add(current);
//        int l = cameFrom.keySet().size();
//        for(int i=0; i < l; i++){
//            current = cameFrom.get(current);
//            if (current != null){
//                totalPath.add(0, current);
//            }
//        }
//
//        Point[] arr = new Point[totalPath.size()];
//        return totalPath.toArray(arr);
//    }
}
