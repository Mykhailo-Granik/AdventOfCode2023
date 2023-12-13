package solutions.dec13;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RegularLandSymmetryCalculatorTest {

    @Test
    public void shouldReturnNoHorizontalMirrorExists() {
        Land land = new Land(List.of("##", ".."));
        assertEquals(-1, new RegularLandSymmetryCalculator().horizontalMirrorLocationOrMinusOne(land));
    }

    @Test
    public void shouldFindHorizontalMirror() {
        Land land = new Land(List.of("##", "..", ".."));
        assertEquals(2, new RegularLandSymmetryCalculator().horizontalMirrorLocationOrMinusOne(land));
    }

    @Test
    public void shouldReturnNoVerticalMirrorExists() {
        Land land = new Land(List.of("#.", "#."));
        assertEquals(-1, new RegularLandSymmetryCalculator().verticalMirrorLocationOrMinusOne(land));
    }

    @Test
    public void shouldFindVerticalMirror() {
        Land land = new Land(List.of("....", "#..#"));
        assertEquals(2, new RegularLandSymmetryCalculator().verticalMirrorLocationOrMinusOne(land));
    }

}