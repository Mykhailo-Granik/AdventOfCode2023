package solutions.dec3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class NumbersParser {

    public List<NumberInGrid> parse(List<String> grid) {
        if (grid.isEmpty()) {
            return Collections.emptyList();
        }
        return IntStream.range(0, grid.size())
                .mapToObj(row -> parseNumbersInLine(grid, row))
                .flatMap(List::stream)
                .collect(toList());
    }

    private List<NumberInGrid> parseNumbersInLine(List<String> grid, int row) {
        String line = grid.get(row);
        int startColumn = 0;
        List<NumberInGrid> numbers = new ArrayList<>();
        while (startColumn < line.length()) {
            if (line.charAt(startColumn) >= '0' && line.charAt(startColumn) <= '9') {
                NumberInGrid number = parseNumber(grid, row, line, startColumn);
                numbers.add(number);
                startColumn = number.getEndColumn();
            } else {
                ++startColumn;
            }
        }
        return numbers;

    }

    private NumberInGrid parseNumber(List<String> grid, int row, String line, int startColumn) {
        for (int j = startColumn + 1; j < line.length(); ++j) {
            if (!Character.isDigit(line.charAt(j))) {
                return new NumberInGrid(grid, row, startColumn, j);
            }
        }
        return new NumberInGrid(grid, row, startColumn, line.length());
    }

}
