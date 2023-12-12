package solutions.dec12;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SpringConditionRecordTest {

    @Test
    public void shouldCalculateNumberOfPossibleArrangementsWhenOnlyOneExists() {
        SpringConditionRecord record = new SpringConditionRecord(".#...#....###.", List.of(1, 1, 3));
        assertEquals(1, record.calculateNumberOfPossibleArrangements());
    }

    @Test
    public void shouldCalculateNumberOfPossibleArrangementsWithUnknownsWhenOneExists() {
        SpringConditionRecord record = new SpringConditionRecord("???.###", List.of(1, 1, 3));
        assertEquals(1, record.calculateNumberOfPossibleArrangements());
    }

    @Test
    public void shouldCalculateNumberOfPossibleArrangementsForGeneralCase() {
        SpringConditionRecord record = new SpringConditionRecord("?###????????", List.of(3, 2, 1));
        assertEquals(10, record.calculateNumberOfPossibleArrangements());
    }

}