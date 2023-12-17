package solutions.dec17;

import java.util.Set;

public enum Direction {

    UP(-1, 0) {
        @Override
        public Set<Direction> rotations() {
            return Set.of(LEFT, RIGHT);
        }
    },
    DOWN(1, 0) {
        @Override
        public Set<Direction> rotations() {
            return Set.of(LEFT, RIGHT);
        }
    },
    LEFT(0, -1) {
        @Override
        public Set<Direction> rotations() {
            return Set.of(UP, DOWN);
        }
    },
    RIGHT(0, 1) {
        @Override
        public Set<Direction> rotations() {
            return Set.of(UP, DOWN);
        }
    };

    private final int deltaRow;
    private final int deltaColumn;


    Direction(int deltaRow, int deltaColumn) {
        this.deltaRow = deltaRow;
        this.deltaColumn = deltaColumn;
    }

    public int getDeltaRow() {
        return deltaRow;
    }

    public int getDeltaColumn() {
        return deltaColumn;
    }

    public abstract Set<Direction> rotations();
}
