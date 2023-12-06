package solutions.dec4;

import java.util.List;

public class Solution4Dec1 {

    public int totalScore(List<String> cards) {
        return cards.stream()
                .mapToInt(this::scoreForCard)
                .sum();
    }

    private int scoreForCard(String card) {
        return new CardParser().parse(card).getScore();
    }

}
