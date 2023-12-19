package solutions.dec19.condition;

import org.junit.jupiter.api.Test;
import solutions.dec19.Part;
import solutions.dec19.range.ParameterRange;
import solutions.dec19.range.ParametersRange;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LessThanConditionTest {

    @Test
    public void shouldReturnTrueWhenPartParameterLessThenValue() {
        Part part = new Part(1, 2, 3, 4);
        LessThanCondition underTest = new LessThanCondition("x", 2);
        assertTrue(underTest.test(part));
    }

    @Test
    public void shouldReturnFalseWhenPartParameterEqualsValue() {
        Part part = new Part(1, 2, 3, 4);
        LessThanCondition underTest = new LessThanCondition("x", 1);
        assertFalse(underTest.test(part));
    }

    @Test
    public void shouldReturnFalseWhenPartParameterGreaterThenValue() {
        Part part = new Part(1, 2, 3, 4);
        LessThanCondition underTest = new LessThanCondition("x", 0);
        assertFalse(underTest.test(part));
    }

    @Test
    public void shouldCreateParametersRangePassingCondition() {
        LessThanCondition underTest = new LessThanCondition("a", 3);
        ParametersRange expected = new ParametersRange(
                List.of(
                        new ParameterRange("x", 1, 4),
                        new ParameterRange("m", 1, 4),
                        new ParameterRange("a", 1, 2),
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
        LessThanCondition underTest = new LessThanCondition("s", 3);
        ParametersRange expected = new ParametersRange(
                List.of(
                        new ParameterRange("x", 1, 4),
                        new ParameterRange("m", 1, 4),
                        new ParameterRange("a", 1, 4),
                        new ParameterRange("s", 3, 4)
                )
        );
        assertEquals(expected, underTest.failingCondition(startingRange()));
    }

}