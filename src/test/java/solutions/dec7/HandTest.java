package solutions.dec7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HandTest {

    @Test
    public void shouldTellOneHandIsSmallerThanOther() {
        Hand hand1 = new Hand(new RegularCards("34AA2"), 1);
        Hand hand2 = new Hand(new RegularCards("23353"), 1);
        assertEquals(-1, hand1.compareTo(hand2));
    }

    @Test
    public void shouldTellOneHandIsBiggerThanOther() {
        Hand hand1 = new Hand(new RegularCards("34AA2"), 1);
        Hand hand2 = new Hand(new RegularCards("2345T"), 1);
        assertEquals(1, hand1.compareTo(hand2));
    }

    @Test
    public void shouldTellHandsAreEqual() {
        Hand hand1 = new Hand(new RegularCards("34AA2"), 1);
        Hand hand2 = new Hand(new RegularCards("34AA2"), 2);
        assertEquals(0, hand1.compareTo(hand2));
    }

}