package solutions.dec18;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HexaDecimalSegmentDescriptionParserTest {

    @Test
    public void shouldParseSegmentDescription() {
        HexaDecimalSegmentDescriptionParser parser = new HexaDecimalSegmentDescriptionParser();
        assertEquals(
                new SegmentDescription(461937, Direction.RIGHT),
                parser.parse("R 6 (#70c710)")
        );
    }

}