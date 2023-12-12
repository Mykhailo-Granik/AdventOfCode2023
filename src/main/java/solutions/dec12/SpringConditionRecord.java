package solutions.dec12;

import java.util.List;
import java.util.Objects;

public class SpringConditionRecord {

    private final String record;
    private final List<Integer> groupsOfDamagedSprings;
    private long[][][] cache;
    private boolean[][][] numberOfPossibleArrangementsCalculated;

    public SpringConditionRecord(String record, List<Integer> groupsOfDamagedSprings) {
        this.record = record;
        this.groupsOfDamagedSprings = groupsOfDamagedSprings;
    }

    public String getRecord() {
        return record;
    }

    public List<Integer> getGroupsOfDamagedSprings() {
        return groupsOfDamagedSprings;
    }

    public long calculateNumberOfPossibleArrangements() {
        numberOfPossibleArrangementsCalculated = new boolean[record.length()][groupsOfDamagedSprings.size() + 1][record.length() + 1];
        cache = new long[record.length()][groupsOfDamagedSprings.size() + 1][record.length() + 1];
        return calculateNumberOfPossibleArrangements(0, 0, 0);
    }

    private long calculateNumberOfPossibleArrangements(int recordIndex, int groupsConsidered, int brokenSpringsInARow) {
        if (recordIndex == record.length()) {
            if (groupsConsidered == groupsOfDamagedSprings.size()) {
                if (brokenSpringsInARow == 0) {
                    return 1;
                }
                return 0;
            }
            if (groupsConsidered + 1 == groupsOfDamagedSprings.size()) {
                if (brokenSpringsInARow == groupsOfDamagedSprings.get(groupsConsidered)) {
                    return 1;
                }
                return 0;
            }
            return 0;
        }
        if (numberOfPossibleArrangementsCalculated[recordIndex][groupsConsidered][brokenSpringsInARow]) {
            return cache[recordIndex][groupsConsidered][brokenSpringsInARow];
        }
        numberOfPossibleArrangementsCalculated[recordIndex][groupsConsidered][brokenSpringsInARow] = true;
        if (record.charAt(recordIndex) == '#') {
            cache[recordIndex][groupsConsidered][brokenSpringsInARow] = processBroken(recordIndex, groupsConsidered, brokenSpringsInARow);
        } else if (record.charAt(recordIndex) == '.') {
            cache[recordIndex][groupsConsidered][brokenSpringsInARow] = processFunctional(recordIndex, groupsConsidered, brokenSpringsInARow);
        } else {
            cache[recordIndex][groupsConsidered][brokenSpringsInARow] = processBroken(recordIndex, groupsConsidered, brokenSpringsInARow)
                    + processFunctional(recordIndex, groupsConsidered, brokenSpringsInARow);
        }
        return cache[recordIndex][groupsConsidered][brokenSpringsInARow];
    }

    private long processFunctional(int recordIndex, int groupsConsidered, int brokenSpringsInARow) {
        if (brokenSpringsInARow == 0) {
            return calculateNumberOfPossibleArrangements(recordIndex + 1, groupsConsidered, brokenSpringsInARow);
        } else {
            if ((groupsConsidered < groupsOfDamagedSprings.size()) && (brokenSpringsInARow == groupsOfDamagedSprings.get(groupsConsidered))) {
                return calculateNumberOfPossibleArrangements(recordIndex + 1, groupsConsidered + 1, 0);
            }
            return 0;
        }
    }

    private long processBroken(int recordIndex, int groupsConsidered, int brokenSpringsInARow) {
        return calculateNumberOfPossibleArrangements(recordIndex + 1, groupsConsidered, brokenSpringsInARow + 1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SpringConditionRecord that = (SpringConditionRecord) o;
        return Objects.equals(record, that.record) && Objects.equals(groupsOfDamagedSprings, that.groupsOfDamagedSprings);
    }

    @Override
    public int hashCode() {
        return Objects.hash(record, groupsOfDamagedSprings);
    }

    @Override
    public String toString() {
        return "SpringConditionRecord{" +
                "record='" + record + '\'' +
                ", groupsOfDamagedSprings=" + groupsOfDamagedSprings +
                '}';
    }
}
