package solutions.dec19;

import java.util.List;

public class ScoreCalculator {

    private final List<Part> parts;

    public ScoreCalculator(List<Part> parts) {
        this.parts = parts;
    }

    public int calculateTotalScore() {
        return parts.stream()
                .mapToInt(Part::score)
                .sum();
    }
}
