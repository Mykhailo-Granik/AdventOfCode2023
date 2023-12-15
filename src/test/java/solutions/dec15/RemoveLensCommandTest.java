package solutions.dec15;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RemoveLensCommandTest {

    @Test
    public void shouldExecuteRemoveCommand() {
        Boxes boxes = new Boxes(2);
        boxes.boxWithIndex(1).addLens(new Lens("qp", 3));
        RemoveLensCommand underTest = new RemoveLensCommand("qp-");
        underTest.apply(boxes);
        assertEquals(0, boxes.boxWithIndex(1).getScore());
    }

}