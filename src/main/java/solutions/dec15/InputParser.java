package solutions.dec15;

import java.util.List;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toList;

public class InputParser {

    public List<String> parse(String input) {
        return stream(input.split(","))
                .collect(toList());
    }
}
