package solutions.dec11;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SumOfDistancesBetweenGalaxiesTest {

    @Test
    public void shouldCalculateTheSum() {
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
        assertEquals(374, new SumOfDistancesBetweenGalaxies().calculate(image));
    }

}