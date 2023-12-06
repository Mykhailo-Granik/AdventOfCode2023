package solutions.dec4;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CardTest {

    @Test
    public void shouldReturnZeroScoreWhenNoMatchingNumbers() {
        Card card = new Card(List.of(1, 2, 3), List.of(4, 5, 6));
        assertEquals(0, card.getScore());
    }

    @Test
    public void shouldReturnZeroMatchingNumbers() {
        Card card = new Card(List.of(1, 2, 3), List.of(4, 5, 6));
        assertEquals(0, card.matchingNumbersCount());
    }

    @Test
    public void shouldReturnScoreOfOneWhenOneMatchingNumber() {
        Card card = new Card(List.of(1, 2, 3), List.of(1, 4, 5));
        assertEquals(1, card.getScore());
    }

    @Test
    public void shouldCorrectlyReturnOneMatchingNumber() {
        Card card = new Card(List.of(1, 2, 3), List.of(1, 4, 5));
        assertEquals(1, card.matchingNumbersCount());
    }

    @Test
    public void shouldReturnScoreOfTwoWhenTwoMatchingNumbers() {
        Card card = new Card(List.of(1, 2, 3), List.of(1, 2, 4));
        assertEquals(2, card.getScore());
    }

    @Test
    public void shouldCorrectlyReturnTwoMatchingNumbers() {
        Card card = new Card(List.of(1, 2, 3), List.of(1, 2, 4));
        assertEquals(2, card.matchingNumbersCount());
    }

    @Test
    public void shouldReturnScoreOfFourWhenThreeMatchingNumbers() {
        Card card = new Card(List.of(1, 2, 3), List.of(1, 2, 3));
        assertEquals(4, card.getScore());
    }

    @Test
    public void shouldCorrectlyReturnThreeMatchingNumbers() {
        Card card = new Card(List.of(1, 2, 3), List.of(1, 2, 3));
        assertEquals(3, card.matchingNumbersCount());
    }

}