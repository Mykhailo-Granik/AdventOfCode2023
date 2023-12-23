package solutions.dec23;

import java.util.List;
import java.util.stream.Stream;

public class NextCellsIgnoringSlopesGenerator extends AbstractNextCellsGenerator {
    public NextCellsIgnoringSlopesGenerator(List<String> grid) {
        super(grid);
    }

    @Override
    protected Stream<Cell> possibleNextCells(Cell cell) {
        return Stream.of(
                new Cell(cell.getRow() - 1, cell.getCol()),
                new Cell(cell.getRow() + 1, cell.getCol()),
                new Cell(cell.getRow(), cell.getCol() - 1),
                new Cell(cell.getRow(), cell.getCol() + 1)
        );
    }
}
