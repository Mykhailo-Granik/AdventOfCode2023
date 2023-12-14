package solutions.dec14;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PlatformTiltTest {

    @Test
    public void shouldTiltNorthAGridWithEmptySpacesOnly() {
        Platform platform = new Platform(
                List.of(
                        "...",
                        "...",
                        "..."
                )
        );
        assertEquals(platform, new PlatformTilt().tiltNorth(platform));
    }

    @Test
    public void shouldTiltNorthAGridWithImmovableRocks() {
        Platform platform = new Platform(
                List.of(
                        "###",
                        "...",
                        "###"
                )
        );
        assertEquals(platform, new PlatformTilt().tiltNorth(platform));
    }

    @Test
    public void shouldTiltNorthAGridWithMovableRocksThatCantMove() {
        Platform platform = new Platform(
                List.of(
                        "...",
                        "###",
                        "OOO"
                )
        );
        assertEquals(platform, new PlatformTilt().tiltNorth(platform));
    }

    @Test
    public void shouldTiltNorthAGridWhereMovableRocksMoveAllTheWayNorth() {
        Platform platform = new Platform(
                List.of(
                        "...",
                        "OOO",
                        "O.."
                )
        );
        Platform expectedPlatform = new Platform(
                List.of(
                        "OOO",
                        "O..",
                        "..."
                )
        );
        assertEquals(expectedPlatform, new PlatformTilt().tiltNorth(platform));
    }

    @Test
    public void shouldTiltNorthAGridWhereMovableRocksCanBeStoppedByImmovableRocks() {
        Platform platform = new Platform(
                List.of(
                        "O....#....",
                        "O.OO#....#",
                        ".....##...",
                        "OO.#O....O",
                        ".O.....O#.",
                        "O.#..O.#.#",
                        "..O..#O..O",
                        ".......O..",
                        "#....###..",
                        "#OO..#...."
                )
        );
        Platform expectedPlatform = new Platform(
                List.of(
                        "OOOO.#.O..",
                        "OO..#....#",
                        "OO..O##..O",
                        "O..#.OO...",
                        "........#.",
                        "..#....#.#",
                        "..O..#.O.O",
                        "..O.......",
                        "#....###..",
                        "#....#...."
                )
        );
        assertEquals(expectedPlatform, new PlatformTilt().tiltNorth(platform));
    }

    @Test
    public void shouldTiltWestAGridWhereMovableRocksCanBeStoppedByImmovableRocks() {
        Platform platform = new Platform(
                List.of(
                        "OOOO.#.O..",
                        "OO..#....#",
                        "OO..O##..O",
                        "O..#.OO...",
                        "........#.",
                        "..#....#.#",
                        "..O..#.O.O",
                        "..O.......",
                        "#....###..",
                        "#....#...."
                )
        );
        Platform expected = new Platform(
                List.of(
                        "OOOO.#O...",
                        "OO..#....#",
                        "OOO..##O..",
                        "O..#OO....",
                        "........#.",
                        "..#....#.#",
                        "O....#OO..",
                        "O.........",
                        "#....###..",
                        "#....#...."
                )
        );
        assertEquals(expected, new PlatformTilt().tiltWest(platform));
    }

    @Test
    public void shouldTiltSouth() {
        Platform platform = new Platform(
                List.of(
                        "OOOO.#O...",
                        "OO..#....#",
                        "OOO..##O..",
                        "O..#OO....",
                        "........#.",
                        "..#....#.#",
                        "O....#OO..",
                        "O.........",
                        "#....###..",
                        "#....#...."
                )
        );
        Platform expected = new Platform(
                List.of(
                        ".....#....",
                        "....#.O..#",
                        "O..O.##...",
                        "O.O#......",
                        "O.O....O#.",
                        "O.#..O.#.#",
                        "O....#....",
                        "OO....OO..",
                        "#O...###..",
                        "#O..O#...."
                )
        );
        assertEquals(expected, new PlatformTilt().tiltSouth(platform));
    }

    @Test
    public void shouldTiltEast() {
        Platform platform = new Platform(
                List.of(
                        ".....#....",
                        "....#.O..#",
                        "O..O.##...",
                        "O.O#......",
                        "O.O....O#.",
                        "O.#..O.#.#",
                        "O....#....",
                        "OO....OO..",
                        "#O...###..",
                        "#O..O#...."
                )
        );
        Platform expected = new Platform(
                List.of(
                        ".....#....",
                        "....#...O#",
                        "...OO##...",
                        ".OO#......",
                        ".....OOO#.",
                        ".O#...O#.#",
                        "....O#....",
                        "......OOOO",
                        "#...O###..",
                        "#..OO#...."
                )
        );
        assertEquals(expected, new PlatformTilt().tiltEast(platform));
    }

}