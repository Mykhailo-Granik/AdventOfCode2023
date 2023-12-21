package solutions.dec21;

import java.util.List;

public class Solution {

    private final int steps;

    public Solution(int steps) {
        this.steps = steps;
    }

    public long numberOfReachableCells(List<String> grid) {
//        new GridExplorer(grid).explore();
//        new BFS(grid).distances();
//        return 0;
        return new InfiniteGridCalculator(grid, 26501365).count();
//        return new ReachableCellsCounter(steps, grid).count();
    }
}
