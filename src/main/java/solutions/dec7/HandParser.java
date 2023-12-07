package solutions.dec7;

public interface HandParser {

    Hand parse(String hand);

    default String cards(String hand) {
        return hand.substring(0, 5);
    }

    default int bid(String hand) {
        return Integer.parseInt(hand.substring(6));
    }

}
