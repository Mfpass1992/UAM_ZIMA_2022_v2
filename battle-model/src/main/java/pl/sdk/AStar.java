package pl.sdk;

import pl.sdk.creatures.Creature;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

public class AStar {
    private final Board board;

    public AStar(Board aBoard) {
        this.board = aBoard;
    }

    public Point[] findPath(int aX, int aY, Creature aCreature) {
        Point creaturePoint = board.get(aCreature);
        Point startPoint = new Point(creaturePoint.getX(), creaturePoint.getY(), 0.0);
        Point movePoint = board.getCurrentPointCost(new Point(aX, aY));

        PriorityQueue<Point> openSet = new PriorityQueue<>(new PointComparator());
        openSet.add(startPoint);

        PriorityQueue<Point> closedSet = new PriorityQueue<>(new PointComparator());

        HashMap<Point, Point> cameFrom = new HashMap<>();

        HashMap<Point, Double> gScore = new HashMap<>();
        gScore.put(startPoint, startPoint.getCost());

        HashMap<Point, Double> fScore = new HashMap<>();

        // For node n, fScore[n] := gScore[n] + h(n).
        // fScore[n] represents our current best guess as to
        // how short a path from start to finish can be if it goes through n.
        fScore.put(startPoint, startPoint.distance(movePoint));

        Point current;
        while (!openSet.isEmpty()){
            current = openSet.poll();
            closedSet.add(current);
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
                if (closedSet.contains(neighbor)) {
                    continue;
                }

                double tentativeGScore = gScore.get(current) + neighbor.getCost();

                if(!openSet.contains(neighbor) || tentativeGScore < gScore.getOrDefault(neighbor, Double.MAX_VALUE)) {
                    cameFrom.put(neighbor, current);
                    gScore.put(neighbor, tentativeGScore);
                    fScore.put(neighbor, neighbor.getCost() + gScore.get(neighbor));
                    if (!openSet.contains(neighbor)) {
                        openSet.add(neighbor);
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
