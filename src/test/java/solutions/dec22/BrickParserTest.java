package solutions.dec22;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BrickParserTest {

    @Test
    public void shouldParseABrick() {
        BrickParser underTest = new BrickParser();
        String brickDescription = "1,0,1~1,2,1";
        assertEquals(
                new Brick(
                        new Point3D(1, 0, 1),
                        new Point3D(1, 2, 1)
                ),
                underTest.parse(brickDescription)
        );
    }

}