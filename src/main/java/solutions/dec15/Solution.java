package solutions.dec15;

import java.util.List;

public class Solution {


    public int calculateScore(List<String> initializationSequence) {
        return new ScoreCalculator().calculate(
                new InputParser().parse(initializationSequence.get(0))
        );
    }
}
