package solutions.dec6;

import java.util.Objects;

public class RaceRecord {

    private final long time;
    private final long bestDistance;

    public RaceRecord(long time, long bestDistance) {
        this.time = time;
        this.bestDistance = bestDistance;
    }

    public long getTime() {
        return time;
    }

    public long getBestDistance() {
        return bestDistance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RaceRecord raceRecord = (RaceRecord) o;
        return time == raceRecord.time && bestDistance == raceRecord.bestDistance;
    }

    @Override
    public int hashCode() {
        return Objects.hash(time, bestDistance);
    }
}
