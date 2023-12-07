package solutions.dec7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HandWithJokersParserTest {

    @Test
    public void shouldParseHand() {
        assertEquals(new Hand(new CardsWithJokers("32T3K"), 765), new HandWithJokersParser().parse("32T3K 765"));
    }

}