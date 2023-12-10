package solutions.dec10;

import java.util.List;

public class Solution {


    public int calculateDistanceToFarthestTile(List<String> grid) {
        return new FarthestTile().findDistance(
                new Grid(grid)
        );
    }
}
