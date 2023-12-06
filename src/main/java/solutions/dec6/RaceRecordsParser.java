package solutions.dec6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RaceRecordsParser {
    public List<RaceRecord> parse(String timeRecord, String distanceRecord) {
        List<Integer> times = parseTime(timeRecord);
        List<Integer> distances = parseDistance(distanceRecord);
        List<RaceRecord> raceRecords = new ArrayList<>();
        for (int i = 0; i < times.size(); i++) {
            raceRecords.add(new RaceRecord(times.get(i), distances.get(i)));
        }
        return raceRecords;
    }

    private List<Integer> parseTime(String timeRecord) {
        return Arrays.stream(timeRecord.split("\\s+"))
                .skip(1)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private List<Integer> parseDistance(String distanceRecord) {
        return Arrays.stream(distanceRecord.split("\\s+"))
                .skip(1)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
