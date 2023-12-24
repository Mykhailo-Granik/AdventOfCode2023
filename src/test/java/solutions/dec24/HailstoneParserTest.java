package solutions.dec24;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HailstoneParserTest {

    @Test
    public void shouldParseHailstone() {
        String hailstone = "20, 19, 15 @  1, -5, -3";
        HailstoneParser underTest = new HailstoneParser();
        assertEquals(
                new Hailstone(
                        new CoordinateChangeVector(20, 1),
                        new CoordinateChangeVector(19, -5),
                        new CoordinateChangeVector(15, -3)
                ),
                underTest.parse(hailstone)
        );
    }

}