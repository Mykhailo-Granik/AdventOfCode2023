package solutions.dec9;

import java.util.List;

public class EndValuesExtrapolator extends AbstractValuesExtrapolator {

    @Override
    protected Long extrapolateFromHistory(List<List<Long>> history) {
        history.get(history.size() - 1).add(0L);
        for (int i = history.size() - 2; i >= 0; i--) {
            List<Long> currentDifferences = history.get(i);
            List<Long> nextDifferences = history.get(i + 1);
            currentDifferences.add(nextDifferences.get(nextDifferences.size() - 1) + currentDifferences.get(currentDifferences.size() - 1));
        }
        return history.get(0).get(history.get(0).size() - 1);
    }

}
