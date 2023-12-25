package solutions.dec25;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class NetworkTest {

    @Test
    public void shouldBuildNetwork() {
        Network network = new Network(
                List.of(
                        "a: b c",
                        "b: d"
                )
        );
        assertEqualsIgnoringOrder(List.of("b", "c"), network.neighbours("a"));
        assertEqualsIgnoringOrder(List.of("a", "d"), network.neighbours("b"));
        assertEqualsIgnoringOrder(List.of("a"), network.neighbours("c"));
        assertEqualsIgnoringOrder(List.of("b"), network.neighbours("d"));
    }

    private <T> void assertEqualsIgnoringOrder(List<T> expected, List<T> actual) {
        assertEquals(expected.size(), actual.size());
        assertTrue(expected.containsAll(actual));
    }

    @Test
    public void shouldFindBridge() {
        Network network = new Network(
                List.of(
                        "a: b",
                        "b: c d",
                        "c: d"
                )
        );
        Connection connection = network.findBridge(Collections.emptyList());
        assertEquals(Set.of("a", "b"), Set.of(connection.getEnd1(), connection.getEnd2()));
    }

    @Test
    public void shouldFindBridgeIgnoringEdge() {
        Network network = new Network(
                List.of(
                        "a: b c e",
                        "b: c",
                        "c: d",
                        "d: e f",
                        "e: f"
                )
        );
        Connection connection = network.findBridge(List.of(new Connection("a", "e")));
        assertEquals(Set.of("c", "d"), Set.of(connection.getEnd1(), connection.getEnd2()));
    }

    @Test
    public void shouldReturnSizesOfComponentsIgnoringEdges() {
        Network network = new Network(
                List.of(
                        "a: b c e",
                        "b: c",
                        "c: d",
                        "d: e f",
                        "e: f",
                        "f: g"
                )
        );
        assertEqualsIgnoringOrder(
                List.of(3, 4),
                network.sizesOfComponentsIgnoringEdges(List.of(new Connection("a", "e"), new Connection("c", "d")))
        );
    }

}