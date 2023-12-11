package solutions.dec11;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    public void shouldCalculateSumOfDistancesBetweenGalaxies() {
        assertEquals(374, new Solution(2).calculateSumOfDistancesBetweenGalaxies(galaxiesImage()));
    }

    @Test
    public void shouldCalculateSumOfDistancesBetweenGalaxiesWithExpansionFactor10() {
        assertEquals(1030, new Solution(10).calculateSumOfDistancesBetweenGalaxies(galaxiesImage()));
    }

    @Test
    public void shouldCalculateSumOfDistancesBetweenGalaxiesWithExpansionFactor100() {
        assertEquals(8410, new Solution(100).calculateSumOfDistancesBetweenGalaxies(galaxiesImage()));
    }

    private List<String> galaxiesImage() {
        return List.of(
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
        );
    }

}