package solutions.dec15;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionPart2Test {

    @Test
    public void shouldCalculateScoreAfterSequenceOfCommandsIsPefromed() {
        SolutionPart2 underTest = new SolutionPart2();
        String initializationSequence = "rn=1,cm-,qp=3,cm=2,qp-,pc=4,ot=9,ab=5,pc-,pc=6,ot=7";
        assertEquals(145, underTest.calculateScore(List.of(initializationSequence)));
    }

}