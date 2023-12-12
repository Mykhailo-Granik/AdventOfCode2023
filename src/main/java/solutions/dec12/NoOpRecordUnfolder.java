package solutions.dec12;

public class NoOpRecordUnfolder implements RecordUnfolder {

    @Override
    public SpringConditionRecord unfold(SpringConditionRecord record) {
        return record;
    }
}
