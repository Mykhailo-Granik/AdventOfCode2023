package solutions.dec15;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BoxTest {

    @Test
    public void shouldReturnZeroScoreForEmptyBox() {
        Box box = new Box(0);
        assertEquals(0, box.getScore());
    }

    @Test
    public void shouldCalculateScoreWhenAddedALens() {
        Box box = new Box(0);
        box.addLens(new Lens("abc", 2));
        assertEquals(2, box.getScore());
    }

    @Test
    public void shouldCalculateScoreWhenLensesAreRemoved() {
        Box box = new Box(1);
        box.addLens(new Lens("abc", 2));
        box.addLens(new Lens("def", 3));
        box.addLens(new Lens("ghi", 4));
        box.removeLensWithLabel("def");
        assertEquals(20, box.getScore());
    }

    @Test
    public void shouldCalculateScoreWhenFocalLengthIsChanged() {
        Box box = new Box(1);
        box.addLens(new Lens("abc", 2));
        box.addLens(new Lens("def", 3));
        box.addLens(new Lens("ghi", 4));
        box.removeLensWithLabel("def");
        box.addLens(new Lens("ghi", 5));
        assertEquals(24, box.getScore());
    }

}