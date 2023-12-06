package solutions.dec3;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class Asterisk {

    private final int row;
    private final int column;

    public Asterisk(int row, int column) {
        this.row = row;
        this.column = column;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Asterisk asterisk = (Asterisk) o;
        return row == asterisk.row && column == asterisk.column;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, column);
    }

    public long getRatioIfGearOrZero(List<NumberInGrid> numbers) {
        List<NumberInGrid> neighboringNumbers = getNeighboringNumbers(numbers);
        if (neighboringNumbers.size() == 2) {
            return neighboringNumbers.get(0).getNumericalValue() * neighboringNumbers.get(1).getNumericalValue();
        }
        return 0L;
    }

    private List<NumberInGrid> getNeighboringNumbers(List<NumberInGrid> numbers) {
        return numbers.stream().filter(this::isNeighbor).collect(toList());
    }

    private boolean isNeighbor(NumberInGrid numberInGrid) {
        return row >= numberInGrid.getRow() - 1 && row <= numberInGrid.getRow() + 1
                && column >= numberInGrid.getStartColumn() - 1 && column <= numberInGrid.getEndColumn();
    }
}
