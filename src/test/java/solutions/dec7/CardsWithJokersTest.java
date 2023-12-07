package solutions.dec7;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CardsWithJokersTest {

    @Test
    public void shouldCorrectlyReturnNotFiveOfAKind() {
        CardsWithJokers underTest = new CardsWithJokers("AAAAT");
        assertFalse(underTest.isFiveOfAKind());
    }

    @Test
    public void shouldCorrectlyReturnFiveOfAKind() {
        CardsWithJokers underTest = new CardsWithJokers("AAAAA");
        assertTrue(underTest.isFiveOfAKind());
    }
    
    @Test
    public void shouldCorrectlyReturnFiveOfAKindWithJokers() {
        CardsWithJokers underTest = new CardsWithJokers("AAAAJ");
        assertTrue(underTest.isFiveOfAKind());
    }

    @Test
    public void shouldCorrectlyReturnFiveOfAKindForFiveJokers() {
        CardsWithJokers underTest = new CardsWithJokers("JJJJJ");
        assertTrue(underTest.isFiveOfAKind());
    }

    @Test
    public void shouldCorrectlyReturnNotFourOfAKind() {
        CardsWithJokers underTest = new CardsWithJokers("AAAT2");
        assertFalse(underTest.isFourOfAKind());
    }

    @Test
    public void shouldCorrectlyReturnFourOfAKind() {
        CardsWithJokers underTest = new CardsWithJokers("AAAA2");
        assertTrue(underTest.isFourOfAKind());
    }
    
    @Test
    public void shouldCorrectlyReturnFourOfAKindWithJokers() {
        CardsWithJokers underTest = new CardsWithJokers("AAA2J");
        assertTrue(underTest.isFourOfAKind());
    }

    @Test
    public void shouldCorrectlyReturnNotAFullHouse() {
        CardsWithJokers underTest = new CardsWithJokers("AAAT2");
        assertFalse(underTest.isFullHouse());
    }

    @Test
    public void shouldCorrectlyReturnAFullHouse() {
        CardsWithJokers underTest = new CardsWithJokers("AAATT");
        assertTrue(underTest.isFullHouse());
    }
    
    @Test
    public void shouldCorrectlyReturnAFullHouseWithJokers() {
        CardsWithJokers underTest = new CardsWithJokers("AAJTT");
        assertTrue(underTest.isFullHouse());
    }

    @Test
    public void shouldCorrectlyReturnNotThreeOfAKind() {
        CardsWithJokers underTest = new CardsWithJokers("AAQTT");
        assertFalse(underTest.isThreeOfAKind());
    }

    @Test
    public void shouldCorrectlyReturnThreeOfAKind() {
        CardsWithJokers underTest = new CardsWithJokers("AAAQT");
        assertTrue(underTest.isThreeOfAKind());
    }
    
    @Test
    public void shouldCorrectlyReturnThreeOfAKindWithJokers() {
        CardsWithJokers underTest = new CardsWithJokers("AAQJT");
        assertTrue(underTest.isThreeOfAKind());
    }

    @Test
    public void shouldCorrectlyReturnNotTwoPair() {
        CardsWithJokers underTest = new CardsWithJokers("AA978");
        assertFalse(underTest.isTwoPairs());
    }

    @Test
    public void shouldCorrectlyReturnTwoPair() {
        CardsWithJokers underTest = new CardsWithJokers("AAQQK");
        assertTrue(underTest.isTwoPairs());
    }

    @Test
    public void shouldCorrectlyReturnNotOnePair() {
        CardsWithJokers underTest = new CardsWithJokers("23456");
        assertFalse(underTest.isOnePair());
    }

    @Test
    public void shouldCorrectlyReturnOnePair() {
        CardsWithJokers underTest = new CardsWithJokers("23345");
        assertTrue(underTest.isOnePair());
    }

    @Test
    public void shouldCorrectlyReturnOnePairWithJokers() {
        CardsWithJokers underTest = new CardsWithJokers("2J345");
        assertTrue(underTest.isOnePair());
    }

    @Test
    public void shouldCorrectlySortCards() {
        List<CardsWithJokers> cardHands = new ArrayList<>(
                List.of(
                        new CardsWithJokers("32T3K"),
                        new CardsWithJokers("T55J5"),
                        new CardsWithJokers("KK677"),
                        new CardsWithJokers("KTJJT"),
                        new CardsWithJokers("QQQJA")
                )
        );
        List<CardsWithJokers> expected = List.of(
                new CardsWithJokers("32T3K"),
                new CardsWithJokers("KK677"),
                new CardsWithJokers("T55J5"),
                new CardsWithJokers("QQQJA"),
                new CardsWithJokers("KTJJT")
        );
        Collections.sort(cardHands);
        assertEquals(expected, cardHands);
    }
    
}