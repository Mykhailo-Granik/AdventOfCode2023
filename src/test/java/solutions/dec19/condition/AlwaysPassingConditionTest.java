package solutions.dec19.condition;

import org.junit.jupiter.api.Test;
import solutions.dec19.range.ParameterRange;
import solutions.dec19.range.ParametersRange;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AlwaysPassingConditionTest {

    @Test
    public void shouldAlwaysPass() {
        AlwaysPassingCondition underTest = AlwaysPassingCondition.getInstance();
        assertTrue(underTest.test(null));
    }

    @Test
    public void shouldReturnSegmentForPassingCondition() {
        AlwaysPassingCondition underTest = AlwaysPassingCondition.getInstance();
        ParametersRange parametersRange = new ParametersRange(List.of(new ParameterRange("x", 1, 2)));
        assertEquals(parametersRange, underTest.passingCondition(parametersRange));
    }

    @Test
    public void shouldReturnEmptySegmentForFailingCondition() {
        AlwaysPassingCondition underTest = AlwaysPassingCondition.getInstance();
        ParametersRange parametersRange = new ParametersRange(List.of(new ParameterRange("x", 1, 2)));
        assertTrue(underTest.failingCondition(parametersRange).isEmpty());
    }

}