package solutions.dec24;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    public void shouldCalculatePathsCollusions() {
        Solution solution = new Solution();
        List<String> hailstones = List.of(
                "19, 13, 30 @ -2,  1, -2",
                "18, 19, 22 @ -1, -1, -2",
                "20, 25, 34 @ -2, -2, -4",
                "12, 31, 28 @ -1, -2, -1",
                "20, 19, 15 @  1, -5, -3"
        );
        assertEquals(2, solution.calculatePathsCollisions(hailstones, 7L, 27L));
    }

}