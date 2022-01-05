package pl.sdk;

import pl.sdk.creatures.Creature;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class AStar {
    private final Board board;
    private final CreatureTurnQueue creatureTurnQueue;
    private HashMap<Point, Double> costMap;

    public AStar(Board aBoard, CreatureTurnQueue aCreatureTurnQueue) {
        this.board = aBoard;
        this.creatureTurnQueue = aCreatureTurnQueue;
        this.costMap = board.getCostMap();
    }

    public Point[] A_star(int aX, int aY) {
        Creature activeCreature =  creatureTurnQueue.getActiveCreature();
        Point startPoint = board.get(activeCreature);
        Point movePoint = new Point(aX, aY);

        PriorityQueue<Point> openSet = new PriorityQueue<>(new PointComparator());
        openSet.add(startPoint);

        HashMap<Point, Point> cameFrom = new HashMap<>();

        HashMap<Point, Double> gScore = new HashMap<>();
        gScore.put(startPoint, 0.0);

        HashMap<Point, Double> fScore = new HashMap<>();
        // For node n, fScore[n] := gScore[n] + h(n).
        // fScore[n] represents our current best guess as to
        // how short a path from start to finish can be if it goes through n.
        // Czy to ma być od startPoint do movePoint?
        fScore.put(startPoint, startPoint.distance(movePoint));

        Point current;
        while (!openSet.isEmpty()){
            current = openSet.poll();

            if (current.equals(movePoint)) {
                System.out.println("Path to " + "[" + aX + ", " + aY + "]");
                return reconstructPath(cameFrom, current);
            }

            Point[] neighbours = board.getNeighbors(current);

//            openSet.remove(current);
            for(Point neighbor : neighbours) {
                //TODO zmienić "1" na koszt faktyczny
                double tentativeGScore = gScore.get(current) + 1;
                if(tentativeGScore < gScore.getOrDefault(neighbor, Double.MAX_VALUE)) {
                    cameFrom.put(neighbor, current);
                    gScore.put(neighbor, tentativeGScore);
                    fScore.put(neighbor, 1 + gScore.get(neighbor));
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
        int l = cameFrom.keySet().size();
        for(int i=0; i < l; i++){
            current = cameFrom.get(current);
            if (current != null){
                totalPath.add(0, current);
            }
        }

        Point[] arr = new Point[totalPath.size()];
        return totalPath.toArray(arr);
    }
}
