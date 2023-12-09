package solutions.dec9;

import java.util.List;

public class BeginningValuesExtrapolator extends AbstractValuesExtrapolator {


    @Override
    protected Long extrapolateFromHistory(List<List<Long>> history) {
        history.get(history.size() - 1).add(0, 0L);
        for (int i = history.size() - 2; i >= 0; i--) {
            List<Long> currentDifferences = history.get(i);
            List<Long> nextDifferences = history.get(i + 1);
            currentDifferences.add(0, currentDifferences.get(0) - nextDifferences.get(0));
        }
        return history.get(0).get(0);
    }
}
