package solutions.dec2;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Solution2Dec2Test {

    @Test
    public void shouldReturnZeroForEmptyList() {
        Solution2Dec2 underTest = new Solution2Dec2();
        int result = underTest.sumOfPowers(List.of());
        assertEquals(0, result);
    }

    @Test
    public void shouldReturnPowerOfSingleSetOfCubes() {
        Solution2Dec2 underTest = new Solution2Dec2();
        int result = underTest.sumOfPowers(List.of("Game 1: 1 red, 2 blue, 3 green"));
        assertEquals(6, result);
    }

    @Test
    public void shouldReturnPowerOfMultipleSetsOfCubes() {
        Solution2Dec2 underTest = new Solution2Dec2();
        int result = underTest.sumOfPowers(List.of("Game 1: 1 red, 2 blue, 3 green; 2 red, 3 blue, 1 green"));
        assertEquals(18, result);
    }

    @Test
    public void shouldReturnSumOfPowersOfMultipleGames() {
        Solution2Dec2 underTest = new Solution2Dec2();
        int result = underTest.sumOfPowers(List.of(
                        "Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green",
                        "Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue",
                        "Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red",
                        "Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red",
                        "Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green"
                )
        );
        assertEquals(2286, result);
    }

}