package solutions.dec4;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CardsCounterTest {

    @Test
    public void shouldReturnCorrectAmountOfCardsAndCopiesForOneCardWithoutMatches() {
        Card card = new Card(List.of(1),  List.of(2));
        assertEquals(1, new CardsCounter().countCardsAndCopies(List.of(card)));
    }

    @Test
    public void shouldReturnCorrectAmountOfForTwoCards() {
        List<Card> cards = List.of(
                new Card(List.of(1),  List.of(1)),
                new Card(List.of(1),  List.of(2))
        );
        assertEquals(3, new CardsCounter().countCardsAndCopies(cards));
    }

    @Test
    public void shouldReturnCorrectAmountForThreeCardsWithCopies() {
        List<Card> cards = List.of(
                new Card(List.of(1, 2),  List.of(1, 2)),
                new Card(List.of(1), List.of(1)),
                new Card(List.of(1), List.of(2))
        );
        assertEquals(7, new CardsCounter().countCardsAndCopies(cards));
    }

}