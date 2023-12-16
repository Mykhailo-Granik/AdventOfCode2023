package solutions.dec16;

import java.util.List;

import static solutions.dec16.Direction.*;

public enum Tile implements BeamCollision {

    DIAGONAL_LEFT_MIRROR {
        @Override
        public List<Beam> collide(Beam beam) {
            switch (beam.getDirection()) {
                case DOWN:
                    return List.of(beam.withDirection(LEFT).move());
                case UP:
                    return List.of(beam.withDirection(RIGHT).move());
                case RIGHT:
                    return List.of(beam.withDirection(UP).move());
                case LEFT:
                    return List.of(beam.withDirection(DOWN).move());
                default:
                    throw new IllegalStateException("Unexpected value: " + beam.getDirection());
            }
        }
    },
    DIAGONAL_RIGHT_MIRROR {
        @Override
        public List<Beam> collide(Beam beam) {
            switch (beam.getDirection()) {
                case DOWN:
                    return List.of(beam.withDirection(RIGHT).move());
                case UP:
                    return List.of(beam.withDirection(LEFT).move());
                case RIGHT:
                    return List.of(beam.withDirection(DOWN).move());
                case LEFT:
                    return List.of(beam.withDirection(UP).move());
                default:
                    throw new IllegalStateException("Unexpected value: " + beam.getDirection());
            }
        }
    },
    EMPTY_SPACE {
        @Override
        public List<Beam> collide(Beam beam) {
            return List.of(beam.move());
        }
    },
    VERTICAL_SPLITTER {
        @Override
        public List<Beam> collide(Beam beam) {
            switch (beam.getDirection()) {
                case DOWN:
                case UP:
                    return List.of(beam.move());
                case RIGHT:
                case LEFT:
                    return List.of(beam.withDirection(UP).move(), beam.withDirection(DOWN).move());
                default:
                    throw new IllegalStateException("Unexpected value: " + beam.getDirection());
            }
        }
    },
    HORIZONTAL_SPLITTER {
        @Override
        public List<Beam> collide(Beam beam) {
            switch (beam.getDirection()) {
                case RIGHT:
                case LEFT:
                    return List.of(beam.move());
                case DOWN:
                case UP:
                    return List.of(beam.withDirection(RIGHT).move(), beam.withDirection(LEFT).move());
                default:
                    throw new IllegalStateException("Unexpected value: " + beam.getDirection());
            }
        }
    }


}
