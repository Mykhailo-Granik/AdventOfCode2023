package solutions.dec18;

public class SimpleSegmentDescriptionParser implements SegmentDescriptionParser {
    @Override
    public SegmentDescription parse(String segmentDescription) {
        String[] parts = segmentDescription.split(" ");
        return new SegmentDescription(
                Integer.parseInt(parts[1]),
                Direction.fromString(parts[0]),
                parts[2].substring(1, parts[2].length() - 1)
        );
    }
}
