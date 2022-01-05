package pl.sdk;

import java.util.Objects;

import static java.lang.Math.abs;

public class Point {

    final private int x;
    final private int y;
    private double cost;

    public Point(int aX, int aY) {
        x = aX;
        y = aY;
    }

    public Point(int aX, int aY, double aCost) {
        x = aX;
        y = aY;
        cost = aCost;
    }

    int getX() {
        return x;
    }

    int getY() {
        return y;
    }

    double getCost() {
        return cost;
    }

    @Override
    public boolean equals(Object aO) {
        if (this == aO) return true;
        if (aO == null || getClass() != aO.getClass()) return false;
        Point point = (Point) aO;
        return x == point.x &&
                y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "{" + x + ", " + y + "}";
    }

    double distance(Point aPoint) {
        return abs(aPoint.x - x) + abs((aPoint.y - y));
        //return Math.sqrt((aPoint.y - y) * (aPoint.y - y) + (aPoint.x - x) * (aPoint.x - x));
    }
}
