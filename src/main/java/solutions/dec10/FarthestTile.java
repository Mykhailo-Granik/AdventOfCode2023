package solutions.dec10;

import java.util.List;

public class FarthestTile {
    public int findDistance(Grid grid) {
        List<Coordinate> cycle = new CycleFinder().findCycle(grid);
        if (cycle.isEmpty()) {
            throw new IllegalArgumentException("No cycle found");
        }
        return (cycle.size() + 1) / 2;
    }

}
