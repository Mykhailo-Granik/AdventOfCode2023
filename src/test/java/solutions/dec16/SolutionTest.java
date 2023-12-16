package solutions.dec16;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    public void shouldCalculateTheNumberOfEnergizedTiles() {
        List<String> contraption = List.of(
                ".|...\\....",
                "|.-.\\.....",
                ".....|-...",
                "........|.",
                "..........",
                ".........\\",
                "..../.\\\\..",
                ".-.-/..|..",
                ".|....-|.\\",
                "..//.|...."
        );
        assertEquals(46, new Solution().getNumberOfEnergizedTiles(contraption));
    }

}