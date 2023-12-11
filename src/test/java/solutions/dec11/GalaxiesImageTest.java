package solutions.dec11;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GalaxiesImageTest {

    @Test
    public void shouldExpandImageVertically() {
        GalaxiesImage image = new GalaxiesImage(
                List.of(
                        "##",
                        ".."
                ),
                2
        );
        GalaxiesImage expected = new GalaxiesImage(
                List.of(
                        "##",
                        "..",
                        ".."
                ),
                2
        );
        assertEquals(expected, image.expand());
    }

    @Test
    public void shouldExpandHorizontally() {
        GalaxiesImage image = new GalaxiesImage(
                List.of(
                        ".#",
                        ".#"
                ),
                2
        );
        GalaxiesImage expected = new GalaxiesImage(
                List.of(
                        "..#",
                        "..#"
                ),
                2
        );
        assertEquals(expected, image.expand());
    }

    @Test
    public void shouldExpandBothHorizontallyAndVertically() {
        GalaxiesImage image = new GalaxiesImage(
                List.of(
                        "...#......",
                        ".......#..",
                        "#.........",
                        "..........",
                        "......#...",
                        ".#........",
                        ".........#",
                        "..........",
                        ".......#..",
                        "#...#....."
                ),
                2
        );
        GalaxiesImage expected = new GalaxiesImage(
                List.of(
                        "....#........",
                        ".........#...",
                        "#............",
                        ".............",
                        ".............",
                        "........#....",
                        ".#...........",
                        "............#",
                        ".............",
                        ".............",
                        ".........#...",
                        "#....#......."
                ),
                2
        );
        assertEquals(expected, image.expand());
    }

    @Test
    public void shouldFindGalaxies() {
        GalaxiesImage image = new GalaxiesImage(
                List.of(
                        "#.",
                        ".#"
                ),
                2
        );
        assertEquals(
                List.of(
                        new Galaxy(0, 0),
                        new Galaxy(1, 1)
                ),
                image.findGalaxies()
        );
    }

    @Test
    public void shouldFindGalaxiesConsideringExpansion() {
        GalaxiesImage image = new GalaxiesImage(
                List.of(
                        "....",
                        "..#.",
                        "...#"
                ),
                2
        );
        assertEquals(
                List.of(
                        new Galaxy(2, 4),
                        new Galaxy(3, 5)
                ),
                image.findGalaxiesConsideringExpansion()
        );
    }

}