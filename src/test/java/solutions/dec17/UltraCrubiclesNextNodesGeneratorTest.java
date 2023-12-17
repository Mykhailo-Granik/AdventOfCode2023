package solutions.dec17;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UltraCrubiclesNextNodesGeneratorTest {

    @Test
    public void nextNodesShouldReturnSameDirectionAndTwoRotationsWhenPossible() {
        GraphNode graphNode = new GraphNode(1, 1, Direction.UP, 4);
        var underTest = new UltraCrubiclesNextNodesGenerator(5, 5);
        assertEquals(
                Set.of(
                        new GraphNode(0, 1, Direction.UP, 5),
                        new GraphNode(1, 0, Direction.LEFT, 1),
                        new GraphNode(1, 2, Direction.RIGHT, 1)
                ),
                underTest.nextNodes(graphNode)
        );
    }

    @Test
    public void shouldNotIncludeGraphNodesOutsideOfTheGrid() {
        GraphNode graphNode = new GraphNode(0, 0, Direction.DOWN, 4);
        var underTest = new UltraCrubiclesNextNodesGenerator(1, 2);
        assertEquals(
                Set.of(
                        new GraphNode(0, 1, Direction.RIGHT, 1)
                ),
                underTest.nextNodes(graphNode)
        );
    }

    @Test
    public void shouldNotAllowToRotateWhenLessThenThreeStepsTaken() {
        GraphNode graphNode = new GraphNode(0, 0, Direction.DOWN, 2);
        var underTest = new UltraCrubiclesNextNodesGenerator(5, 5);
        assertEquals(
                Set.of(
                        new GraphNode(1, 0, Direction.DOWN, 3)
                ),
                underTest.nextNodes(graphNode)
        );
    }

    @Test
    public void shouldNotAllowToMoveMoreThanTenStepsInTheSameDirection() {
        GraphNode graphNode = new GraphNode(1, 1, Direction.DOWN, 10);
        var underTest = new UltraCrubiclesNextNodesGenerator(5, 5);
        assertEquals(
                Set.of(
                        new GraphNode(1, 0, Direction.LEFT, 1),
                        new GraphNode(1, 2, Direction.RIGHT, 1)
                ),
                underTest.nextNodes(graphNode)
        );
    }

}