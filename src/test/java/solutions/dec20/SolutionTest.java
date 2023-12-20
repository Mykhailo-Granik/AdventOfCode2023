package solutions.dec20;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    public void shouldCalculateProductOfSignalOccurrences() {
        List<String> input = List.of(
                "broadcaster -> a, b, c",
                "%a -> b",
                "%b -> c",
                "%c -> inv",
                "&inv -> a"
        );
        Solution underTest = new Solution();
        assertEquals(32000000L, underTest.calculateProductOfSignalOccurrences(input));
    }

}