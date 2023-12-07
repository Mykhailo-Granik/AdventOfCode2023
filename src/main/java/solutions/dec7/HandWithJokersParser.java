package solutions.dec7;

public class HandWithJokersParser implements HandParser {
    @Override
    public Hand parse(String hand) {
        return new Hand(
                new CardsWithJokers(cards(hand)),
                bid(hand)
        );
    }
}
