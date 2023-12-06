package solutions.dec3;

import java.util.List;

public class Solution3Dec1 {

    public long findSumOfNumbersWithNeighbors(List<String> grid) {
        new NumbersParser().parse(grid).stream()
                .filter(NumberInGrid::hasNeighbouringCharacter)
                .mapToLong(NumberInGrid::getNumericalValue)
                .forEach(System.out::println);
        return new NumbersParser().parse(grid).stream()
                .filter(NumberInGrid::hasNeighbouringCharacter)
                .mapToLong(NumberInGrid::getNumericalValue)
                .sum();
    }

}
