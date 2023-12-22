package solutions.dec22;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Point3DTest {

    @Test
    public void shouldTellOnePointIsSmallerThanAnotherIfItsXIsSmaller() {
        Point3D point1 = new Point3D(1, 2, 3);
        Point3D point2 = new Point3D(2, 2, 3);
        assertTrue(point1.compareTo(point2) < 0);
    }

    @Test
    public void shouldTellOnePointIsBiggerThanAnotherIfItsXIsBigger() {
        Point3D point1 = new Point3D(2, 2, 3);
        Point3D point2 = new Point3D(1, 2, 3);
        assertTrue(point1.compareTo(point2) > 0);
    }

    @Test
    public void shouldReturnOnePointIsSmallerIfXsAreEqualAndYIsSmaller() {
        Point3D point1 = new Point3D(1, 1, 3);
        Point3D point2 = new Point3D(1, 2, 3);
        assertTrue(point1.compareTo(point2) < 0);
    }

    @Test
    public void shouldReturnOnePointIsBiggerIfXsAreEqualAndYIsBigger() {
        Point3D point1 = new Point3D(1, 2, 3);
        Point3D point2 = new Point3D(1, 1, 3);
        assertTrue(point1.compareTo(point2) > 0);
    }

    @Test
    public void shouldReturnOnePointIsSmallerIfXsAndYsAreEqualAndZIsSmaller() {
        Point3D point1 = new Point3D(1, 1, 1);
        Point3D point2 = new Point3D(1, 1, 2);
        assertTrue(point1.compareTo(point2) < 0);
    }

    @Test
    public void shouldReturnOnePointIsBiggerIfXsAndYsAreEqualAndZIsBigger() {
        Point3D point1 = new Point3D(1, 1, 2);
        Point3D point2 = new Point3D(1, 1, 1);
        assertTrue(point1.compareTo(point2) > 0);
    }

    @Test
    public void shouldReturnZeroIfPointsAreEqual() {
        Point3D point1 = new Point3D(1, 1, 1);
        Point3D point2 = new Point3D(1, 1, 1);
        assertEquals(0, point1.compareTo(point2));
    }

}