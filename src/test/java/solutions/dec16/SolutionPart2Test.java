package solutions.dec16;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionPart2Test {

    @Test
    public void shouldCalculateMaxNumberOfEnergizedTiles() {
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
        assertEquals(51, new SolutionPart2().getMaxNumberOfEnergizedTiles(contraption));
    }

}