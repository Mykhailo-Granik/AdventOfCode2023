package solutions.dec19;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PartTest {

    @Test
    public void shouldReturnXParameter() {
        Part part = new Part(1, 2, 3, 4);
        assertEquals(1, part.getParameter("x"));
    }

    @Test
    public void shouldReturnMParameter() {
        Part part = new Part(1, 2, 3, 4);
        assertEquals(2, part.getParameter("m"));
    }

    @Test
    public void shouldReturnAParameter() {
        Part part = new Part(1, 2, 3, 4);
        assertEquals(3, part.getParameter("a"));
    }

    @Test
    public void shouldReturnSParameter() {
        Part part = new Part(1, 2, 3, 4);
        assertEquals(4, part.getParameter("s"));
    }

    @Test
    public void shouldThrowExceptionForUnknownParameter() {
        Part part = new Part(1, 2, 3, 4);
        assertThrows(IllegalArgumentException.class, () -> part.getParameter("unknown"));
    }

    @Test
    public void shouldCalculateTheScoreOfThePart() {
        Part part = new Part(1, 2, 3, 4);
        assertEquals(10, part.score());
    }

}