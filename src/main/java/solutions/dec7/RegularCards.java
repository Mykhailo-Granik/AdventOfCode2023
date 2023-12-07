package solutions.dec7;

import java.util.List;
import java.util.Map;
import java.util.Objects;

import static java.util.stream.Collectors.*;

public class RegularCards extends Cards {

    private static final String ALL_CARDS_ORDERED = "23456789TJQKA";

    public RegularCards(String cards) {
        super(cards);
    }


    @Override
    protected List<Long> sortedCountsOfEachCard() {
        Map<Integer, Long> counts = cards.chars()
                .boxed()
                .collect(groupingBy(c -> c, counting()));
        return counts.values().stream()
                .sorted()
                .collect(toList());
    }

    @Override
    protected String cardsRanked() {
        return ALL_CARDS_ORDERED;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RegularCards cards1 = (RegularCards) o;
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
