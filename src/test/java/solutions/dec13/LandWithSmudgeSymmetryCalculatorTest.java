package solutions.dec13;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LandWithSmudgeSymmetryCalculatorTest {

    @Test
    public void shouldFindHorizontalSymmetryForLandWithASmudge() {
        Land land = new Land(
                List.of(
                        "#.##..##.",
                        "..#.##.#.",
                        "##......#",
                        "##......#",
                        "..#.##.#.",
                        "..##..##.",
                        "#.#.##.#."
                )
        );
        LandSymmetryCalculator calculator = new LandWithSmudgeSymmetryCalculator();
        assertEquals(3, calculator.horizontalMirrorLocationOrMinusOne(land));
    }

    @Test
    public void shouldFindHorizontalSymmetryForOtherMap() {
        Land land = new Land(
                List.of(
                        "#...##..#",
                        "#....#..#",
                        "..##..###",
                        "#####.##.",
                        "#####.##.",
                        "..##..###",
                        "#....#..#"
                )
        );
        LandSymmetryCalculator calculator = new LandWithSmudgeSymmetryCalculator();
        assertEquals(1, calculator.horizontalMirrorLocationOrMinusOne(land));
    }

    @Test
    public void shouldFindVerticalSymmetryForALandWithASmudge() {
        Land land = new Land(
                List.of(
                        "....",
                        "#..."
                )
        );
        LandSymmetryCalculator calculator = new LandWithSmudgeSymmetryCalculator();
        assertEquals(1, calculator.verticalMirrorLocationOrMinusOne(land));
    }

}