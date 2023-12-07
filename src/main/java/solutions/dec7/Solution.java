package solutions.dec7;

import java.util.List;

import static java.util.stream.Collectors.*;

public class Solution {

    private final HandParser handParser;

    public Solution(HandParser handParser) {
        this.handParser = handParser;
    }

    public int calculateTotalWinnings(List<String> input) {
        List<Hand> hands = input.stream()
                .map(handParser::parse)
                .sorted()
                .collect(toList());
        int res = 0;
        for (int i = 0; i < hands.size(); i++) {
            res += (i + 1) * hands.get(i).getBid();
        }
        return res;
    }
}
