package solutions.dec18;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SimpleSegmentDescriptionParserTest {

    @Test
    public void shouldParseSegmentDescription() {
        SegmentDescriptionParser parser = new SimpleSegmentDescriptionParser();
        SegmentDescription segmentDescription = parser.parse("R 6 (#70c710)");
        assertEquals(new SegmentDescription(6, Direction.RIGHT, "#70c710"), segmentDescription);
    }

}