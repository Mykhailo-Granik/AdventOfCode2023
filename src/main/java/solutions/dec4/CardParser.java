package solutions.dec4;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.*;

public class CardParser {


    public Card parse(String cardAsString) {
        String[] cardParts = cardAsString.split(" ");
        return new Card(winningNumbers(cardParts), getPlayersNumbers(cardParts));
    }

    private List<Integer> winningNumbers(String[] cardParts) {
        return numbersFromCard(indexOfCardId(cardParts) + 1, indexOfSeparator(cardParts), cardParts);
    }

    private List<Integer> getPlayersNumbers(String[] cardParts) {
        return numbersFromCard(indexOfSeparator(cardParts) + 1, cardParts.length, cardParts);
    }

    private List<Integer> numbersFromCard(int startIndexInclusive, int endIndexExclusive, String[] cardParts) {
        return IntStream.range(startIndexInclusive, endIndexExclusive)
                .filter(i -> !cardParts[i].isEmpty())
                .mapToObj(i -> Integer.parseInt(cardParts[i]))
                .collect(toList());
    }

    private int indexOfCardId(String[] cardParts) {
        for (int i = 0; i < cardParts.length; i++) {
            if (cardParts[i].endsWith(":")) {
                return i;
            }
        }
        throw new IllegalArgumentException("Card id not found");
    }

    private int indexOfSeparator(String[] cardParts) {
        for (int i = 0; i < cardParts.length; i++) {
            if (cardParts[i].equals("|")) {
                return i;
            }
        }
        throw new IllegalArgumentException("Separator not found");
    }
}
