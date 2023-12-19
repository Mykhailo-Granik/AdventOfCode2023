package solutions.dec19;

import java.util.Arrays;
import java.util.Map;

import static java.util.stream.Collectors.toMap;

public class PartParser {

    public Part parse(String part) {
        String partData = part.substring(1, part.length() - 1);
        Map<String, Integer> parameterValueByName = Arrays.stream(partData.split(","))
                .map(parameterValue -> parameterValue.split("="))
                .collect(toMap(
                                parameterValue -> parameterValue[0],
                                parameterValue -> Integer.parseInt(parameterValue[1])
                        )
                );
        return new Part(
                parameterValueByName.get("x"),
                parameterValueByName.get("m"),
                parameterValueByName.get("a"),
                parameterValueByName.get("s")
        );
    }

}
