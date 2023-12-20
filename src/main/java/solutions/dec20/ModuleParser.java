package solutions.dec20;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class ModuleParser {


    public Module parse(String moduleDescription) {
        if (moduleDescription.startsWith("%")) {
            return parseFlipFlop(moduleDescription.substring(1));
        }
        if (moduleDescription.startsWith("&")) {
            return parseConjunction(moduleDescription.substring(1));
        }
        return parseBroadcast(moduleDescription);
    }

    private Module parseFlipFlop(String moduleDescription) {
        return new FlipFlopModule(moduleName(moduleDescription), moduleDestinations(moduleDescription));
    }

    private List<String> moduleDestinations(String moduleDescription) {
        String[] parts = moduleDescription.split(" -> ");
        return Arrays.stream(parts[1].split(", ")).collect(toList());
    }

    private String moduleName(String moduleDescription) {
        return moduleDescription.split(" -> ")[0];
    }

    private Module parseConjunction(String moduleDescription) {
        return new ConjunctionModule(moduleName(moduleDescription), moduleDestinations(moduleDescription));
    }

    private Module parseBroadcast(String moduleDescription) {
        return new BroadcastModule(moduleName(moduleDescription), moduleDestinations(moduleDescription));
    }
}
