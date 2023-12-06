package solutions.dec6;

import java.util.List;

public class Solution1 {


    public int calculateProductOfWaysToWinForEachRace(List<String> raceRecords) {
        List<RaceRecord> records = new RaceRecordsParser().parse(raceRecords.get(0), raceRecords.get(1));
        return records.stream()
                .mapToInt(raceRecord -> new WaysToWinTheRaceCounter(raceRecord).count())
                .reduce(1, (a, b) -> a * b);
    }
}
