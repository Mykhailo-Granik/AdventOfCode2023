package solutions.dec10;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FarthestTileTest {

    @Test
    public void shouldFindDistanceToFarthestTile() {
        Grid grid = new Grid(
                List.of(
                        ".....",
                        ".S-7.",
                        ".|.|.",
                        ".L-J.",
                        "....."
                )
        );
        assertEquals(4, new FarthestTile().findDistance(grid));
    }

}