package solutions.dec17;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class RegularCrubiclesAllowedToStopPredicateTest {

    @Test
    public void shouldAlwaysReturnTrue() {
        assertTrue(new RegularCrubiclesAllowedToStopPredicate().test(null));
    }

}