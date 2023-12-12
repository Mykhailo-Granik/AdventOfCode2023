package solutions.dec12;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SpringConditionRecordParserTest {

    @Test
    public void shouldParseSpringConditionRecord() {
        SpringConditionRecordParser parser = new SpringConditionRecordParser();
        SpringConditionRecord record = parser.parse("#.#.### 1,1,3");
        assertEquals(new SpringConditionRecord("#.#.###", List.of(1, 1, 3)), record);
    }

}