package solutions.dec10;

import java.util.List;

public class SolutionPart2 {


    public int findNumberOfPointsInsideCycle(List<String> grid) {
        return new PointsInsideCycle().calculateAmount(
                new Grid(grid)
        );
    }
}
