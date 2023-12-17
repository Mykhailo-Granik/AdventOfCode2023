package solutions.dec16;

import org.junit.jupiter.api.Test;
import solutions.dec17.Direction;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BeamTest {

    @Test
    public void shouldMove() {
        assertEquals(new Beam(0, 1, Direction.UP), new Beam(1, 1, Direction.UP).move());
        assertEquals(new Beam(1, 0, Direction.LEFT), new Beam(1, 1, Direction.LEFT).move());
        assertEquals(new Beam(1, 2, Direction.RIGHT), new Beam(1, 1, Direction.RIGHT).move());
        assertEquals(new Beam(2, 1, Direction.DOWN), new Beam(1, 1, Direction.DOWN).move());
    }

}