package solutions.dec19.range;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParameterRangeTest {

    @Test
    public void whenRangeHasValuesShouldReturnItsLength() {
        ParameterRange underTest = new ParameterRange("x", 1, 3);
        assertEquals(3, underTest.length());
    }

    @Test
    public void shouldReturnZeroWhenRangeHasNoValues() {
        ParameterRange underTest = new ParameterRange("x", 1, -2);
        assertEquals(0, underTest.length());
    }

    @Test
    public void shouldReturnNotEmpty() {
        ParameterRange underTest = new ParameterRange("x", 1, 3);
        assertFalse(underTest.isEmpty());
    }

    @Test
    public void shouldReturnEmpty() {
        ParameterRange underTest = new ParameterRange("x", 0, -2);
        assertTrue(underTest.isEmpty());
    }

}