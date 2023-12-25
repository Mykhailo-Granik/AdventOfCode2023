package solutions.dec25;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ConnectionTest {

    @Test
    public void shouldReturnOtherEndForEnd1() {
        Connection connection = new Connection("A", "B");
        assertEquals("B", connection.otherEnd("A"));
    }

    @Test
    public void shouldReturnOtherEndForEnd2() {
        Connection connection = new Connection("A", "B");
        assertEquals("A", connection.otherEnd("B"));
    }

    @Test
    public void shouldThrowExceptionForInvalidEnd() {
        Connection connection = new Connection("A", "B");
        assertThrows(IllegalArgumentException.class, () -> connection.otherEnd("C"));
    }

}