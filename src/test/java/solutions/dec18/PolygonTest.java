package solutions.dec18;

import org.junit.jupiter.api.Test;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PolygonTest {

    @Test
    public void shouldCreatePolygonFromSegmentDescriptions() {
        Polygon polygon = new Polygon(
                List.of(
                        new SegmentDescription(3, Direction.RIGHT, "red"),
                        new SegmentDescription(4, Direction.DOWN, "green"),
                        new SegmentDescription(3, Direction.LEFT, "blue"),
                        new SegmentDescription(4, Direction.UP, "yellow")
                )
        );
        assertEquals(
                List.of(
                        new Point(0, 0),
                        new Point(3, 0),
                        new Point(3, 4),
                        new Point(0, 4),
                        new Point(0, 0)
                ),
                polygon.getPoints()
        );
    }

    @Test
    public void shouldCountPointsInside() {
        Polygon polygon = new Polygon(
                segmentDescriptions(new SimpleSegmentDescriptionParser())
        );
        assertEquals(62, polygon.numberOfPointsInside());
    }

    private List<SegmentDescription> segmentDescriptions(SegmentDescriptionParser parser) {
        List<String> segmentDescriptions = List.of(
                "R 6 (#70c710)",
                "D 5 (#0dc571)",
                "L 2 (#5713f0)",
                "D 2 (#d2c081)",
                "R 2 (#59c680)",
                "D 2 (#411b91)",
                "L 5 (#8ceee2)",
                "U 2 (#caa173)",
                "L 1 (#1b58a2)",
                "U 2 (#caa171)",
                "R 2 (#7807d2)",
                "U 3 (#a77fa3)",
                "L 2 (#015232)",
                "U 2 (#7a21e3)"
        );
        return segmentDescriptions.stream()
                .map(parser::parse)
                .collect(toList());
    }

    @Test
    public void shouldCountPointsInsideWithHexaDecimalParser() {
        Polygon polygon = new Polygon(
                segmentDescriptions(new HexaDecimalSegmentDescriptionParser())
        );
        assertEquals(952408144115L, polygon.numberOfPointsInside());
    }

}