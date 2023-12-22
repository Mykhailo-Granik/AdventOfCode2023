package solutions.dec22;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Rectangle2DTest {

    @Test
    public void shouldTellRectangleDoNotIntersect() {
        Rectangle2D underTest = new Rectangle2D(
                new Point2D(0, 0),
                new Point2D(1, 1)
        );
        Rectangle2D other = new Rectangle2D(
                new Point2D(2, 2),
                new Point2D(3, 3)
        );
        assertFalse(underTest.intersects(other));
    }

    @Test
    public void shouldTellRectangleIntersect() {
        Rectangle2D underTest = new Rectangle2D(
                new Point2D(0, 0),
                new Point2D(1, 1)
        );
        Rectangle2D other = new Rectangle2D(
                new Point2D(0, 0),
                new Point2D(3, 3)
        );
        assertTrue(underTest.intersects(other));
    }

    @Test
    public void shouldTellRectanglesDoNotIntersectWhenTheyShareSide() {
        Rectangle2D underTest = new Rectangle2D(
                new Point2D(0, 0),
                new Point2D(1, 1)
        );
        Rectangle2D other = new Rectangle2D(
                new Point2D(1, 0),
                new Point2D(3, 3)
        );
        assertFalse(underTest.intersects(other));
    }

}