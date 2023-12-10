package solutions.dec10;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static solutions.dec10.Direction.*;

class CoordinateTest {

    @Test
    public void shouldMoveDown() {
        Coordinate coordinate = new Coordinate(1, 2);
        assertEquals(new Coordinate(1, 3), coordinate.move(DOWN));
    }

    @Test
    public void shouldMoveUp() {
        Coordinate coordinate = new Coordinate(1, 2);
        assertEquals(new Coordinate(1, 1), coordinate.move(UP));
    }

    @Test
    public void shouldMoveLeft() {
        Coordinate coordinate = new Coordinate(1, 2);
        assertEquals(new Coordinate(0, 2), coordinate.move(LEFT));
    }

    @Test
    public void shouldMoveRight() {
        Coordinate coordinate = new Coordinate(1, 2);
        assertEquals(new Coordinate(2, 2), coordinate.move(RIGHT));
    }

}