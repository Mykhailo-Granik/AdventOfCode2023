package solutions.dec23;

import java.util.List;
import java.util.stream.Stream;

public class NextCellsWithSlopesGenerator extends AbstractNextCellsGenerator {

    public NextCellsWithSlopesGenerator(List<String> grid) {
        super(grid);
    }

    @Override
    protected Stream<Cell> possibleNextCells(Cell cell) {
        switch (grid.get(cell.getRow()).charAt(cell.getCol())) {
            case '.':
                return Stream.of(
                        new Cell(cell.getRow() - 1, cell.getCol()),
                        new Cell(cell.getRow() + 1, cell.getCol()),
                        new Cell(cell.getRow(), cell.getCol() - 1),
                        new Cell(cell.getRow(), cell.getCol() + 1)
                );
            case 'v':
                return Stream.of(
                        new Cell(cell.getRow() + 1, cell.getCol())
                );
            case '^':
                return Stream.of(
                        new Cell(cell.getRow() - 1, cell.getCol())
                );
            case '<':
                return Stream.of(
                        new Cell(cell.getRow(), cell.getCol() - 1)
                );
            case '>':
                return Stream.of(
                        new Cell(cell.getRow(), cell.getCol() + 1)
                );
            default:
                throw new IllegalStateException("Unexpected value: " + grid.get(cell.getRow()).charAt(cell.getCol()));
        }
    }

}
