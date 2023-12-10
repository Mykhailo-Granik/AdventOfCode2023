package solutions.dec10;

import java.util.List;
import java.util.Random;

public class PointsInsideCycle {

    public int calculateAmount(Grid grid) {
        List<Coordinate> pipesInCycle = new CycleFinder().findCycle(grid);
        int res = 0;
        for (int y = 0; y < grid.numberOfRows(); y++) {
            for (int x = 0; x < grid.numberOfColumns(); x++) {
                if (isInsideCycle(new Coordinate(x, y), pipesInCycle)) {
                    res++;
                }
            }
        }
        return res;
    }

    private boolean isInsideCycle(Coordinate coordinate, List<Coordinate> pipesInCycle) {
        if (pipesInCycle.contains(coordinate)) {
            return false;
        }
        Random random = new Random();
        int odd = 0;
        int even = 0;
        for (int i = 0; i < 20; ++i) {
            int x = random.nextInt(20000) + 10000;
            int y = random.nextInt(20000) + 10000;
            if (oddNumberOfIntersections(coordinate, pipesInCycle, new Coordinate(x, y))) {
                odd++;
            } else {
                even++;
            }
        }
        return (odd > even);
    }

    private boolean oddNumberOfIntersections(Coordinate coordinate, List<Coordinate> pipesInCycle, Coordinate randomCoordinate) {
        int intersections = 0;
        for (int i = 0; i < pipesInCycle.size(); ++i) {
            if (haveIntersection(pipesInCycle.get(i), pipesInCycle.get((i + 1) % pipesInCycle.size()), coordinate, randomCoordinate)) {
                intersections++;
            }
        }
        return intersections % 2 == 1;
    }

    private boolean haveIntersection(Coordinate a, Coordinate b, Coordinate c, Coordinate d) {
        return new SegmentIntersection().doIntersect(a, b, c, d);
    }

}
