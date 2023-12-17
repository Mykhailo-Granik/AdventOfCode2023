package solutions.dec17;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DirectionTest {

    @Test
    public void directionUpShouldReturnRotationsLeftAndRight() {
        Direction direction = Direction.UP;
        assertEquals(Set.of(Direction.LEFT, Direction.RIGHT), direction.rotations());
    }

    @Test
    public void directionDownShouldReturnRotationsLeftAndRight() {
        Direction direction = Direction.DOWN;
        assertEquals(Set.of(Direction.LEFT, Direction.RIGHT), direction.rotations());
    }

    @Test
    public void directionLeftShouldReturnRotationsUpAndDown() {
        Direction direction = Direction.LEFT;
        assertEquals(Set.of(Direction.UP, Direction.DOWN), direction.rotations());
    }

    @Test
    public void directionRightShouldReturnRotationsUpAndDown() {
        Direction direction = Direction.RIGHT;
        assertEquals(Set.of(Direction.UP, Direction.DOWN), direction.rotations());
    }

}