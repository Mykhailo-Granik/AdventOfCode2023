package solutions.dec24;

import java.util.Objects;

public class Coordinate2D {

    private final double x;
    private final double y;

    public Coordinate2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public static Coordinate2D NON_EXISTENT = new Coordinate2D(Double.MAX_VALUE, Double.MAX_VALUE);

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinate2D that = (Coordinate2D) o;
        return Double.compare(that.x, x) == 0 && Double.compare(that.y, y) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "Coordinate2D{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
