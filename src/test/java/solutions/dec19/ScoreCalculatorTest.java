package solutions.dec19;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ScoreCalculatorTest {

    @Test
    public void shouldCalculateTotalScore() {
        List<Part> parts = List.of(
                new Part(1, 2, 3, 4),
                new Part(1, 1, 1, 1),
                new Part(2, 2, 2, 2)
        );
        ScoreCalculator underTest = new ScoreCalculator(parts);
        assertEquals(22, underTest.calculateTotalScore());
    }

}