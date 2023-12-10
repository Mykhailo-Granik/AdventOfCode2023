package solutions.dec10;

public class SegmentIntersection {

    public boolean doIntersect(Coordinate a, Coordinate b, Coordinate c, Coordinate d) {
        int o1 = orientation(a, b, c);
        int o2 = orientation(a, b, d);
        int o3 = orientation(c, d, a);
        int o4 = orientation(c, d, b);
        return o1 != o2 && o3 != o4;
    }

    private int orientation(Coordinate a, Coordinate b, Coordinate c) {
        int val = (b.getY() - a.getY()) * (c.getX() - b.getX()) - (b.getX() - a.getX()) * (c.getY() - b.getY());
        if (val == 0) return 0;  // Collinear
        return (val > 0) ? 1 : 2; // Clockwise or counterclockwise
    }


}
