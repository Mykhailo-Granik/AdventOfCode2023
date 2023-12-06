package solutions.dec4;

import java.util.ArrayList;
import java.util.List;

public class CardsCounter {


    public int countCardsAndCopies(List<Card> cards) {
        List<Integer> cardsCounts = new ArrayList<>();
        for (int i = 0; i < cards.size(); i++) {
            cardsCounts.add(1);
        }
        for (int i = 0; i < cardsCounts.size(); ++i) {
            int matchesInCards = cards.get(i).matchingNumbersCount();
            for (int j = i + 1; j < i + matchesInCards + 1; ++j) {
                cardsCounts.set(j, cardsCounts.get(j) + cardsCounts.get(i));
            }
        }
        return cardsCounts.stream().mapToInt(Integer::intValue).sum();
    }
}
