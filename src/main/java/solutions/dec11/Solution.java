package solutions.dec11;

import java.util.List;

public class Solution {

    private final long expansionFactor;

    public Solution(long expansionFactor) {
        this.expansionFactor = expansionFactor;
    }

    public long calculateSumOfDistancesBetweenGalaxies(List<String> galaxiesImage) {
        return new SumOfDistancesBetweenGalaxies().calculate(
                new GalaxiesImage(galaxiesImage, expansionFactor)
        );
    }
}
