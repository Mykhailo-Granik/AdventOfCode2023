package solutions.dec22;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BricksToDisintegrateCalculatorTest {

    @Test
    public void shouldCalculateHowManyBricksCanBeDisintegrated() {
        List<Brick> bricks = List.of(
                new Brick(
                        new Point3D(1, 0, 1),
                        new Point3D(1, 2, 1)
                ),
                new Brick(
                        new Point3D(0, 0, 2),
                        new Point3D(2, 0, 2)
                ),
                new Brick(
                        new Point3D(0, 2, 3),
                        new Point3D(2, 2, 3)
                ),
                new Brick(
                        new Point3D(0, 0, 4),
                        new Point3D(0, 2, 4)
                ),
                new Brick(
                        new Point3D(2, 0, 5),
                        new Point3D(2, 2, 5)
                ),
                new Brick(
                        new Point3D(0, 1, 6),
                        new Point3D(2, 1, 6)
                ),
                new Brick(
                        new Point3D(1, 1, 8),
                        new Point3D(1, 1, 9)
                )
        );
        var underTest = new BricksToDisintegrateCalculator(bricks);
        assertEquals(5, underTest.calculate());
    }

    @Test
    public void shouldCalculateTotalAmountOfFails() {
        List<Brick> bricks = List.of(
                new Brick(
                        new Point3D(1, 0, 1),
                        new Point3D(1, 2, 1)
                ),
                new Brick(
                        new Point3D(0, 0, 2),
                        new Point3D(2, 0, 2)
                ),
                new Brick(
                        new Point3D(0, 2, 3),
                        new Point3D(2, 2, 3)
                ),
                new Brick(
                        new Point3D(0, 0, 4),
                        new Point3D(0, 2, 4)
                ),
                new Brick(
                        new Point3D(2, 0, 5),
                        new Point3D(2, 2, 5)
                ),
                new Brick(
                        new Point3D(0, 1, 6),
                        new Point3D(2, 1, 6)
                ),
                new Brick(
                        new Point3D(1, 1, 8),
                        new Point3D(1, 1, 9)
                )
        );
        var underTest = new BricksToDisintegrateCalculator(bricks);
        assertEquals(7, underTest.calculateTotalAmountOfFalls());
    }

    @Test
    public void shouldCalculateTheAnswerForBricksThatAreOnTopOfEachOther() {
        List<Brick> bricks = List.of(
                new Brick(
                        new Point3D(1, 0, 5),
                        new Point3D(1, 0, 5)
                ),
                new Brick(
                        new Point3D(1, 0, 1),
                        new Point3D(1, 0, 1)
                ),
                new Brick(
                        new Point3D(1, 0, 2),
                        new Point3D(1, 0, 2)
                )
        );
        var underTest = new BricksToDisintegrateCalculator(bricks);
        assertEquals(1, underTest.calculate());
    }

    @Test
    public void shouldCalculateTheAnswerWhenBricksDoNotIntersect() {
        List<Brick> bricks = List.of(
                new Brick(
                        new Point3D(1, 0, 5),
                        new Point3D(1, 0, 5)
                ),
                new Brick(
                        new Point3D(5, 5, 1),
                        new Point3D(5, 5, 1)
                ),
                new Brick(
                        new Point3D(2, 2, 2),
                        new Point3D(2, 2, 2)
                )
        );
        var underTest = new BricksToDisintegrateCalculator(bricks);
        assertEquals(3, underTest.calculate());
    }

}