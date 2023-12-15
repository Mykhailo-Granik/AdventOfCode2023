package solutions.dec15;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    public void shouldCalculateScoreForInitializationSequence() {
        Solution underTest = new Solution();
        String initializationSequence = "rn=1,cm-,qp=3,cm=2,qp-,pc=4,ot=9,ab=5,pc-,pc=6,ot=7";
        assertEquals(1320, underTest.calculateScore(List.of(initializationSequence)));
    }

}