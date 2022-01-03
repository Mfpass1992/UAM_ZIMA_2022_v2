package pl.sdk;

import java.util.Comparator;

public class PointComparator implements Comparator<Point> {
    @Override
    public int compare(Point p1, Point p2) {
        int result = (int) (p1.getCost() - p2.getCost());
        return result;
    }
}
