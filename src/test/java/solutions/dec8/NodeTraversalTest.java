package solutions.dec8;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NodeTraversalTest {

    @Test
    public void shouldReturnNumberOfStepsFromStartToFinishIfThereIsNoNeedToRepeatTheCommands() {
        NodeTraversal underTest = new NodeTraversal(
                List.of(
                        new Node("AAA", "BBB", "CCC"),
                        new Node("CCC", "ZZZ", "GGG"),
                        new Node("ZZZ", "ZZZ", "ZZZ")
                ),
                "RL"
        );
        assertEquals(2, underTest.getNumberOfStepsFromStartToFinish());
    }

    @Test
    public void shouldReturnNumberOfStepsFromStartToFinishIfThereIsNeedToRepeatTheCommands() {
        NodeTraversal underTest = new NodeTraversal(
                List.of(
                        new Node("AAA", "BBB", "BBB"),
                        new Node("BBB", "AAA", "ZZZ"),
                        new Node("ZZZ", "ZZZ", "ZZZ")
                ),
                "LLR"
        );
        assertEquals(6, underTest.getNumberOfStepsFromStartToFinish());
    }


}