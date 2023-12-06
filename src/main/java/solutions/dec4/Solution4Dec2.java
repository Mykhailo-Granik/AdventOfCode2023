package solutions.dec4;

import java.util.List;
import java.util.stream.Collectors;

public class Solution4Dec2 {

    public int totalAmountOfCards(List<String> cards) {
        return new CardsCounter().countCardsAndCopies(parsedCards(cards));
    }

    private List<Card> parsedCards(List<String> cards) {
        return cards.stream()
                .map(card -> new CardParser().parse(card))
                .collect(Collectors.toList());
    }

}
