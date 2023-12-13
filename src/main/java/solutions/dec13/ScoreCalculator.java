package solutions.dec13;

import java.util.List;

public class ScoreCalculator {

    private final LandSymmetryCalculator landSymmetryCalculator;

    public ScoreCalculator(LandSymmetryCalculator landSymmetryCalculator) {
        this.landSymmetryCalculator = landSymmetryCalculator;
    }

    public int calculateScore(List<Land> lands) {
        return lands.stream()
                .mapToInt(this::calculateScore)
                .sum();
    }

    private int calculateScore(Land land) {
        int horizontalScore = landSymmetryCalculator.horizontalMirrorLocationOrMinusOne(land);
        int verticalScore = landSymmetryCalculator.verticalMirrorLocationOrMinusOne(land);
        int res = 0;
        if (horizontalScore != -1) {
            res += horizontalScore * 100;
        }
        if (verticalScore != -1) {
            res += verticalScore;
        }
        return res;
    }
}
