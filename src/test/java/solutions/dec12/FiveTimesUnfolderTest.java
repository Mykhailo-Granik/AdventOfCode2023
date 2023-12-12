package solutions.dec12;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FiveTimesUnfolderTest {

    @Test
    public void shouldUnfoldRecordCorrectly() {
        SpringConditionRecord record = new SpringConditionRecord(".#", List.of(1, 2));
        SpringConditionRecord unfolded = new FiveTimesUnfolder().unfold(record);
        assertEquals(
                new SpringConditionRecord(
                        ".#?.#?.#?.#?.#",
                        List.of(1, 2, 1, 2, 1, 2, 1, 2, 1, 2)
                ),
                unfolded
        );
    }

}