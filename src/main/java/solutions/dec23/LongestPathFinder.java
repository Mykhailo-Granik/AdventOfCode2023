package solutions.dec23;

import java.util.Collections;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class LongestPathFinder {

    private static final int MAX_PATHS_TO_FIND = 500000;
    private final List<String> grid;
    private boolean[][] visited;
    private final AbstractNextCellsGenerator nextCellsGenerator;
    private int pathsFound = 0;

    public LongestPathFinder(List<String> grid, AbstractNextCellsGenerator nextCellsGenerator) {
        this.grid = grid;
        this.nextCellsGenerator = nextCellsGenerator;
    }

    public int findLongestPath() {
        visited = new boolean[grid.size()][grid.get(0).length()];
        return findLongestPathRecursively(findStartingCell());
    }

    private int findLongestPathRecursively(Cell cell) {
        if (cell.getRow() == grid.size() - 1) {
            pathsFound++;
            return 0;
        }
        if (pathsFound > MAX_PATHS_TO_FIND) {
            return Integer.MIN_VALUE;
        }
        visited[cell.getRow()][cell.getCol()] = true;
        int res = Integer.MIN_VALUE;
        List<Cell> nextCells = nextCellsGenerator.generateNextCells(cell)
                .stream()
                .filter(nextCell -> !visited[nextCell.getRow()][nextCell.getCol()])
                .collect(toList());
        Collections.shuffle(nextCells);
        for (Cell nextCell : nextCells) {
            res = Math.max(res, 1 + findLongestPathRecursively(nextCell));
        }
        visited[cell.getRow()][cell.getCol()] = false;
        return res;
    }

    private Cell findStartingCell() {
        for (int col = 0; col < grid.get(0).length(); col++) {
            if (grid.get(0).charAt(col) != '#') {
                return new Cell(0, col);
            }
        }
        throw new IllegalStateException("No starting cell found");
    }
}
