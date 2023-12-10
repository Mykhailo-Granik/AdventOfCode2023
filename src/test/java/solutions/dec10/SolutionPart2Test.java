package solutions.dec10;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionPart2Test {

    @Test
    public void shouldFindNumberOfPointsInsideCycle() {
        SolutionPart2 underTest = new SolutionPart2();
        assertEquals(
                4,
                underTest.findNumberOfPointsInsideCycle(
                        List.of(
                                "...........",
                                ".S-------7.",
                                ".|F-----7|.",
                                ".||.....||.",
                                ".||.....||.",
                                ".|L-7.F-J|.",
                                ".|..|.|..|.",
                                ".L--J.L--J.",
                                "..........."
                        )
                )
        );
    }

}