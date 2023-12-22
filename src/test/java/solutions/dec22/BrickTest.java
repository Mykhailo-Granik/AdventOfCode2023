package solutions.dec22;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BrickTest {

    @Test
    public void shouldCreateProjectionForBrickWithDifferentXs() {
        Brick underTest = new Brick(
                new Point3D(0, 0, 2),
                new Point3D(2, 0, 2)
        );
        assertEquals(
                new Rectangle2D(new Point2D(0, 0), new Point2D(3, 1)),
                underTest.projectionOnXY()
        );
    }

    @Test
    public void shouldCreateProjectionForBrickWithDifferentYs() {
        Brick underTest = new Brick(
                new Point3D(1, 0, 1),
                new Point3D(1, 2, 1)
        );
        assertEquals(
                new Rectangle2D(new Point2D(1, 0), new Point2D(2, 3)),
                underTest.projectionOnXY()
        );
    }

    @Test
    public void shouldCreateProjectionForBrickWithDifferentZs() {
        Brick underTest = new Brick(
                new Point3D(1, 1, 8),
                new Point3D(1, 1, 9)
        );
        assertEquals(
                new Rectangle2D(new Point2D(1, 1), new Point2D(2, 2)),
                underTest.projectionOnXY()
        );
    }

}