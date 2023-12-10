package solutions.dec10;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    public void shouldCalculateDistanceToFarthestTileForSimpleLoop() {
        Solution underTest = new Solution();
        assertEquals(4, underTest.calculateDistanceToFarthestTile(
                List.of(
                        ".....",
                        ".S-7.",
                        ".|.|.",
                        ".L-J.",
                        "....."
                )
        ));
    }

    @Test
    public void shouldFindDistanceForMoreComplexExample() {
        Solution underTest = new Solution();
        assertEquals(8, underTest.calculateDistanceToFarthestTile(
                        List.of(
                                "..F7.",
                                ".FJ|.",
                                "SJ.L7",
                                "|F--J",
                                "LJ..."
                        )
                )
        );
    }

}