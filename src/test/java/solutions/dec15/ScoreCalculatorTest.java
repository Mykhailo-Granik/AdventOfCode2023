package solutions.dec15;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ScoreCalculatorTest {

    @Test
    public void shouldCalculateScoreForOneString() {
        ScoreCalculator underTest = new ScoreCalculator();
        assertEquals(52, underTest.calculate(List.of("HASH")));
    }

    @Test
    public void shouldCalculateScoreForMultipleStrings() {
        ScoreCalculator underTest = new ScoreCalculator();
        List<String> initializationSequence = List.of(
                "rn=1",
                "cm-",
                "qp=3",
                "cm=2",
                "qp-",
                "pc=4",
                "ot=9",
                "ab=5",
                "pc-",
                "pc=6",
                "ot=7"
        );
        assertEquals(1320, underTest.calculate(initializationSequence));
    }

}