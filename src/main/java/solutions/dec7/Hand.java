package solutions.dec7;

import java.util.Objects;

public class Hand implements Comparable<Hand> {

    private final Cards cards;
    private final int bid;

    public Hand(Cards cards, int bid) {
        this.cards = cards;
        this.bid = bid;
    }

    public int getBid() {
        return bid;
    }

    @Override
    public int compareTo(Hand other) {
        return cards.compareTo(other.cards);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hand hand = (Hand) o;
        return bid == hand.bid && Objects.equals(cards, hand.cards);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cards, bid);
    }

    @Override
    public String toString() {
        return "Hand{" +
                "cards=" + cards +
                ", bid=" + bid +
                '}';
    }
}
