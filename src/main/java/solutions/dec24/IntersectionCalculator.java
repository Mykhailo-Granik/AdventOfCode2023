package solutions.dec24;

import java.util.List;

public class IntersectionCalculator {

    private final List<Hailstone> hailstones;
    private final long coordinateLowerBound;
    private final long coordinateUpperBound;

    public IntersectionCalculator(List<Hailstone> hailstones, long coordinateLowerBound, long coordinateUpperBound) {
        this.hailstones = hailstones;
        this.coordinateLowerBound = coordinateLowerBound;
        this.coordinateUpperBound = coordinateUpperBound;
    }

    public int calculateNumberOfIntersections() {
        int res = 0;
        for (int i = 0; i < hailstones.size(); i++) {
            for (int j = i + 1; j < hailstones.size(); j++) {
                if (intersectInBounds(hailstones.get(i), hailstones.get(j))) {
                    res++;
                }
            }
        }
        return res;
    }

    private boolean intersectInBounds(Hailstone hailstone1, Hailstone hailstone2) {
        Coordinate2D intersection = hailstone1.findPointOfIntersection(hailstone2);
        if (intersection.equals(Coordinate2D.NON_EXISTENT)) {
            return false;
        }
        double time1 = hailstone1.timeWithXCoordinate(intersection.getX());
        double time2 = hailstone2.timeWithXCoordinate(intersection.getX());
        return ((time1 >= 0) && (time2 >= 0) && insideBounds(intersection.getX()) && insideBounds(intersection.getY()));
    }

    private boolean insideBounds(double coordinate) {
        return (coordinate >= coordinateLowerBound) && (coordinate <= coordinateUpperBound);
    }
}
