package solutions.dec13;

import java.util.List;

public class Solution {

    private final LandSymmetryCalculator landSymmetryCalculator;

    public Solution(LandSymmetryCalculator landSymmetryCalculator) {
        this.landSymmetryCalculator = landSymmetryCalculator;
    }

    public int sumOfScoresForEachLand(List<String> input) {
        return new ScoreCalculator(landSymmetryCalculator)
                .calculateScore(new LandParser().parse(input));
    }
}
