package solutions.dec22;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Point2DTest {

    @Test
    public void shouldTellOnePointIsSmallerThanAnotherIfItsXIsSmaller() {
        Point2D point1 = new Point2D(1, 2);
        Point2D point2 = new Point2D(2, 2);
        assertTrue(point1.compareTo(point2) < 0);
    }

    @Test
    public void shouldTellOnePointIsBiggerThanAnotherIfItsXIsBigger() {
        Point2D point1 = new Point2D(2, 2);
        Point2D point2 = new Point2D(1, 2);
        assertTrue(point1.compareTo(point2) > 0);
    }

    @Test
    public void shouldReturnOnePointIsSmallerIfXsAreEqualAndYIsSmaller() {
        Point2D point1 = new Point2D(1, 1);
        Point2D point2 = new Point2D(1, 2);
        assertTrue(point1.compareTo(point2) < 0);
    }

    @Test
    public void shouldReturnOnePointIsBiggerIfXsAreEqualAndYIsBigger() {
        Point2D point1 = new Point2D(1, 2);
        Point2D point2 = new Point2D(1, 1);
        assertTrue(point1.compareTo(point2) > 0);
    }

    @Test
    public void shouldReturnZeroIfPointsAreEqual() {
        Point2D point1 = new Point2D(1, 1);
        Point2D point2 = new Point2D(1, 1);
        assertEquals(0, point1.compareTo(point2));
    }

}