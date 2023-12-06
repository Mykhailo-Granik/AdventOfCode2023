package solutions.dec3;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NumberInGridTest {

    @Test
    public void shouldCorrectlyReturnValue() {
        NumberInGrid underTest = new NumberInGrid(List.of(".123."), 0, 1, 4);
        assertEquals(123, underTest.getNumericalValue());
    }

    @Test
    public void shouldReturnNoNeighboursWhenNumberDoesNotNeighbourACharacter() {
        NumberInGrid underTest = new NumberInGrid(List.of(".....", ".123.", "....."), 1, 1, 4);
        assertFalse(underTest.hasNeighbouringCharacter());
    }

    @Test
    public void shoutReturnNeighboursExistsWhenNumberHasACharacterToTheLeft() {
        NumberInGrid underTest = new NumberInGrid(List.of(".....", "a123.", "....."), 1, 1, 4);
        assertTrue(underTest.hasNeighbouringCharacter());
    }

    @Test
    public void shouldReturnNeighboursExistsWhenNumberHasACharacterToTheRight() {
        NumberInGrid underTest = new NumberInGrid(List.of(".....", ".123a", "....."), 1, 1, 4);
        assertTrue(underTest.hasNeighbouringCharacter());
    }

    @Test
    public void shouldReturnNeighboursExistsWhenNumberHasACharacterAbove() {
        NumberInGrid underTest = new NumberInGrid(List.of("...a.", ".123.", "....."), 1, 1, 4);
        assertTrue(underTest.hasNeighbouringCharacter());
    }

    @Test
    public void shouldReturnNeighboursExistsWhenNumberHasACharacterBelow() {
        NumberInGrid underTest = new NumberInGrid(List.of(".....", ".123.", "...a."), 1, 1, 4);
        assertTrue(underTest.hasNeighbouringCharacter());
    }

    @Test
    public void shouldReturnNeighborsExistWhenNumberHasACharacterDiagonallyAbove() {
        NumberInGrid underTest = new NumberInGrid(List.of("....a", ".123.", "....."), 1, 1, 4);
        assertTrue(underTest.hasNeighbouringCharacter());
    }

    @Test
    public void shouldReturnNeighborsExistWhenNumberHasACharacterDiagonallyBelow() {
        NumberInGrid underTest = new NumberInGrid(List.of(".....", ".123.", "a...."), 1, 1, 4);
        assertTrue(underTest.hasNeighbouringCharacter());
    }

}