package solutions.dec21;

import java.util.List;

public class GridExplorer {

    private final List<String> grid;

    public GridExplorer(List<String> grid) {
        this.grid = grid;
    }

    public void explore() {
        System.out.println("size = " + grid.size() + "x" + grid.get(0).length());
        Cell startingCell = startingCell();
        System.out.println("startingCell = " + startingCell);
        System.out.println("hasWallOnBorder = " + hasWallOnBorder());
        System.out.println("hasWallsInRowOrColumnOfStart = " + hasWallsInRowOrColumnOfStart(startingCell));
    }

    private Cell startingCell() {
        for (int row = 0; row < grid.size(); row++) {
            String grid = this.grid.get(row);
            for (int col = 0; col < grid.length(); col++) {
                if (grid.charAt(col) == 'S') {
                    return new Cell(row, col);
                }
            }
        }
        throw new IllegalStateException("No starting cell found");
    }

    private boolean hasWallOnBorder() {
        for (int i = 0; i < grid.size(); ++i) {
            if (grid.get(i).charAt(0) == '#') {
                return true;
            }
            if (grid.get(i).charAt(grid.get(i).length() - 1) == '#') {
                return true;
            }
        }
        for (int i = 0; i < grid.get(0).length(); ++i) {
            if (grid.get(0).charAt(i) == '#') {
                return true;
            }
            if (grid.get(grid.size() - 1).charAt(i) == '#') {
                return true;
            }
        }
        return false;
    }

    private boolean hasWallsInRowOrColumnOfStart(Cell start) {
        for (int i = 0; i < grid.size(); ++i) {
            if (grid.get(i).charAt(start.getColumn()) == '#') {
                return true;
            }
        }
        for (int i = 0; i < grid.get(0).length(); ++i) {
            if (grid.get(start.getRow()).charAt(i) == '#') {
                return true;
            }
        }
        return false;
    }
}
