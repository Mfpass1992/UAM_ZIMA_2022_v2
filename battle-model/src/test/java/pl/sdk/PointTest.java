package pl.sdk;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PointTest {


    @Test
    void shouldCountDistanceCorrectly(){
        Point p00 = new Point(0,0);
        Point p10 = new Point(1,0);
        Point p01 = new Point(0,1);
        Point p11 = new Point(1,1);
        Point p1010 = new Point(10,10);

        assertEquals(1.0,p00.distance(p10));
        assertEquals(1.0,p00.distance(p01));
        assertEquals(2.0,p00.distance(p11));
        assertEquals(20.0, p00.distance(p1010));
    }
}