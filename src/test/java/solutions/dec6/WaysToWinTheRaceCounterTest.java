package solutions.dec6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WaysToWinTheRaceCounterTest {

    @Test
    public void shouldReturnZeroIfNoWayToWin() {
        WaysToWinTheRaceCounter underTest = new WaysToWinTheRaceCounter(new RaceRecord(1, 2));
        assertEquals(0, underTest.count());
    }

    @Test
    public void shouldReturnNumberOfWaysToWinWhenItIsPossible() {
        WaysToWinTheRaceCounter underTest = new WaysToWinTheRaceCounter(new RaceRecord(7, 9));
        assertEquals(4, underTest.count());
    }

}