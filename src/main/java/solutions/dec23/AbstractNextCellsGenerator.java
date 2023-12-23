package solutions.dec23;

import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public abstract class AbstractNextCellsGenerator {

    protected final List<String> grid;

    protected AbstractNextCellsGenerator(List<String> grid) {
        this.grid = grid;
    }

    public List<Cell> generateNextCells(Cell cell) {
        return possibleNextCells(cell)
                .filter(this::isCellOnGrid)
                .filter(this::isNotAForestCell)
                .collect(toList());
    }

    protected abstract Stream<Cell> possibleNextCells(Cell cell);

    private boolean isCellOnGrid(Cell cell) {
        return cell.getRow() >= 0 && cell.getRow() < grid.size() && cell.getCol() >= 0 && cell.getCol() < grid.get(0).length();
    }

    private boolean isNotAForestCell(Cell cell) {
        return grid.get(cell.getRow()).charAt(cell.getCol()) != '#';
    }

}
