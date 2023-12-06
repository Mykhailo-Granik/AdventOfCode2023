package solutions.dec3;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Solution3Dec2Test {

    @Test
    public void shouldReturnZeroWhenNoGears() {
        Solution3Dec2 underTest = new Solution3Dec2();
        assertEquals(0, underTest.findSumOfRatiosOfGears(
                List.of(".")
        ));
    }

    @Test
    public void shouldReturnSumOfRatiosOfGears() {
        Solution3Dec2 underTest = new Solution3Dec2();
        assertEquals(467835, underTest.findSumOfRatiosOfGears(
                List.of(
                        "467..114..",
                        "...*......",
                        "..35..633.",
                        "......#...",
                        "617*......",
                        ".....+.58.",
                        "..592.....",
                        "......755.",
                        "...$.*....",
                        ".664.598.."
                )
        ));
    }

}