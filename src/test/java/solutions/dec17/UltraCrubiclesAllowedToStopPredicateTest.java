package solutions.dec17;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class UltraCrubiclesAllowedToStopPredicateTest {

    @Test
    public void shouldReturnTrueIfNumberOfStepsTakenIsBiggerThanThree() {
        assertTrue(new UltraCrubiclesAllowedToStopPredicate().test(new GraphNode(1, 1, Direction.LEFT, 4)));
    }

    @Test
    public void shouldReturnFalseIfNumberOfStepsTakenIsLessThanFour() {
        assertFalse(new UltraCrubiclesAllowedToStopPredicate().test(new GraphNode(1, 1, Direction.LEFT, 2)));
    }

}