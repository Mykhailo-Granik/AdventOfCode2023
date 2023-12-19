package solutions.dec19.range;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ParametersRangeTest {

    @Test
    public void shouldFindParameterRangeByName() {
        ParametersRange underTest = new ParametersRange(
                List.of(
                        new ParameterRange("x", 1, 2),
                        new ParameterRange("y", 3, 4)
                )
        );
        assertEquals(new ParameterRange("x", 1, 2), underTest.findParameterRangeByName("x"));
    }

    @Test
    public void shouldUpdateParameterRange() {
        ParametersRange underTest = new ParametersRange(
                List.of(
                        new ParameterRange("x", 1, 2),
                        new ParameterRange("y", 3, 4)
                )
        );
        ParametersRange expected = new ParametersRange(
                List.of(
                        new ParameterRange("x", 3, 6),
                        new ParameterRange("y", 3, 4)
                )
        );
        assertEquals(expected, underTest.updateRangeForParameter(new ParameterRange("x", 3, 6)));
    }

    @Test
    public void shouldCalculateNumberOfItemsInRange() {
        ParametersRange underTest = new ParametersRange(
                List.of(
                        new ParameterRange("x", 1, 2),
                        new ParameterRange("y", 3, 5)
                )
        );
        assertEquals(6, underTest.numberOfItemsInRange());
    }

    @Test
    public void shouldReturnZeroItemsInEmptyRange() {
        ParametersRange underTest = new ParametersRange(
                List.of(
                        new ParameterRange("x", 1, 0),
                        new ParameterRange("y", 3, 5)
                )
        );
        assertEquals(0, underTest.numberOfItemsInRange());
    }

}