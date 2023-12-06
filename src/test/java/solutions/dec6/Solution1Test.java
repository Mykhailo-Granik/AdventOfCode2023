package solutions.dec6;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Solution1Test {

    @Test
    public void shouldCalculateProductOfWaysToWinForEachRace() {
        List<String> raceRecords = List.of(
                "Time:      7  15   30",
                "Distance:  9  40  200"
        );
        assertEquals(288, new Solution1().calculateProductOfWaysToWinForEachRace(raceRecords));
    }

}