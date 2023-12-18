package solutions.dec18;

public enum Direction {

    UP(-1, 0),
    DOWN(1, 0),
    LEFT(0, -1),
    RIGHT(0, 1);

    private final int deltaY;
    private final int deltaX;


    Direction(int deltaY, int deltaX) {
        this.deltaY = deltaY;
        this.deltaX = deltaX;
    }

    public int getDeltaY() {
        return deltaY;
    }

    public int getDeltaX() {
        return deltaX;
    }

    public static Direction fromString(String direction) {
        switch (direction) {
            case "U":
                return UP;
            case "D":
                return DOWN;
            case "L":
                return LEFT;
            case "R":
                return RIGHT;
            default:
                throw new IllegalArgumentException("Unknown direction: " + direction);
        }
    }

    public static Direction fromDigitString(String digit) {
        switch (digit) {
            case "0":
                return RIGHT;
            case "1":
                return DOWN;
            case "2":
                return LEFT;
            case "3":
                return UP;
            default:
                throw new IllegalArgumentException("Unknown digit: " + digit);
        }
    }

}
