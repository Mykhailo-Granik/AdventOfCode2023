package solutions.dec21;

import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class NextCellsGenerator {

    private final List<String> grid;

    public NextCellsGenerator(List<String> grid) {
        this.grid = grid;
    }


    public List<Cell> generate(Cell cell) {
        return Stream.of(
                        new Cell(cell.getRow(), cell.getColumn() - 1),
                        new Cell(cell.getRow(), cell.getColumn() + 1),
                        new Cell(cell.getRow() - 1, cell.getColumn()),
                        new Cell(cell.getRow() + 1, cell.getColumn())
                )
                .filter(this::cellIsInsideOfAGrid)
                .filter(this::cellIsNotARock)
                .collect(toList());
    }

    private boolean cellIsInsideOfAGrid(Cell cell) {
        return cell.getRow() >= 0 && cell.getRow() < grid.size() &&
                cell.getColumn() >= 0 && cell.getColumn() < grid.get(0).length();
    }

    private boolean cellIsNotARock(Cell cell) {
        return grid.get(cell.getRow()).charAt(cell.getColumn()) != '#';
    }
}
