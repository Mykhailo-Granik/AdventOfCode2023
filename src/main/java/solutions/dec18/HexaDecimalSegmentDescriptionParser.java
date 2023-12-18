package solutions.dec18;

public class HexaDecimalSegmentDescriptionParser implements SegmentDescriptionParser {
    @Override
    public SegmentDescription parse(String segmentDescription) {
        String hexadecimalPart = segmentDescription.split(" ")[2];
        int length = Integer.parseInt(hexadecimalPart.substring(2, hexadecimalPart.length() - 2), 16);
        Direction direction = Direction.fromDigitString(hexadecimalPart.substring(hexadecimalPart.length() - 2, hexadecimalPart.length() - 1));
        return new SegmentDescription(length, direction);
    }
}
