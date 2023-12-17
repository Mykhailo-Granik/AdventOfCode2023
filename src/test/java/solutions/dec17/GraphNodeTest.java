package solutions.dec17;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GraphNodeTest {

    @Test
    public void nextNodesShouldReturnSameDirectionAndTwoRotations() {
        GraphNode graphNode = new GraphNode(1, 1, Direction.UP, 1);
        assertEquals(
                Set.of(
                        new GraphNode(0, 1, Direction.UP, 2),
                        new GraphNode(1, 0, Direction.LEFT, 1),
                        new GraphNode(1, 2, Direction.RIGHT, 1)
                ),
                graphNode.nextNodes()
        );
    }

}