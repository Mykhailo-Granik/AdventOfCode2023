package solutions.dec22;

import java.util.Objects;

public class Rectangle2D {

    private final Point2D corner1;
    private final Point2D corner2;

    public Rectangle2D(Point2D corner1, Point2D corner2) {
        if (corner1.compareTo(corner2) < 0) {
            this.corner1 = corner1;
            this.corner2 = corner2;
        } else {
            this.corner1 = corner2;
            this.corner2 = corner1;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rectangle2D that = (Rectangle2D) o;
        return Objects.equals(corner1, that.corner1) && Objects.equals(corner2, that.corner2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(corner1, corner2);
    }

    @Override
    public String toString() {
        return "Rectangle2D{" +
                "corner1=" + corner1 +
                ", corner2=" + corner2 +
                '}';
    }

    public boolean intersects(Rectangle2D other) {
        return segmentIntersect(corner1.getX(), corner2.getX(), other.corner1.getX(), other.corner2.getX())
                && segmentIntersect(corner1.getY(), corner2.getY(), other.corner1.getY(), other.corner2.getY());
    }

    private boolean segmentIntersect(int start1, int end1, int start2, int end2) {
        int startOfIntersection = Math.max(Math.min(start1, end1), Math.min(start2, end2));
        int endOfIntersection = Math.min(Math.max(start1, end1), Math.max(start2, end2));
        return startOfIntersection < endOfIntersection;
    }
}
