package solutions.dec12;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class SpringConditionRecordParser {
    public SpringConditionRecord parse(String record) {
        String[] parts = record.split(" ");
        return new SpringConditionRecord(parts[0], parseDamagedSpringsGroups(parts[1]));
    }

    private List<Integer> parseDamagedSpringsGroups(String groups) {
        return Arrays.stream(groups.split(",")).map(Integer::parseInt).collect(toList());
    }
}
