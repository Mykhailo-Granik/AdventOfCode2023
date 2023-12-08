package solutions.dec8;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    public void shouldFindMinNumberOfStepsWithoutRepeatingCommands() {
        Solution underTest = new Solution();
        assertEquals(
                2,
                underTest.findNumberOfSteps(
                        List.of(
                                "RL",
                                "",
                                "AAA = (BBB, CCC)",
                                "BBB = (DDD, EEE)",
                                "CCC = (ZZZ, GGG)",
                                "DDD = (DDD, DDD)",
                                "EEE = (EEE, EEE)",
                                "GGG = (GGG, GGG)",
                                "ZZZ = (ZZZ, ZZZ)"
                        )
                )
        );
    }

    @Test
    public void shouldFindMinNumberOfStepsWithRepeatingCommands() {
        Solution underTest = new Solution();
        assertEquals(
                6,
                underTest.findNumberOfSteps(
                        List.of(
                                "LLR",
                                "",
                                "AAA = (BBB, BBB)",
                                "BBB = (AAA, ZZZ)",
                                "ZZZ = (ZZZ, ZZZ)"
                        )
                )
        );
    }

}