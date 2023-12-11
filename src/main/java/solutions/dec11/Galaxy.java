package solutions.dec11;

import java.util.Objects;

public class Galaxy {

    private final long row;
    private final long column;

    public Galaxy(long row, long column) {
        this.row = row;
        this.column = column;
    }

    public long getRow() {
        return row;
    }

    public long getColumn() {
        return column;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Galaxy galaxy = (Galaxy) o;
        return row == galaxy.row && column == galaxy.column;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, column);
    }

    @Override
    public String toString() {
        return "Galaxy{" +
                "row=" + row +
                ", column=" + column +
                '}';
    }

    public long distanceTo(Galaxy other) {
        return Math.abs(other.column - column) + Math.abs(row - other.row);
    }
}
