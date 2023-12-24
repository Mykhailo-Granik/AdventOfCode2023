package solutions.dec24;

import java.util.Objects;

public class Hailstone {

    private final CoordinateChangeVector xChange;
    private final CoordinateChangeVector yChange;
    private final CoordinateChangeVector zChange;

    public Hailstone(CoordinateChangeVector xChange, CoordinateChangeVector yChange, CoordinateChangeVector zChange) {
        this.xChange = xChange;
        this.yChange = yChange;
        this.zChange = zChange;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hailstone hailstone = (Hailstone) o;
        return Objects.equals(xChange, hailstone.xChange) && Objects.equals(yChange, hailstone.yChange) && Objects.equals(zChange, hailstone.zChange);
    }

    @Override
    public int hashCode() {
        return Objects.hash(xChange, yChange, zChange);
    }

    @Override
    public String toString() {
        return "Hailstone{" +
                "xChange=" + xChange +
                ", yChange=" + yChange +
                ", zChange=" + zChange +
                '}';
    }

    public Coordinate2D findPointOfIntersection(Hailstone other) {
        double nominator = xChange.getDelta() * other.yChange.getStart() -
                yChange.getStart() * xChange.getDelta() -
                yChange.getDelta() * other.xChange.getStart() +
                yChange.getDelta() * xChange.getStart();
        long denominator = yChange.getDelta() * other.xChange.getDelta()
                - other.yChange.getDelta() * xChange.getDelta();
        if (denominator == 0) {
            return Coordinate2D.NON_EXISTENT;
        }
        double time = nominator / denominator;
        return new Coordinate2D(other.xChange.getStart() + other.xChange.getDelta() * time,
                other.yChange.getStart() + other.yChange.getDelta() * time);
    }

    public CoordinateChangeVector getxChange() {
        return xChange;
    }

    public CoordinateChangeVector getyChange() {
        return yChange;
    }

    public CoordinateChangeVector getzChange() {
        return zChange;
    }

    public double timeWithXCoordinate(double coordinate) {
        return (coordinate - xChange.getStart()) / xChange.getDelta();
    }
}
