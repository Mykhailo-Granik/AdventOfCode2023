package solutions.dec18;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class Solution {

    private final SegmentDescriptionParser parser;

    public Solution(SegmentDescriptionParser parser) {
        this.parser = parser;
    }

    public long calculateNumberOfPointsInsidePolygon(List<String> segmentDescriptions) {
        Polygon polygon = new Polygon(
                segmentDescriptions.stream()
                        .map(parser::parse)
                        .collect(toList())
        );
//        int minX = polygon.getPoints().stream().mapToInt(Point::getX).min().orElseThrow();
//        int maxX = polygon.getPoints().stream().mapToInt(Point::getX).max().orElseThrow();
//        int minY = polygon.getPoints().stream().mapToInt(Point::getY).min().orElseThrow();
//        int maxY = polygon.getPoints().stream().mapToInt(Point::getY).max().orElseThrow();
//        System.out.println("x range = [" + minX + ", " + maxX + "], length = " + (maxX - minX + 1) + "");
//        System.out.println("y range = [" + minY + ", " + maxY + "], length = " + (maxY - minY + 1) + "");
//        System.out.println(polygon.getPoints());
        return polygon.numberOfPointsInside();
    }
}
