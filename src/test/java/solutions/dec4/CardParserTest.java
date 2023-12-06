package solutions.dec4;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CardParserTest {

    @Test
    public void shouldCorrectlyParseWinningNumbersInTheCard() {
        CardParser underTest = new CardParser();
        String cardAsString = "Card 1: 41 48 83 86 17 | 83 86  6 31 17  9 48 53";
        Card card = underTest.parse(cardAsString);
        assertEquals(List.of(41, 48, 83, 86, 17), card.getWinningNumbers());
    }

    @Test
    public void shouldCorrectlyParsePlayersNumbersInTheCard() {
        CardParser underTest = new CardParser();
        String cardAsString = "Card 1: 41 48 83 86 17 | 83 86  6 31 17  9 48 53";
        Card card = underTest.parse(cardAsString);
        assertEquals(List.of(83, 86, 6, 31, 17, 9, 48, 53), card.getPlayersNumbers());
    }

}