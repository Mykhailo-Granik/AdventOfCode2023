package solutions.dec6;

public class RaceRecordIgnoringSpacesParser {

    public RaceRecord parse(String timeRecord, String distanceRecord) {
        return new RaceRecord(
                parseValue(timeRecord),
                parseValue(distanceRecord)
        );
    }

    private long parseValue(String record) {
        return Long.parseLong(
                record.replaceAll("\\s+", "")
                        .split(":")[1]
        );
    }
}
