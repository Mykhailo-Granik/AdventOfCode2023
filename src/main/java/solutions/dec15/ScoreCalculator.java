package solutions.dec15;

import java.util.List;

public class ScoreCalculator {

    public int calculate(List<String> initializationSequence) {
        return initializationSequence.stream()
                .mapToInt(this::scoreForString)
                .sum();
    }

    private int scoreForString(String string) {
        return new Hash(string).calculate();
    }
}
