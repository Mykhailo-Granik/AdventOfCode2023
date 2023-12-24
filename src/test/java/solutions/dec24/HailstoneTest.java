package solutions.dec24;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HailstoneTest {

    @Test
    public void shouldFindPointOfIntersectionIn2D() {
        Hailstone underTest = new Hailstone(
                new CoordinateChangeVector(19, -2),
                new CoordinateChangeVector(13, 1),
                new CoordinateChangeVector(30, -2)
        );
        Hailstone other = new Hailstone(
                new CoordinateChangeVector(18, -1),
                new CoordinateChangeVector(19, -1),
                new CoordinateChangeVector(22, -2)
        );
        Coordinate2D intersection = underTest.findPointOfIntersection(other);
        assertEquals(14.3333333, intersection.getX(), 0.0001);
        assertEquals(15.3333333, intersection.getY(), 0.0001);
    }

    @Test
    public void shouldFindPointOfIntersectionForOtherExample() {
        Hailstone underTest = new Hailstone(
                new CoordinateChangeVector(19, -2),
                new CoordinateChangeVector(13, 1),
                new CoordinateChangeVector(30, -2)
        );
        Hailstone other = new Hailstone(
                new CoordinateChangeVector(12, -1),
                new CoordinateChangeVector(31, -2),
                new CoordinateChangeVector(28, -1)
        );
        Coordinate2D intersection = other.findPointOfIntersection(underTest);
        assertEquals(6.2, intersection.getX(), 0.0001);
        assertEquals(19.4, intersection.getY(), 0.0001);
    }

}