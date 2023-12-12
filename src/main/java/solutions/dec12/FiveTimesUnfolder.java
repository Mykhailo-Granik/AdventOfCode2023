package solutions.dec12;

import java.util.ArrayList;
import java.util.List;

public class FiveTimesUnfolder implements RecordUnfolder {

    @Override
    public SpringConditionRecord unfold(SpringConditionRecord springConditionRecord) {
        return new SpringConditionRecord(
                unfoldRecord(springConditionRecord.getRecord()),
                unfoldGroupsOfDamagedSprings(springConditionRecord.getGroupsOfDamagedSprings())
        );
    }

    private List<Integer> unfoldGroupsOfDamagedSprings(List<Integer> groupsOfDamagedSprings) {
        List<Integer> result = new ArrayList<>(groupsOfDamagedSprings);
        for (int i = 0; i < 4; i++) {
            result.addAll(groupsOfDamagedSprings);
        }
        return result;
    }

    private String unfoldRecord(String record) {
        String result = record;
        for (int i = 0; i < 4; i++) {
            result += '?';
            result += record;
        }
        return result;
    }
}
