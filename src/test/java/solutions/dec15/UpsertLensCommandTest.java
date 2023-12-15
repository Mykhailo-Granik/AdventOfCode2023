package solutions.dec15;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UpsertLensCommandTest {

    @Test
    public void shouldUpsertLens() {
        Boxes boxes = new Boxes(2);
        UpsertLensCommand underTest = new UpsertLensCommand("rn=1");
        underTest.apply(boxes);
        assertEquals(1, boxes.boxWithIndex(0).getScore());
    }

}