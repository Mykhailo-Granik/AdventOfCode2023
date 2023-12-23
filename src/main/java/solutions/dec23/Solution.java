package solutions.dec23;

import java.util.List;

public class Solution {

    private final AbstractNextCellsGenerator nextCellsGenerator;

    public Solution(AbstractNextCellsGenerator nextCellsGenerator) {
        this.nextCellsGenerator = nextCellsGenerator;
    }

    public int calculateTheLengthOfLongestPath(List<String> grid) {
        return new LongestPathFinder(grid, nextCellsGenerator).findLongestPath();
    }
}
