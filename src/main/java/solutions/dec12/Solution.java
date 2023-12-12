package solutions.dec12;

import java.util.List;

public class Solution {

    private final RecordUnfolder recordUnfolder;

    public Solution(RecordUnfolder recordUnfolder) {
        this.recordUnfolder = recordUnfolder;
    }

    public long findSumOfPossibleArrangements(List<String> record) {
        var parser = new SpringConditionRecordParser();
        return record.stream()
                .map(parser::parse)
                .map(recordUnfolder::unfold)
                .mapToLong(SpringConditionRecord::calculateNumberOfPossibleArrangements)
                .sum();
    }
}
