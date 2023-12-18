package solutions.dec18;

public class SegmentIntersection {

    public boolean doIntersect(Point a, Point b, Point c, Point d) {
        int o1 = orientation(a, b, c);
        int o2 = orientation(a, b, d);
        int o3 = orientation(c, d, a);
        int o4 = orientation(c, d, b);
        return o1 != o2 && o3 != o4;
    }

    private int orientation(Point a, Point b, Point c) {
        int val = (b.getY() - a.getY()) * (c.getX() - b.getX()) - (b.getX() - a.getX()) * (c.getY() - b.getY());
        if (val == 0) return 0;  // Collinear
        return (val > 0) ? 1 : 2; // Clockwise or counterclockwise
    }


}
