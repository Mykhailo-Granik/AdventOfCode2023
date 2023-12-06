package solutions.dec6;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Solution2Test {

    @Test
    public void shouldCalculateNumberOfWaysToWin() {
        List<String> raceRecords = List.of(
                "Time:      7  15   30",
                "Distance:  9  40  200"
        );
        assertEquals(71503, new Solution2().calculateNumberOfWaysToWin(raceRecords));
    }

}