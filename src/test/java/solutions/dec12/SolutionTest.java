package solutions.dec12;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    public void shouldFindSumOfPossibleArrangements() {
        assertEquals(21, new Solution(new NoOpRecordUnfolder()).findSumOfPossibleArrangements(record()));
    }

    private List<String> record() {
        return List.of(
                "???.### 1,1,3",
                ".??..??...?##. 1,1,3",
                "?#?#?#?#?#?#?#? 1,3,1,6",
                "????.#...#... 4,1,1",
                "????.######..#####. 1,6,5",
                "?###???????? 3,2,1"
        );
    }

    @Test
    public void shouldFindSumWithFiveTimesUnfolder() {
        assertEquals(525152, new Solution(new FiveTimesUnfolder()).findSumOfPossibleArrangements(record()));
    }

}