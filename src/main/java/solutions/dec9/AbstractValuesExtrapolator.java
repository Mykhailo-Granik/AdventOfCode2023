package solutions.dec9;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractValuesExtrapolator implements ValuesExtrapolator {

    @Override
    public long extrapolate(Values values) {
        List<List<Long>> history = createHistoryOfDifferences(values);
        return extrapolateFromHistory(history);
    }

    private List<List<Long>> createHistoryOfDifferences(Values values) {
        List<Long> currentValues = values.getValuesAsList();
        List<List<Long>> history = new ArrayList<>();
        history.add(currentValues);
        while (!allZeroes(currentValues)) {
            currentValues = listOfDifferences(currentValues);
            history.add(currentValues);
        }
        return history;
    }

    protected abstract Long extrapolateFromHistory(List<List<Long>> history);

    private boolean allZeroes(List<Long> currentValues) {
        return currentValues.stream().allMatch(value -> value == 0);
    }

    private List<Long> listOfDifferences(List<Long> values) {
        List<Long> differences = new ArrayList<>();
        for (int i = 0; i < values.size() - 1; i++) {
            differences.add(values.get(i + 1) - values.get(i));
        }
        return differences;
    }

}
