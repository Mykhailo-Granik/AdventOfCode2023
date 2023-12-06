package solutions.dec3;

import java.util.List;
import java.util.Objects;

public class NumberInGrid {

    private final List<String> grid;
    private final int row;
    private final int startColumn;
    private final int endColumn;

    public NumberInGrid(List<String> grid, int row, int startColumn, int endColumn) {
        this.grid = grid;
        this.row = row;
        this.startColumn = startColumn;
        this.endColumn = endColumn;
    }

    public int getRow() {
        return row;
    }

    public int getStartColumn() {
        return startColumn;
    }

    public int getEndColumn() {
        return endColumn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NumberInGrid number = (NumberInGrid) o;
        return row == number.row && startColumn == number.startColumn && endColumn == number.endColumn && Objects.equals(grid, number.grid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(grid, row, startColumn, endColumn);
    }

    @Override
    public String toString() {
        return "Number{" +
                "grid=" + grid +
                ", row=" + row +
                ", startColumn=" + startColumn +
                ", endColumn=" + endColumn +
                '}';
    }

    public long getNumericalValue() {
        int res = 0;
        for (int i = startColumn; i < endColumn; i++) {
            res = res * 10 + grid.get(row).charAt(i) - '0';
        }
        return res;
    }

    public boolean hasNeighbouringCharacter() {
        return hasNeighborToTheLeft() || hasNeighborToTheRight() || hasNeighborAbove() || hasNeighborBelow();
    }

    private boolean hasNeighborBelow() {
        if (row < grid.size() - 1) {
            int firstColumnToConsider = Math.max(0, startColumn - 1);
            int lastColumnToConsider = Math.min(grid.get(row + 1).length(), endColumn + 1);
            for (int i = firstColumnToConsider; i < lastColumnToConsider; i++) {
                if (grid.get(row + 1).charAt(i) != '.') {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean hasNeighborAbove() {
        if (row > 0) {
            int firstColumnToConsider = Math.max(0, startColumn - 1);
            int lastColumnToConsider = Math.min(grid.get(row - 1).length(), endColumn + 1);
            for (int i = firstColumnToConsider; i < lastColumnToConsider; i++) {
                if (grid.get(row - 1).charAt(i) != '.') {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean hasNeighborToTheRight() {
        return endColumn < grid.get(row).length() && (grid.get(row).charAt(endColumn) != '.');
    }

    private boolean hasNeighborToTheLeft() {
        return (startColumn > 0) && (grid.get(row).charAt(startColumn - 1) != '.');
    }
}
