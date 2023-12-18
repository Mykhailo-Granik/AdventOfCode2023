package solutions.dec18;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DirectionTest {

    @Test
    public void shouldCreateUpDirectionFromString() {
        assertEquals(Direction.UP, Direction.fromString("U"));
    }

    @Test
    public void shouldCreateDownDirectionFromString() {
        assertEquals(Direction.DOWN, Direction.fromString("D"));
    }

    @Test
    public void shouldCreateLeftDirectionFromString() {
        assertEquals(Direction.LEFT, Direction.fromString("L"));
    }

    @Test
    public void shouldCreateRightDirectionFromString() {
        assertEquals(Direction.RIGHT, Direction.fromString("R"));
    }

    @Test
    public void shouldThrowExceptionWhenUnknownDirection() {
        assertThrows(IllegalArgumentException.class, () -> Direction.fromString("X"));
    }

    @Test
    public void shouldCreateRightDirectionFromDigitString() {
        assertEquals(Direction.RIGHT, Direction.fromDigitString("0"));
    }

    @Test
    public void shouldCreateDownDirectionFromDigitString() {
        assertEquals(Direction.DOWN, Direction.fromDigitString("1"));
    }

    @Test
    public void shouldCreateLeftDirectionFromDigitString() {
        assertEquals(Direction.LEFT, Direction.fromDigitString("2"));
    }

    @Test
    public void shouldCreateUpDirectionFromDigitString() {
        assertEquals(Direction.UP, Direction.fromDigitString("3"));
    }

    @Test
    public void shouldThrowExceptionWhenUnknownDigit() {
        assertThrows(IllegalArgumentException.class, () -> Direction.fromDigitString("4"));
    }

}