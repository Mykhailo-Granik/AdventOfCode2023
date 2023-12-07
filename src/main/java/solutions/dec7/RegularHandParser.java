package solutions.dec7;

public class RegularHandParser implements HandParser {
    @Override
    public Hand parse(String hand) {
        return new Hand(
                new RegularCards(cards(hand)),
                bid(hand)
        );
    }
}
