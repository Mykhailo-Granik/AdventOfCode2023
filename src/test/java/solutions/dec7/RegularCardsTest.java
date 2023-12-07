package solutions.dec7;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RegularCardsTest {

    @Test
    public void shouldCorrectlyReturnNotFiveOfAKind() {
        RegularCards underTest = new RegularCards("AAAAT");
        assertFalse(underTest.isFiveOfAKind());
    }

    @Test
    public void shouldCorrectlyReturnFiveOfAKind() {
        RegularCards underTest = new RegularCards("AAAAA");
        assertTrue(underTest.isFiveOfAKind());
    }

    @Test
    public void shouldCorrectlyReturnNotFourOfAKind() {
        RegularCards underTest = new RegularCards("AAAT2");
        assertFalse(underTest.isFourOfAKind());
    }

    @Test
    public void shouldCorrectlyReturnFourOfAKind() {
        RegularCards underTest = new RegularCards("AAAA2");
        assertTrue(underTest.isFourOfAKind());
    }

    @Test
    public void shouldCorrectlyReturnNotAFullHouse() {
        RegularCards underTest = new RegularCards("AAAT2");
        assertFalse(underTest.isFullHouse());
    }

    @Test
    public void shouldCorrectlyReturnAFullHouse() {
        RegularCards underTest = new RegularCards("AAATT");
        assertTrue(underTest.isFullHouse());
    }

    @Test
    public void shouldCorrectlyReturnNotThreeOfAKind() {
        RegularCards underTest = new RegularCards("AAJTT");
        assertFalse(underTest.isThreeOfAKind());
    }

    @Test
    public void shouldCorrectlyReturnThreeOfAKind() {
        RegularCards underTest = new RegularCards("AAAJT");
        assertTrue(underTest.isThreeOfAKind());
    }

    @Test
    public void shouldCorrectlyReturnNotTwoPair() {
        RegularCards underTest = new RegularCards("AA978");
        assertFalse(underTest.isTwoPairs());
    }

    @Test
    public void shouldCorrectlyReturnTwoPair() {
        RegularCards underTest = new RegularCards("AAJJK");
        assertTrue(underTest.isTwoPairs());
    }

    @Test
    public void shouldCorrectlyReturnNotOnePair() {
        RegularCards underTest = new RegularCards("23456");
        assertFalse(underTest.isOnePair());
    }

    @Test
    public void shouldCorrectlyReturnOnePair() {
        RegularCards underTest = new RegularCards("23345");
        assertTrue(underTest.isOnePair());
    }

    @Test
    public void shouldCorrectlySortCardsOfDifferentRanks() {
        List<RegularCards> cardHands = new ArrayList<>(
                List.of(
                        new RegularCards("ATAAA"),
                        new RegularCards("99999"),
                        new RegularCards("22345"),
                        new RegularCards("22334"),
                        new RegularCards("22333"),
                        new RegularCards("79998"),
                        new RegularCards("AKQJT")
                )
        );
        List<RegularCards> expected = List.of(
                new RegularCards("AKQJT"),
                new RegularCards("22345"),
                new RegularCards("22334"),
                new RegularCards("79998"),
                new RegularCards("22333"),
                new RegularCards("ATAAA"),
                new RegularCards("99999")
        );
        Collections.sort(cardHands);
        assertEquals(expected, cardHands);
    }

    @Test
    public void shouldCorrectlyCompareCardsOfSameRank() {
        RegularCards firstHand = new RegularCards("33332");
        RegularCards secondHand = new RegularCards("2AAAA");
        assertEquals(1, firstHand.compareTo(secondHand));
    }

    @Test
    public void shouldCorrectlyCompareEqualCards() {
        RegularCards firstHand = new RegularCards("33332");
        RegularCards secondHand = new RegularCards("33332");
        assertEquals(0, firstHand.compareTo(secondHand));
    }


}