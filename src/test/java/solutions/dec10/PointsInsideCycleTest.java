package solutions.dec10;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PointsInsideCycleTest {

    @Test
    public void shouldCalculateNumberOfPointsInsideCycle() {
        Grid grid = new Grid(
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
        );
        assertEquals(4, new PointsInsideCycle().calculateAmount(grid));
    }

    @Test
    public void shouldHandleExampleWithoutDirectAccessToBordersForPointsNotInTheInside() {
        Grid grid = new Grid(
                List.of(
                        "..........",
                        ".S------7.",
                        ".|F----7|.",
                        ".||....||.",
                        ".||....||.",
                        ".|L-7F-J|.",
                        ".|II||II|.",
                        ".L--JL--J.",
                        ".........."
                )
        );
        assertEquals(4, new PointsInsideCycle().calculateAmount(grid));
    }

    @Test
    public void shouldHandleLargeExamples() {
        Grid grid = new Grid(
                List.of(
                        ".F----7F7F7F7F-7....",
                        ".|F--7||||||||FJ....",
                        ".||.FJ||||||||L7....",
                        "FJL7L7LJLJ||LJ.L-7..",
                        "L--J.L7...LJS7F-7L7.",
                        "....F-J..F7FJ|L7L7L7",
                        "....L7.F7||L7|.L7L7|",
                        ".....|FJLJ|FJ|F7|.LJ",
                        "....FJL-7.||.||||...",
                        "....L---J.LJ.LJLJ..."
                )
        );
        assertEquals(8, new PointsInsideCycle().calculateAmount(grid));
    }

}