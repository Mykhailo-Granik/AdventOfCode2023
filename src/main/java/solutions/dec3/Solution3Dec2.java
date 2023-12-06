package solutions.dec3;

import java.util.List;

public class Solution3Dec2 {

    public long findSumOfRatiosOfGears(List<String> grid) {
        Asterisks asterisks = new Asterisks();
        List<Asterisk> allAsterisks = asterisks.findAllAsterisks(grid);
        List<NumberInGrid> numbersInGrid = new NumbersParser().parse(grid);
        return allAsterisks.stream()
                .mapToLong(asterisk -> asterisk.getRatioIfGearOrZero(numbersInGrid))
                .sum();
    }

}
