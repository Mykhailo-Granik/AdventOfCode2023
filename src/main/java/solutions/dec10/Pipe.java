package solutions.dec10;

import java.util.Collections;
import java.util.Set;

import static solutions.dec10.Direction.*;

public enum Pipe implements PipeActions {

    VERTICAL {
        @Override
        public Direction move(Direction previousDirection) {
            if ((previousDirection == UP) || (previousDirection == DOWN)) {
                return previousDirection;
            }
            return INVALID;
        }

        @Override
        public Set<Direction> allowedDirectionsToArriveFrom() {
            return Set.of(UP, DOWN);
        }
    },
    HORIZONTAL {
        @Override
        public Direction move(Direction previousDirection) {
            if ((previousDirection == LEFT) || (previousDirection == RIGHT)) {
                return previousDirection;
            }
            return INVALID;
        }

        @Override
        public Set<Direction> allowedDirectionsToArriveFrom() {
            return Set.of(LEFT, RIGHT);
        }
    },
    BEND_DOWN_RIGHT {
        @Override
        public Direction move(Direction previousDirection) {
            if (previousDirection == DOWN) {
                return RIGHT;
            }
            if (previousDirection == LEFT) {
                return UP;
            }
            return INVALID;
        }

        @Override
        public Set<Direction> allowedDirectionsToArriveFrom() {
            return Set.of(DOWN, LEFT);
        }
    },

    BEND_DOWN_LEFT {
        @Override
        public Direction move(Direction previousDirection) {
            if (previousDirection == DOWN) {
                return LEFT;
            }
            if (previousDirection == RIGHT) {
                return UP;
            }
            return INVALID;
        }

        @Override
        public Set<Direction> allowedDirectionsToArriveFrom() {
            return Set.of(DOWN, RIGHT);
        }
    },
    BEND_UP_LEFT {
        @Override
        public Direction move(Direction previousDirection) {
            if (previousDirection == UP) {
                return LEFT;
            }
            if (previousDirection == RIGHT) {
                return DOWN;
            }
            return INVALID;
        }

        @Override
        public Set<Direction> allowedDirectionsToArriveFrom() {
            return Set.of(UP, RIGHT);
        }
    },
    BEND_UP_RIGHT {
        @Override
        public Direction move(Direction previousDirection) {
            if (previousDirection == UP) {
                return RIGHT;
            }
            if (previousDirection == LEFT) {
                return DOWN;
            }
            return INVALID;
        }

        @Override
        public Set<Direction> allowedDirectionsToArriveFrom() {
            return Set.of(UP, LEFT);
        }
    },
    GROUND {
        @Override
        public Direction move(Direction previousDirection) {
            return INVALID;
        }

        @Override
        public Set<Direction> allowedDirectionsToArriveFrom() {
            return Collections.emptySet();
        }
    }

}
