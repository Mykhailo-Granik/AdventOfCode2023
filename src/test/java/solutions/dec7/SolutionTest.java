package solutions.dec7;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    public void shouldCalculateTotalWinningsForRegularCards() {
        assertEquals(6440, new Solution(new RegularHandParser()).calculateTotalWinnings(
                        List.of(
                                "32T3K 765",
                                "T55J5 684",
                                "KK677 28",
                                "KTJJT 220",
                                "QQQJA 483"
                        )
                )
        );
    }

    @Test
    public void shouldCalculateTotalWinningsForCardsWithJokers() {
        assertEquals(5905, new Solution(new HandWithJokersParser()).calculateTotalWinnings(
                        List.of(
                                "32T3K 765",
                                "T55J5 684",
                                "KK677 28",
                                "KTJJT 220",
                                "QQQJA 483"
                        )
                )
        );
    }

}