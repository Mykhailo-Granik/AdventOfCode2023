package solutions.dec16;

import solutions.dec17.Direction;

import java.util.Objects;

public class Beam {

    private final int row;
    private final int column;
    private final Direction direction;

    public Beam(int row, int column, Direction direction) {
        this.row = row;
        this.column = column;
        this.direction = direction;
    }

    public Beam move() {
        return new Beam(row + direction.getDeltaRow(), column + direction.getDeltaColumn(), direction);
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public Beam withDirection(Direction direction) {
        return new Beam(row, column, direction);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Beam beam = (Beam) o;
        return row == beam.row && column == beam.column && direction == beam.direction;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, column, direction);
    }

    public Direction getDirection() {
        return direction;
    }

    public boolean insideGrid(int rows, int columns) {
        return row >= 0 && row < rows && column >= 0 && column < columns;
    }
}
