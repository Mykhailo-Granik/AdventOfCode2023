package solutions.dec24;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class IntersectionCalculatorTest {

    @Test
    public void shouldCalculateNumberOfIntersections() {

        List<Hailstone> hailstones = List.of(
                new Hailstone(
                        new CoordinateChangeVector(19, -2),
                        new CoordinateChangeVector(13, 1),
                        new CoordinateChangeVector(30, -2)
                ),
                new Hailstone(
                        new CoordinateChangeVector(18, -1),
                        new CoordinateChangeVector(19, -1),
                        new CoordinateChangeVector(22, -2)
                ),
                new Hailstone(
                        new CoordinateChangeVector(20, -2),
                        new CoordinateChangeVector(25, -2),
                        new CoordinateChangeVector(34, -4)
                ),
                new Hailstone(
                        new CoordinateChangeVector(12, -1),
                        new CoordinateChangeVector(31, -2),
                        new CoordinateChangeVector(28, -1)
                ),
                new Hailstone(
                        new CoordinateChangeVector(20, 1),
                        new CoordinateChangeVector(19, -5),
                        new CoordinateChangeVector(15, -3)
                )
        );
        IntersectionCalculator underTest = new IntersectionCalculator(hailstones, 7, 27);
        assertEquals(2, underTest.calculateNumberOfIntersections());

    }

}