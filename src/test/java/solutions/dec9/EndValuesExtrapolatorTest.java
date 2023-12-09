package solutions.dec9;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EndValuesExtrapolatorTest {

    @Test
    public void shouldExtrapolateEqualValues() {
        Values values = new Values(List.of(1L, 1L, 1L, 1L, 1L));
        assertEquals(1L, new EndValuesExtrapolator().extrapolate(values));
    }

    @Test
    public void shouldExtrapolateArithmeticProgression() {
        Values values = new Values(List.of(0L, 3L, 6L, 9L, 12L, 15L));
        assertEquals(18L, new EndValuesExtrapolator().extrapolate(values));
    }

    @Test
    public void shouldExtrapolateForSequencesOfHigherOrder() {
        Values values = new Values(List.of(1L, 3L, 6L, 10L, 15L, 21L));
        assertEquals(28L, new EndValuesExtrapolator().extrapolate(values));
    }

    @Test
    public void shouldExtrapolateForSequencesOfHigherOrder2() {
        Values values = new Values(List.of(10L, 13L, 16L, 21L, 30L, 45L));
        assertEquals(68L, new EndValuesExtrapolator().extrapolate(values));
    }

}