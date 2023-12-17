package solutions.dec17;

import java.util.List;

public class Solution {

    private final NextNodesGenerator nextNodesGenerator;
    private final AllowedToStopPredicate allowedToStopPredicate;

    public Solution(NextNodesGenerator nextNodesGenerator, AllowedToStopPredicate allowedToStopPredicate) {
        this.nextNodesGenerator = nextNodesGenerator;
        this.allowedToStopPredicate = allowedToStopPredicate;
    }

    public int calculateShortestPath(List<String> grid) {
        return new Grid(
                grid,
                nextNodesGenerator,
                allowedToStopPredicate
        ).findShortestPath();
    }
}
