package solutions.dec16;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TileFactoryTest {

    @Test
    public void shouldCreateEmptySpaceTile() {
        TileFactory tileFactory = new TileFactory();
        assertEquals(Tile.EMPTY_SPACE, tileFactory.create('.'));
    }

    @Test
    public void shouldCreateDiagonalLeftMirror() {
        TileFactory tileFactory = new TileFactory();
        assertEquals(Tile.DIAGONAL_LEFT_MIRROR, tileFactory.create('/'));
    }

    @Test
    public void shouldCreateDiagonalRightMirror() {
        TileFactory tileFactory = new TileFactory();
        assertEquals(Tile.DIAGONAL_RIGHT_MIRROR, tileFactory.create('\\'));
    }

    @Test
    public void shouldCreateVerticalSplitter() {
        TileFactory tileFactory = new TileFactory();
        assertEquals(Tile.VERTICAL_SPLITTER, tileFactory.create('|'));
    }

    @Test
    public void shouldCreateHorizontalSplitter() {
        TileFactory tileFactory = new TileFactory();
        assertEquals(Tile.HORIZONTAL_SPLITTER, tileFactory.create('-'));
    }

    @Test
    public void shouldThrowExceptionForUnknownTile() {
        TileFactory tileFactory = new TileFactory();
        assertThrows(IllegalArgumentException.class, () -> tileFactory.create('x'));
    }

}