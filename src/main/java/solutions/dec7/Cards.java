package solutions.dec7;

import java.util.List;

public abstract class Cards implements Comparable<Cards> {

    protected final String cards;

    public Cards(String cards) {
        this.cards = cards;
    }

    protected abstract List<Long> sortedCountsOfEachCard();

    public boolean isFiveOfAKind() {
        return List.of(5L).equals(sortedCountsOfEachCard());
    }

    public boolean isFourOfAKind() {
        return List.of(1L, 4L).equals(sortedCountsOfEachCard());
    }

    public boolean isFullHouse() {
        return List.of(2L, 3L).equals(sortedCountsOfEachCard());
    }

    public boolean isThreeOfAKind() {
        return List.of(1L, 1L, 3L).equals(sortedCountsOfEachCard());
    }

    public boolean isTwoPairs() {
        return List.of(1L, 2L, 2L).equals(sortedCountsOfEachCard());
    }

    public boolean isOnePair() {
        return List.of(1L, 1L, 1L, 2L).equals(sortedCountsOfEachCard());
    }

    private int rank() {
        if (isFiveOfAKind()) {
            return 7;
        }
        if (isFourOfAKind()) {
            return 6;
        }
        if (isFullHouse()) {
            return 5;
        }
        if (isThreeOfAKind()) {
            return 4;
        }
        if (isTwoPairs()) {
            return 3;
        }
        if (isOnePair()) {
            return 2;
        }
        return 1;
    }

    @Override
    public int compareTo(Cards other) {
        if (this.getClass() != other.getClass()) {
            throw new IllegalArgumentException("Cannot compare different types of cards");
        }
        if (rank() != other.rank()) {
            return Integer.compare(rank(), other.rank());
        }
        return compareCardsOfSameRank(other);
    }

    private int compareCardsOfSameRank(Cards other) {
        for (int i = 0; i < cards.length(); i++) {
            if (cards.charAt(i) != other.cards.charAt(i)) {
                return Integer.compare(
                        cardsRanked().indexOf(cards.charAt(i)),
                        cardsRanked().indexOf(other.cards.charAt(i))
                );
            }
        }
        return 0;
    }

    protected abstract String cardsRanked();

}
