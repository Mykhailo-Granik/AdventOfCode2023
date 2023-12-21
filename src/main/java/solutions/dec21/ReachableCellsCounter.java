package solutions.dec21;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ReachableCellsCounter {

    private final int steps;
    private final List<String> grid;

    public ReachableCellsCounter(int steps, List<String> grid) {
        this.steps = steps;
        this.grid = grid;
    }

    public int count() {
        NextCellsGenerator nextCellsGenerator = new NextCellsGenerator(grid);
        Set<Cell> currentCells = Set.of(startingCell());
        for (int step = 0; step < steps; step++) {
            Set<Cell> nextCells = new HashSet<>();
            for (Cell currentCell : currentCells) {
                nextCells.addAll(nextCellsGenerator.generate(currentCell));
            }
            currentCells = nextCells;
        }
        return currentCells.size();
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
}
