package solutions.dec9;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ValuesParserTest {

    @Test
    public void shouldParseSingleValue() {
        Values values = new ValuesParser().parse("1");
        assertEquals(new Values(List.of(1L)), values);
    }

    @Test
    public void shouldParseMultipleValues() {
        Values values = new ValuesParser().parse("0 3 6 9 12 15");
        assertEquals(new Values(List.of(0L, 3L, 6L, 9L, 12L, 15L)), values);
    }

}