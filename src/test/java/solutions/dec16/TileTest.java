package solutions.dec16;

import org.junit.jupiter.api.Test;
import solutions.dec17.Direction;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TileTest {

    @Test
    public void emptySpaceTileShouldAllowBeamsToPassThrough() {
        Tile tile = Tile.EMPTY_SPACE;
        Beam beam = new Beam(0, 0, Direction.RIGHT);
        assertEquals(
                List.of(new Beam(0, 1, Direction.RIGHT)),
                tile.collide(beam)
        );
    }

    @Test
    public void diagonalLeftMirrorTileShouldReflectBeamGoingDown() {
        Tile tile = Tile.DIAGONAL_LEFT_MIRROR;
        Beam beam = new Beam(1, 1, Direction.DOWN);
        assertEquals(List.of(new Beam(1, 0, Direction.LEFT)), tile.collide(beam));
    }

    @Test
    public void diagonalLeftMirrorTileShouldReflectBeamGoingUp() {
        Tile tile = Tile.DIAGONAL_LEFT_MIRROR;
        Beam beam = new Beam(1, 1, Direction.UP);
        assertEquals(List.of(new Beam(1, 2, Direction.RIGHT)), tile.collide(beam));
    }

    @Test
    public void diagonalLeftMirrorShouldReflectBeamGoingRight() {
        Tile tile = Tile.DIAGONAL_LEFT_MIRROR;
        Beam beam = new Beam(1, 1, Direction.RIGHT);
        assertEquals(List.of(new Beam(0, 1, Direction.UP)), tile.collide(beam));
    }

    @Test
    public void diagonalLeftMirrorShouldReflectBeamGoingLeft() {
        Tile tile = Tile.DIAGONAL_LEFT_MIRROR;
        Beam beam = new Beam(1, 1, Direction.LEFT);
        assertEquals(List.of(new Beam(2, 1, Direction.DOWN)), tile.collide(beam));
    }

    @Test
    public void diagonalRightMirrorTileShouldReflectBeamGoingDown() {
        Tile tile = Tile.DIAGONAL_RIGHT_MIRROR;
        Beam beam = new Beam(1, 1, Direction.DOWN);
        assertEquals(List.of(new Beam(1, 2, Direction.RIGHT)), tile.collide(beam));
    }

    @Test
    public void diagonalRightMirrorTileShouldReflectBeamGoingUp() {
        Tile tile = Tile.DIAGONAL_RIGHT_MIRROR;
        Beam beam = new Beam(1, 1, Direction.UP);
        assertEquals(List.of(new Beam(1, 0, Direction.LEFT)), tile.collide(beam));
    }

    @Test
    public void diagonalRightMirrorShouldReflectBeamGoingRight() {
        Tile tile = Tile.DIAGONAL_RIGHT_MIRROR;
        Beam beam = new Beam(1, 1, Direction.RIGHT);
        assertEquals(List.of(new Beam(2, 1, Direction.DOWN)), tile.collide(beam));
    }

    @Test
    public void diagonalRightMirrorShouldReflectBeamGoingLeft() {
        Tile tile = Tile.DIAGONAL_RIGHT_MIRROR;
        Beam beam = new Beam(1, 1, Direction.LEFT);
        assertEquals(List.of(new Beam(0, 1, Direction.UP)), tile.collide(beam));
    }

    @Test
    public void verticalSplitterShouldAllowBeamsGoingDownPassThrough() {
        Tile tile = Tile.VERTICAL_SPLITTER;
        Beam beam = new Beam(1, 1, Direction.DOWN);
        assertEquals(List.of(new Beam(2, 1, Direction.DOWN)), tile.collide(beam));
    }

    @Test
    public void verticalSplitterShouldAllowBeamsGoingUpPassThrough() {
        Tile tile = Tile.VERTICAL_SPLITTER;
        Beam beam = new Beam(1, 1, Direction.UP);
        assertEquals(List.of(new Beam(0, 1, Direction.UP)), tile.collide(beam));
    }

    @Test
    public void verticalSplitterShouldSplitBeamsGoingRight() {
        Tile tile = Tile.VERTICAL_SPLITTER;
        Beam beam = new Beam(1, 1, Direction.RIGHT);
        List<Beam> beams = tile.collide(beam);
        assertEquals(2, beams.size());
        assertTrue(beams.contains(new Beam(0, 1, Direction.UP)));
        assertTrue(beams.contains(new Beam(2, 1, Direction.DOWN)));
    }

    @Test
    public void verticalSplitterShouldSplitBeamsGoingLeft() {
        Tile tile = Tile.VERTICAL_SPLITTER;
        Beam beam = new Beam(1, 1, Direction.LEFT);
        List<Beam> beams = tile.collide(beam);
        assertEquals(2, beams.size());
        assertTrue(beams.contains(new Beam(0, 1, Direction.UP)));
        assertTrue(beams.contains(new Beam(2, 1, Direction.DOWN)));
    }

    @Test
    public void horizontalSplitterShouldAllowBeamsGoingRightPassThrough() {
        Tile tile = Tile.HORIZONTAL_SPLITTER;
        Beam beam = new Beam(1, 1, Direction.RIGHT);
        assertEquals(List.of(new Beam(1, 2, Direction.RIGHT)), tile.collide(beam));
    }

    @Test
    public void horizontalSplitterShouldAllowBeamsGoingLeftPassThrough() {
        Tile tile = Tile.HORIZONTAL_SPLITTER;
        Beam beam = new Beam(1, 1, Direction.LEFT);
        assertEquals(List.of(new Beam(1, 0, Direction.LEFT)), tile.collide(beam));
    }

    @Test
    public void horizontalSplitterShouldSplitBeamsGoingDown() {
        Tile tile = Tile.HORIZONTAL_SPLITTER;
        Beam beam = new Beam(1, 1, Direction.DOWN);
        List<Beam> beams = tile.collide(beam);
        assertEquals(2, beams.size());
        assertTrue(beams.contains(new Beam(1, 0, Direction.LEFT)));
        assertTrue(beams.contains(new Beam(1, 2, Direction.RIGHT)));
    }

    @Test
    public void horizontalSplitterShouldSplitBeamsGoingUp() {
        Tile tile = Tile.HORIZONTAL_SPLITTER;
        Beam beam = new Beam(1, 1, Direction.UP);
        List<Beam> beams = tile.collide(beam);
        assertEquals(2, beams.size());
        assertTrue(beams.contains(new Beam(1, 0, Direction.LEFT)));
        assertTrue(beams.contains(new Beam(1, 2, Direction.RIGHT)));
    }


}