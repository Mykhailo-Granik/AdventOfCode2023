package solutions.dec15;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InputParserTest {

    @Test
    public void shouldParseInputOfOneString() {
        InputParser underTest = new InputParser();
        assertEquals(List.of("abc"), underTest.parse("abc"));
    }

    @Test
    public void shouldParseInputOfMultipleStrings() {
        InputParser underTest = new InputParser();
        assertEquals(List.of("abc", "de", "fgh"), underTest.parse("abc,de,fgh"));
    }

}