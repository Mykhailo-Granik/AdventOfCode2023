package solutions.dec3;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Solution3Dec1Test {

    @Test
    public void shouldReturnZeroSumWhenNumbersDoNotHaveNeighbors() {
        Solution3Dec1 underTest = new Solution3Dec1();
        assertEquals(0,
                underTest.findSumOfNumbersWithNeighbors(
                        List.of("123..456..")
                )
        );
    }

    @Test
    public void shouldReturnSumOfNumbersWithNeighbors() {
        Solution3Dec1 underTest = new Solution3Dec1();
        assertEquals(123 + 456,
                underTest.findSumOfNumbersWithNeighbors(
                        List.of("123ab456..")
                )
        );
    }

    @Test
    public void shouldReturnCorrectSumForManyLines() {
        Solution3Dec1 underTest = new Solution3Dec1();
        assertEquals(4361,
                underTest.findSumOfNumbersWithNeighbors(
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
                )
        );
    }

}