package solutions.dec7;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import static java.util.stream.Collectors.*;

public class CardsWithJokers extends Cards {

    private static final String ALL_CARDS_ORDERED = "J23456789TQKA";

    public CardsWithJokers(String cards) {
        super(cards);
    }

    @Override
    protected List<Long> sortedCountsOfEachCard() {
        long jokerCount = cards.chars().mapToObj(c -> (char) c).filter(c -> c == 'J').count();
        Map<Character, Long> nonJokerCounts = cards.chars()
                .mapToObj(c -> (char) c)
                .filter(c -> c != 'J')
                .collect(groupingBy(c -> c, counting()));
        List<Long> sortedCountValues =
                nonJokerCounts.values().stream()
                        .sorted()
                        .collect(toList());
        if (sortedCountValues.size() == 0) {
            sortedCountValues.add(jokerCount);
        } else {
            sortedCountValues.set(sortedCountValues.size() - 1,
                    sortedCountValues.get(sortedCountValues.size() - 1) + jokerCount);
        }
        return sortedCountValues;
    }

    @Override
    protected String cardsRanked() {
        return ALL_CARDS_ORDERED;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CardsWithJokers cards1 = (CardsWithJokers) o;
        return Objects.equals(cards, cards1.cards);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cards);
    }

    @Override
    public String toString() {
        return cards;
    }
}
