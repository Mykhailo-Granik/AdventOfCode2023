package solutions.dec9;

import java.util.List;

public class Solution {

    private final ValuesExtrapolator valuesExtrapolator;

    public Solution(ValuesExtrapolator valuesExtrapolator) {
        this.valuesExtrapolator = valuesExtrapolator;
    }

    public long findSumOfExtrapolatedValues(List<String> input) {
        ValuesParser valuesParser = new ValuesParser();
        return input.stream()
                .map(valuesParser::parse)
                .map(valuesExtrapolator::extrapolate)
                .reduce(Long::sum)
                .orElseThrow();
    }
}
