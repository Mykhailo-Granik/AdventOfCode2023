package solutions.dec10;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static solutions.dec10.Pipe.HORIZONTAL;
import static solutions.dec10.Pipe.VERTICAL;

class PipeFactoryTest {

    @Test
    public void shouldCreateVerticalPipe() {
        assertEquals(VERTICAL, PipeFactory.createPipe('|'));
    }

    @Test
    public void shouldCreateHorizontalPipe() {
        assertEquals(HORIZONTAL, PipeFactory.createPipe('-'));
    }

    @Test
    public void shouldCreateBendDownRightPipe() {
        assertEquals(Pipe.BEND_DOWN_RIGHT, PipeFactory.createPipe('L'));
    }

    @Test
    public void shouldCreateBendDownLeftPipe() {
        assertEquals(Pipe.BEND_DOWN_LEFT, PipeFactory.createPipe('J'));
    }

    @Test
    public void shouldCreateBendUpLeftPipe() {
        assertEquals(Pipe.BEND_UP_LEFT, PipeFactory.createPipe('7'));
    }

    @Test
    public void shouldCreateBendUpRightPipe() {
        assertEquals(Pipe.BEND_UP_RIGHT, PipeFactory.createPipe('F'));
    }

    @Test
    public void shouldCreateGround() {
        assertEquals(Pipe.GROUND, PipeFactory.createPipe('.'));
    }

    @Test
    public void shouldThrowExceptionForUnknownPipe() {
        assertThrows(IllegalArgumentException.class, () -> PipeFactory.createPipe('X'));
    }

}