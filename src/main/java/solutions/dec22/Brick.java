package solutions.dec22;

import java.util.List;
import java.util.Objects;

public class Brick {

    private final Point3D firstEnd;
    private final Point3D secondEnd;

    public Brick(Point3D firstEnd, Point3D secondEnd) {
        if (firstEnd.compareTo(secondEnd) < 0) {
            this.firstEnd = firstEnd;
            this.secondEnd = secondEnd;
        } else {
            this.firstEnd = secondEnd;
            this.secondEnd = firstEnd;
        }
        int diffX = this.secondEnd.getX() - this.firstEnd.getX();
        int diffY = this.secondEnd.getY() - this.firstEnd.getY();
        int diffZ = this.secondEnd.getZ() - this.firstEnd.getZ();
        List<Integer> differences = List.of(
                diffX, diffY, diffZ
        );
        if (differences.stream().filter(diff -> diff != 0).count() > 1) {
            System.out.println(this);
            throw new IllegalArgumentException("Unexpected state");
        }
    }

    public Point3D getFirstEnd() {
        return firstEnd;
    }

    public Point3D getSecondEnd() {
        return secondEnd;
    }

    public Rectangle2D projectionOnXY() {
        return new Rectangle2D(
                new Point2D(firstEnd.getX(), firstEnd.getY()),
                new Point2D(secondEnd.getX() + 1, secondEnd.getY() + 1)
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Brick brick = (Brick) o;
        return Objects.equals(firstEnd, brick.firstEnd) && Objects.equals(secondEnd, brick.secondEnd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstEnd, secondEnd);
    }

    @Override
    public String toString() {
        return "Brick{" +
                "firstEnd=" + firstEnd +
                ", secondEnd=" + secondEnd +
                '}';
    }
}
