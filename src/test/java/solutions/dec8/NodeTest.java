package solutions.dec8;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class NodeTest {

    @Test
    public void shouldProcessRequestToGoLeft() {
        String left = "LEFT";
        Node node = new Node("A", left, "RIGHT");
        assertEquals(left, node.go('L'));
    }

    @Test
    public void shouldProcessRequestToGoRight() {
        String right = "RIGHT";
        Node node = new Node("A", "LEFT", right);
        assertEquals(right, node.go('R'));
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionWhenDirectionIsNotLorR() {
        Node node = new Node("A", "LEFT", "RIGHT");
        assertThrows(IllegalArgumentException.class, () -> node.go('X'));
    }

}