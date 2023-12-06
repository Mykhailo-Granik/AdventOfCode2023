package solutions.dec6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RaceRecordIgnoringSpacesParserTest {

    @Test
    public void shouldParseRaceRecordIgnoringSpaces() {
        RaceRecordIgnoringSpacesParser underTest = new RaceRecordIgnoringSpacesParser();
        RaceRecord raceRecord = underTest.parse("Time:      7  15   30",
                "Distance:  9  40  200");
        assertEquals(new RaceRecord(71530, 940200), raceRecord);
    }

}