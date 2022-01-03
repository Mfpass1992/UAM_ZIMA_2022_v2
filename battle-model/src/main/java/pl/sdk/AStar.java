package pl.sdk;

import pl.sdk.creatures.Creature;

import java.util.*;

public class AStar {
    private Creature creature;
    private final Board board;
    private final CreatureTurnQueue creatureTurnQueue;
    private HashMap<Point, Double> costMap;

    public AStar(Board aBoard, CreatureTurnQueue aCreatureTurnQueue) {
        this.board = aBoard;
        this.creatureTurnQueue = aCreatureTurnQueue;
        this.costMap = board.getCostMap();
    }

    public int getCost(Point aCreaturePoint, Point aMovePoint){
        return 1;
    }

    public Point[] findPath(Creature aCreature, int aX, int aY) {
        Creature activeCreature = creatureTurnQueue.getActiveCreature();
        Point startPoint = board.get(activeCreature);
        Point movePoint = new Point(aX, aY);

        PriorityQueue<Point> openSet = new PriorityQueue<>(new PointComparator());
        openSet.add(startPoint);

        HashMap<Point, Double> gScore = new HashMap<>(); // cost so far
        gScore.put(startPoint, (double) 0.0);

        HashMap<Point, Double> fScore = new HashMap<>();

        HashMap<Point, Point> cameFrom = new HashMap<>();
        cameFrom.put(startPoint, null);

        Point current;
        while (!openSet.isEmpty()) {
            current = openSet.poll();

            if (current.equals(movePoint)){
                System.out.println("Path found");
                return reconstructPath(cameFrom, current);
            }
            Point[] neighbors = board.getNeighbors(aCreature);

            for(Point next: neighbors) {
                double tentativeGScore = gScore.get(current) + costMap.get(next);
                if ((!gScore.containsKey(next)) || tentativeGScore < gScore.getOrDefault(next, Double.MAX_VALUE)){
                    gScore.put(next, tentativeGScore);
                    fScore.put(next, gScore.get(next) + next.distance(movePoint));
                    costMap.put(next, costMap.get(next) + fScore.get(next));
                    openSet.add(next);
                    cameFrom.put(next, current);
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
