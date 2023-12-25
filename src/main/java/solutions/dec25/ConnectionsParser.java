package solutions.dec25;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class ConnectionsParser {
    public List<Connection> parse(String connectionsDescription) {
        String firstEnd = connectionsDescription.substring(0, connectionsDescription.indexOf(":"));
        String[] secondEnds = connectionsDescription.substring(connectionsDescription.indexOf(":") + 2).split(" ");
        return Arrays.stream(secondEnds)
                .map(secondEnd -> new Connection(firstEnd, secondEnd))
                .collect(toList());
    }
}
