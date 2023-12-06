package solutions.dec4;

import java.util.List;
import java.util.Objects;

public class Card {

    private final List<Integer> winningNumbers;
    private final List<Integer> playersNumbers;

    public Card(List<Integer> winningNumbers, List<Integer> playersNumbers) {
        this.winningNumbers = winningNumbers;
        this.playersNumbers = playersNumbers;
    }

    public int getScore() {
        long matchingNumbers = matchingNumbersCount();
        if (matchingNumbers == 0) {
            return 0;
        }
        return (int) Math.round(Math.pow(2, matchingNumbers - 1));
    }

    public int matchingNumbersCount() {
        return (int) playersNumbers.stream()
                .filter(winningNumbers::contains)
                .count();
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public List<Integer> getPlayersNumbers() {
        return playersNumbers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return Objects.equals(winningNumbers, card.winningNumbers) && Objects.equals(playersNumbers, card.playersNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winningNumbers, playersNumbers);
    }
}
