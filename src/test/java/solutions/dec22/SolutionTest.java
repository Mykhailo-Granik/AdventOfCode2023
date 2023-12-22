package solutions.dec22;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    public void shouldCalculateNumberOfBricksToDisinegrate() {
        List<String> bricks = List.of(
                "1,0,1~1,2,1",
                "0,0,2~2,0,2",
                "0,2,3~2,2,3",
                "0,0,4~0,2,4",
                "2,0,5~2,2,5",
                "0,1,6~2,1,6",
                "1,1,8~1,1,9"
        );
        assertEquals(5, new Solution().calculateNumberOfBricksToDisinegrate(bricks));
    }

}