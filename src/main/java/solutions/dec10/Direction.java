package solutions.dec10;

public enum Direction {
    UP(0, -1),
    DOWN(0, 1),
    LEFT(-1, 0),
    RIGHT(1, 0),
    RIGHT_DOWN(1, 1),
    RIGHT_UP(1, -1),
    LEFT_DOWN(-1, 1),
    LEFT_UP(-1, -1),
    INVALID(0, 0);

    private final int deltaX;
    private final int deltaY;

    public int getDeltaX() {
        return deltaX;
    }

    public int getDeltaY() {
        return deltaY;
    }

    Direction(int deltaX, int deltaY) {
        this.deltaX = deltaX;
        this.deltaY = deltaY;
    }
}
