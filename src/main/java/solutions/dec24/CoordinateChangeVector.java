package solutions.dec24;

import java.util.Objects;

public class CoordinateChangeVector {

    private final long start;
    private final long delta;

    public CoordinateChangeVector(long start, long delta) {
        this.start = start;
        this.delta = delta;
    }

    public long getStart() {
        return start;
    }

    public long getDelta() {
        return delta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CoordinateChangeVector that = (CoordinateChangeVector) o;
        return start == that.start && delta == that.delta;
    }

    @Override
    public int hashCode() {
        return Objects.hash(start, delta);
    }

    @Override
    public String toString() {
        return "CoordinateChangeVector{" +
                "start=" + start +
                ", delta=" + delta +
                '}';
    }
}
