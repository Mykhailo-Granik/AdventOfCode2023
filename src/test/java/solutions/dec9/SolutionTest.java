package solutions.dec9;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    public void shouldFindSumOfExtrapolatedEndValues() {
        Solution solution = new Solution(new EndValuesExtrapolator());
        assertEquals(
                114L,
                solution.findSumOfExtrapolatedValues(
                        List.of(
                                "0 3 6 9 12 15",
                                "1 3 6 10 15 21",
                                "10 13 16 21 30 45"
                        )
                )
        );
    }

    @Test
    public void shouldFindSumOfExtrapolatedBeginningValues() {
        Solution solution = new Solution(new BeginningValuesExtrapolator());
        assertEquals(
                2L,
                solution.findSumOfExtrapolatedValues(
                        List.of(
                                "0 3 6 9 12 15",
                                "1 3 6 10 15 21",
                                "10 13 16 21 30 45"
                        )
                )
        );
    }

}