package solutions.dec10;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static solutions.dec10.Direction.*;

class PipeTest {

    @Test
    public void forVerticalPipeAllowedDirectionsToArriveFromShouldReturnUpAndDown() {
        assertEquals(Set.of(UP, DOWN), Pipe.VERTICAL.allowedDirectionsToArriveFrom());
    }

    @Test
    public void forVerticalPipeIfMovesDownShouldMoveDown() {
        assertEquals(DOWN, Pipe.VERTICAL.move(DOWN));
    }

    @Test
    public void forVerticalPipeIfMovesUpShouldMoveUp() {
        assertEquals(UP, Pipe.VERTICAL.move(UP));
    }

    @Test
    public void forVerticalPipeIfMovesLeftShouldReturnInvalid() {
        assertEquals(INVALID, Pipe.VERTICAL.move(LEFT));
    }

    @Test
    public void forVerticalPipeIfMovesRightShouldReturnInvalid() {
        assertEquals(INVALID, Pipe.VERTICAL.move(RIGHT));
    }

    @Test
    public void forHorizontalPipeAllowedDirectionsToArriveFromShouldReturnLeftAndRight() {
        assertEquals(Set.of(LEFT, RIGHT), Pipe.HORIZONTAL.allowedDirectionsToArriveFrom());
    }

    @Test
    public void forHorizontalPipeIfMovesLeftShouldMoveLeft() {
        assertEquals(LEFT, Pipe.HORIZONTAL.move(LEFT));
    }

    @Test
    public void forHorizontalPipeIfMovesRightShouldMoveRight() {
        assertEquals(RIGHT, Pipe.HORIZONTAL.move(RIGHT));
    }

    @Test
    public void forHorizontalPipeIfMovesUpShouldReturnInvalid() {
        assertEquals(INVALID, Pipe.HORIZONTAL.move(UP));
    }

    @Test
    public void forHorizontalPipeIfMovesDownShouldReturnInvalid() {
        assertEquals(INVALID, Pipe.HORIZONTAL.move(DOWN));
    }

    @Test
    public void forBendDownRightPipeAllowedDirectionsToArriveFromShouldReturnUpAndLeft() {
        assertEquals(Set.of(DOWN, LEFT), Pipe.BEND_DOWN_RIGHT.allowedDirectionsToArriveFrom());
    }

    @Test
    public void forBendDownRightPipeIfMovesDownShouldMoveRight() {
        assertEquals(RIGHT, Pipe.BEND_DOWN_RIGHT.move(DOWN));
    }

    @Test
    public void forBendDownRightPipeIfMovesLeftShouldMoveUp() {
        assertEquals(UP, Pipe.BEND_DOWN_RIGHT.move(LEFT));
    }

    @Test
    public void forBendDownRightPipeIfMovesUpShouldReturnInvalid() {
        assertEquals(INVALID, Pipe.BEND_DOWN_RIGHT.move(UP));
    }

    @Test
    public void forBendDownRightPipeIfMovesRightShouldReturnInvalid() {
        assertEquals(INVALID, Pipe.BEND_DOWN_RIGHT.move(RIGHT));
    }

    @Test
    public void forBendDownLeftPipeAllowedDirectionsToArriveFromShouldReturnDownAndRight() {
        assertEquals(Set.of(DOWN, RIGHT), Pipe.BEND_DOWN_LEFT.allowedDirectionsToArriveFrom());
    }

    @Test
    public void forBendDownLeftPipeIfMovesDownShouldMoveLeft() {
        assertEquals(LEFT, Pipe.BEND_DOWN_LEFT.move(DOWN));
    }

    @Test
    public void forBendDownLeftPipeIfMovesRightShouldMoveUp() {
        assertEquals(UP, Pipe.BEND_DOWN_LEFT.move(RIGHT));
    }

    @Test
    public void forBendDownLeftPipeIfMovesUpShouldReturnInvalid() {
        assertEquals(INVALID, Pipe.BEND_DOWN_LEFT.move(UP));
    }

    @Test
    public void forBendDownLeftPipeIfMovesLeftShouldReturnInvalid() {
        assertEquals(INVALID, Pipe.BEND_DOWN_LEFT.move(LEFT));
    }

    @Test
    public void forBendUpLeftPipeAllowedDirectionsToArriveFromShouldReturnUpAndRight() {
        assertEquals(Set.of(UP, RIGHT), Pipe.BEND_UP_LEFT.allowedDirectionsToArriveFrom());
    }

    @Test
    public void forBendUpLeftPipeIfMovesUpShouldMoveLeft() {
        assertEquals(LEFT, Pipe.BEND_UP_LEFT.move(UP));
    }

    @Test
    public void forBendUpLeftPipeIfMovesRightShouldMoveDown() {
        assertEquals(DOWN, Pipe.BEND_UP_LEFT.move(RIGHT));
    }

    @Test
    public void forBendUpLeftPipeIfMovesDownShouldReturnInvalid() {
        assertEquals(INVALID, Pipe.BEND_UP_LEFT.move(DOWN));
    }

    @Test
    public void forBendUpLeftPipeIfMovesLeftShouldReturnInvalid() {
        assertEquals(INVALID, Pipe.BEND_UP_LEFT.move(LEFT));
    }

    @Test
    public void forBendUpRightPipeAllowedDirectionsToArriveFromShouldReturnUpAndLeft() {
        assertEquals(Set.of(UP, LEFT), Pipe.BEND_UP_RIGHT.allowedDirectionsToArriveFrom());
    }

    @Test
    public void forBendUpRightPipeIfMovesUpShouldMoveRight() {
        assertEquals(RIGHT, Pipe.BEND_UP_RIGHT.move(UP));
    }

    @Test
    public void forBendUpRightPipeIfMovesLeftShouldMoveDown() {
        assertEquals(DOWN, Pipe.BEND_UP_RIGHT.move(LEFT));
    }

    @Test
    public void forBendUpRightPipeIfMovesDownShouldReturnInvalid() {
        assertEquals(INVALID, Pipe.BEND_UP_RIGHT.move(DOWN));
    }

    @Test
    public void forBendUpRightPipeIfMovesRightShouldReturnInvalid() {
        assertEquals(INVALID, Pipe.BEND_UP_RIGHT.move(RIGHT));
    }

    @Test
    public void forGroundThereAreNoAllowedDirectionsToArriveFrom() {
        assertEquals(Set.of(), Pipe.GROUND.allowedDirectionsToArriveFrom());
    }

    @Test
    public void forGroundIfMovesUpShouldReturnInvalid() {
        assertEquals(INVALID, Pipe.GROUND.move(UP));
    }

    @Test
    public void forGroundIfMovesDownShouldReturnInvalid() {
        assertEquals(INVALID, Pipe.GROUND.move(DOWN));
    }

    @Test
    public void forGroundIfMovesLeftShouldReturnInvalid() {
        assertEquals(INVALID, Pipe.GROUND.move(LEFT));
    }

    @Test
    public void forGroundIfMovesRightShouldReturnInvalid() {
        assertEquals(INVALID, Pipe.GROUND.move(RIGHT));
    }

}