package solutions.dec14;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class PlatformTilt {

    public Platform tiltNorth(Platform platform) {
        return tilt(platform, Direction.NORTH);
    }

    private Platform tilt(Platform platform, Direction direction) {
        List<StringBuilder> grid = emptyGrid(platform.getGrid().size(), platform.getGrid().get(0).length());
        for (int row = 0; row < platform.getGrid().size(); row++) {
            for (int column = 0; column < platform.getGrid().get(row).length(); column++) {
                if (platform.getGrid().get(row).charAt(column) == '#') {
                    grid.get(row).setCharAt(column, '#');
                    continue;
                }
                if (platform.getGrid().get(row).charAt(column) == '.') {
                    continue;
                }
                Location border = borderLocation(platform, direction, row, column);
                int movableBlocksTillBorder = movableBlocksTillBorder(platform, direction, row, column, border.row, border.column);
                int newRow = border.row - direction.getDeltaRow() * movableBlocksTillBorder;
                int newColumn = border.column - direction.getDeltaColumn() * movableBlocksTillBorder;
                grid.get(newRow).setCharAt(newColumn, 'O');
            }
        }
        return new Platform(grid.stream().map(StringBuilder::toString).collect(toList()));
    }

    private Location borderLocation(Platform platform, Direction direction, int row, int column) {
        int borderRow = row;
        int borderColumn = column;
        while ((borderRow >= 0) && (borderRow < platform.getGrid().size()) && (borderColumn >= 0) && (borderColumn < platform.getGrid().get(row).length())) {
            if (platform.getGrid().get(borderRow).charAt(borderColumn) == '#') {
                break;
            }
            borderRow += direction.getDeltaRow();
            borderColumn += direction.getDeltaColumn();
        }
        return new Location(borderRow, borderColumn);
    }

    private int movableBlocksTillBorder(Platform platform, Direction direction, int row, int column, int borderRow, int borderColumn) {
        int movableBlocksTillBorder = 0;
        while ((row != borderRow) || (column != borderColumn)) {
            if (platform.getGrid().get(row).charAt(column) == 'O') {
                movableBlocksTillBorder++;
            }
            row += direction.getDeltaRow();
            column += direction.getDeltaColumn();
        }
        return movableBlocksTillBorder;
    }

    private List<StringBuilder> emptyGrid(int rows, int columns) {
        return IntStream.range(0, rows)
                .mapToObj(row -> emptyRow(columns))
                .collect(Collectors.toList());
    }

    private StringBuilder emptyRow(int columns) {
        StringBuilder row = new StringBuilder();
        row.append(".".repeat(columns));
        return row;
    }

    public Platform tiltWest(Platform platform) {
        return tilt(platform, Direction.WEST);
    }

    public Platform tiltSouth(Platform platform) {
        return tilt(platform, Direction.SOUTH);
    }

    public Platform tiltEast(Platform platform) {
        return tilt(platform, Direction.EAST);
    }

    private static class Location {
        private final int row;
        private final int column;

        public Location(int row, int column) {
            this.row = row;
            this.column = column;
        }
    }

    private enum Direction {
        NORTH(-1, 0),
        SOUTH(1, 0),
        EAST(0, 1),
        WEST(0, -1);

        private final int deltaRow;
        private final int deltaColumn;

        Direction(int deltaRow, int deltaColumn) {
            this.deltaRow = deltaRow;
            this.deltaColumn = deltaColumn;
        }

        public int getDeltaRow() {
            return deltaRow;
        }

        public int getDeltaColumn() {
            return deltaColumn;
        }
    }

}
