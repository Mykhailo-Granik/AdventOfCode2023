package solutions.dec7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegularHandParserTest {

    @Test
    public void shouldParseHand() {
        assertEquals(new Hand(new RegularCards("32T3K"), 765), new RegularHandParser().parse("32T3K 765"));
    }

}