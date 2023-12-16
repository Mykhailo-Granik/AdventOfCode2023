package solutions.dec16;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ContraptionTest {

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
        assertEquals(46, new Contraption(contraption, new Beam(0, 0, Direction.RIGHT)).getNumberOfEnergizedTiles());
    }

}