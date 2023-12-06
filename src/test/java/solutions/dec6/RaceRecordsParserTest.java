package solutions.dec6;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RaceRecordsParserTest {

    @Test
    public void shouldCorrectlyParseSingleRace() {
        RaceRecordsParser underTest = new RaceRecordsParser();
        List<RaceRecord> raceRecords = underTest.parse(
                "Time:        51",
                "Distance:   222"
        );
        assertEquals(new RaceRecord(51, 222), raceRecords.get(0));
    }

    @Test
    public void shouldCorrectlyParseMultipleRaces() {
        RaceRecordsParser underTest = new RaceRecordsParser();
        List<RaceRecord> raceRecords = underTest.parse(
                "Time:        51     92     68     90",
                "Distance:   222   2031   1126   1225"
        );
        assertEquals(
                List.of(
                        new RaceRecord(51, 222),
                        new RaceRecord(92, 2031),
                        new RaceRecord(68, 1126),
                        new RaceRecord(90, 1225)
                ),
                raceRecords
        );
    }

}