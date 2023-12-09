package solutions.dec9;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ValuesParser {
    public Values parse(String values) {
        return new Values(valuesAsList(values));
    }

    private List<Long> valuesAsList(String values) {
        return Arrays.stream(values.split(" "))
                .map(Long::parseLong)
                .collect(Collectors.toList());
    }
}
