package solutions.dec13;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class LandParser {
    public List<Land> parse(List<String> input) {
        return splitInput(input).stream()
                .map(Land::new)
                .collect(toList());
    }

    private List<List<String>> splitInput(List<String> input) {
        List<Integer> borders = new ArrayList<>();
        borders.add(-1);
        for (int i = 0; i < input.size(); i++) {
            if (input.get(i).isEmpty()) {
                borders.add(i);
            }
        }
        borders.add(input.size());
        List<List<String>> result = new ArrayList<>();
        for (int i = 0; i < borders.size() - 1; i++) {
            result.add(input.subList(borders.get(i) + 1, borders.get(i + 1)));
        }
        return result;
    }
}
