package solutions.dec15;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BoxesTest {

    @Test
    public void shouldReturnBoxWithIndex() {
        Boxes boxes = new Boxes(3);
        assertEquals(new Box(0), boxes.boxWithIndex(0));
        assertEquals(new Box(1), boxes.boxWithIndex(1));
        assertEquals(new Box(2), boxes.boxWithIndex(2));
    }

    @Test
    public void shouldCalculateTotalScore() {
        Boxes boxes = new Boxes(4);
        boxes.boxWithIndex(0).addLens(new Lens("rn", 1));
        boxes.boxWithIndex(0).addLens(new Lens("cm", 2));
        boxes.boxWithIndex(3).addLens(new Lens("ot", 7));
        boxes.boxWithIndex(3).addLens(new Lens("ab", 5));
        boxes.boxWithIndex(3).addLens(new Lens("pc", 6));
        assertEquals(145, boxes.calculateTotalScore());
    }

}