package solutions.dec19.condition;

import org.junit.jupiter.api.Test;
import solutions.dec19.Part;
import solutions.dec19.range.ParameterRange;
import solutions.dec19.range.ParametersRange;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GreaterThanConditionTest {

    @Test
    public void shouldReturnFalseWhenPartParameterLessThenValue() {
        Part part = new Part(1, 2, 3, 4);
        GreaterThanCondition underTest = new GreaterThanCondition("x", 2);
        assertFalse(underTest.test(part));
    }

    @Test
    public void shouldReturnFalseWhenPartParameterEqualsValue() {
        Part part = new Part(1, 2, 3, 4);
        GreaterThanCondition underTest = new GreaterThanCondition("x", 1);
        assertFalse(underTest.test(part));
    }

    @Test
    public void shouldReturnTrueWhenPartParameterGreaterThenValue() {
        Part part = new Part(1, 2, 3, 4);
        GreaterThanCondition underTest = new GreaterThanCondition("x", 0);
        assertTrue(underTest.test(part));
    }

    @Test
    public void shouldCreateParametersRangePassingCondition() {
        GreaterThanCondition underTest = new GreaterThanCondition("x", 2);
        ParametersRange expected = new ParametersRange(
                List.of(
                        new ParameterRange("x", 3, 4),
                        new ParameterRange("m", 1, 4),
                        new ParameterRange("a", 1, 4),
                        new ParameterRange("s", 1, 4)
                )
        );
        assertEquals(expected, underTest.passingCondition(startingRange()));
    }

    private ParametersRange startingRange() {
        return new ParametersRange(
                List.of(
                        new ParameterRange("x", 1, 4),
                        new ParameterRange("m", 1, 4),
                        new ParameterRange("a", 1, 4),
                        new ParameterRange("s", 1, 4)
                )
        );
    }

    @Test
    public void shouldCreateParametersRangeFailingCondition() {
        GreaterThanCondition underTest = new GreaterThanCondition("m", 2);
        ParametersRange expected = new ParametersRange(
                List.of(
                        new ParameterRange("x", 1, 4),
                        new ParameterRange("m", 1, 2),
                        new ParameterRange("a", 1, 4),
                        new ParameterRange("s", 1, 4)
                )
        );
        assertEquals(expected, underTest.failingCondition(startingRange()));
    }

}