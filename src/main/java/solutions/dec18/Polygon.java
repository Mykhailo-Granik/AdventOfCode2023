package solutions.dec18;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class Polygon {

    private final List<Point> points;

    public Polygon(List<SegmentDescription> segmentDescriptions) {
        points = new ArrayList<>();
        Point start = new Point(0, 0);
        points.add(start);
        for (SegmentDescription segmentDescription : segmentDescriptions) {
            Point end = new Point(
                    start.getX() + segmentDescription.getDirection().getDeltaX() * segmentDescription.getLength(),
                    start.getY() + segmentDescription.getDirection().getDeltaY() * segmentDescription.getLength()
            );
            points.add(end);
            start = end;
        }
    }

    public List<Point> getPoints() {
        return points;
    }

    public long numberOfPointsInside() {
        List<Integer> sortedYs = points.stream().map(Point::getY).sorted().distinct().collect(toList());
        long res = 0;
        for (int i = 0; i < sortedYs.size() - 1; ++i) {
            res += solveForSegment(sortedYs.get(i), sortedYs.get(i + 1) - 1);
        }
        for (int i = 0; i < points.size() - 1; ++i) {
            Point segmentStart = points.get(i);
            Point segmentEnd = points.get(i + 1);
            if (segmentStart.getX() == segmentEnd.getX()) {
                continue;
            }
            res += Math.abs(segmentEnd.getX() - segmentStart.getX()) + 1;
        }
        return res;
    }

    private long solveForSegment(Integer start, Integer end) {
        List<Integer> xs = new ArrayList<>();
        for (int i = 0; i < points.size() - 1; ++i) {
            Point segmentStart = points.get(i);
            Point segmentEnd = points.get(i + 1);
            if (segmentStart.getX() != segmentEnd.getX()) {
                continue;
            }
            if (Math.min(segmentStart.getY(), segmentEnd.getY()) <= start && Math.max(segmentStart.getY(), segmentEnd.getY()) >= end) {
                xs.add(segmentStart.getX());
            }
        }
        xs = xs.stream().sorted().collect(toList());
        long answer = 0;
        long horizontalSegmentsInsideLength = 0;
        for (int i = 0; i < xs.size(); i += 2) {
            answer += xs.get(i + 1) - xs.get(i) + 1;
            for (int j = 0; j < points.size() - 1; ++j) {
                Point segmentStart = points.get(j);
                Point segmentEnd = points.get(j + 1);
                if (segmentStart.getY() != segmentEnd.getY()) {
                    continue;
                }
                if (segmentStart.getY() < start || segmentStart.getY() > end) {
                    continue;
                }
                int intersectionStart = Math.max(xs.get(i), Math.min(segmentStart.getX(), segmentEnd.getX()));
                int intersectionEnd = Math.min(xs.get(i + 1), Math.max(segmentStart.getX(), segmentEnd.getX()));
                horizontalSegmentsInsideLength += Math.max(0, intersectionEnd - intersectionStart + 1);
            }
        }

        return answer * (end - start + 1) - horizontalSegmentsInsideLength;
    }
}
