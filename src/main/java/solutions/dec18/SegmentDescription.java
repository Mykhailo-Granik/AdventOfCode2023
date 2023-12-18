package solutions.dec18;

import java.util.Objects;

public class SegmentDescription {

    private final int length;
    private final Direction direction;
    private final String color;

    public SegmentDescription(int length, Direction direction, String color) {
        this.length = length;
        this.direction = direction;
        this.color = color;
    }

    public SegmentDescription(int length, Direction direction) {
        this.length = length;
        this.direction = direction;
        this.color = null;
    }

    public int getLength() {
        return length;
    }

    public Direction getDirection() {
        return direction;
    }

    public String getColor() {
        return color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SegmentDescription that = (SegmentDescription) o;
        return length == that.length && direction == that.direction && Objects.equals(color, that.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(length, direction, color);
    }

    @Override
    public String toString() {
        return "SegmentDescription{" +
                "length=" + length +
                ", direction=" + direction +
                ", color='" + color + '\'' +
                '}';
    }
}
