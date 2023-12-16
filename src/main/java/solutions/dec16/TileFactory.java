package solutions.dec16;

import static solutions.dec16.Tile.*;

public class TileFactory {

    public Tile create(char c) {
        switch (c) {
            case '.':
                return EMPTY_SPACE;
            case '/':
                return DIAGONAL_LEFT_MIRROR;
            case '\\':
                return DIAGONAL_RIGHT_MIRROR;
            case '|':
                return VERTICAL_SPLITTER;
            case '-':
                return HORIZONTAL_SPLITTER;
            default:
                throw new IllegalArgumentException("Unknown tile: " + c);
        }
    }

}
