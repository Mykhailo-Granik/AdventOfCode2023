package solutions.dec25;

import java.util.*;

public class Network {

    private final List<Connection> connections;
    private final Map<String, List<String>> neighbours;

    private Map<String, Integer> entranceTimes;
    private Map<String, Integer> highestAccessibleEntranceTime;
    private int time;
    private Set<String> visited;

    public Network(List<String> connectionDescriptions) {
        connections = new ArrayList<>();
        neighbours = new HashMap<>();
        ConnectionsParser connectionsParser = new ConnectionsParser();
        for (String connectionDescription : connectionDescriptions) {
            List<Connection> connectionsForComponent = connectionsParser.parse(connectionDescription);
            for (Connection connection : connectionsForComponent) {
                connections.add(connection);
                neighbours.putIfAbsent(connection.getEnd1(), new ArrayList<>());
                neighbours.putIfAbsent(connection.getEnd2(), new ArrayList<>());
                neighbours.get(connection.getEnd1()).add(connection.getEnd2());
                neighbours.get(connection.getEnd2()).add(connection.getEnd1());
            }
        }
    }

    public List<String> neighbours(String component) {
        return neighbours.get(component);
    }

    public Connection findBridge(List<Connection> connectionsToIgnore) {
        entranceTimes = new HashMap<>();
        highestAccessibleEntranceTime = new HashMap<>();
        time = 0;
        visited = new HashSet<>();
        return findBridge(neighbours.keySet().iterator().next(), "", connectionsToIgnore);
    }

    private Connection findBridge(String component, String previousComponent, List<Connection> connectionsToIgnore) {
        visited.add(component);
        entranceTimes.put(component, time);
        highestAccessibleEntranceTime.put(component, time);
        time++;
        for (String neighbour : neighbours(component)) {
            if (neighbour.equals(previousComponent)) {
                continue;
            }
            if (connectionsToIgnore.contains(new Connection(component, neighbour))) {
                continue;
            }
            if (connectionsToIgnore.contains(new Connection(neighbour, component))) {
                continue;
            }
            if (visited.contains(neighbour)) {
                highestAccessibleEntranceTime.put(
                        component,
                        Math.min(highestAccessibleEntranceTime.get(component), entranceTimes.get(neighbour))
                );
            } else {
                Connection bridge = findBridge(neighbour, component, connectionsToIgnore);
                if (bridge != null) {
                    return bridge;
                }
                highestAccessibleEntranceTime.put(
                        component,
                        Math.min(highestAccessibleEntranceTime.get(component), highestAccessibleEntranceTime.get(neighbour))
                );
                if (highestAccessibleEntranceTime.get(neighbour) > entranceTimes.get(component)) {
                    return new Connection(component, neighbour);
                }
            }
        }
        return null;
    }

    public List<Integer> sizesOfComponentsIgnoringEdges(List<Connection> connectionsToIgnore) {
        visited = new HashSet<>();
        List<Integer> sizes = new ArrayList<>();
        for (String component : neighbours.keySet()) {
            if (!visited.contains(component)) {
                sizes.add(visit(component, connectionsToIgnore));
            }
        }
        return sizes;
    }

    private int visit(String component, List<Connection> connectionsToIgnore) {
        if (visited.contains(component)) {
            return 0;
        }
        visited.add(component);
        int res = 1;
        for (String neighbour : neighbours(component)) {
            if (connectionsToIgnore.contains(new Connection(component, neighbour))) {
                continue;
            }
            if (connectionsToIgnore.contains(new Connection(neighbour, component))) {
                continue;
            }
            res += visit(neighbour, connectionsToIgnore);
        }
        return res;
    }

    public List<Connection> getConnections() {
        return connections;
    }
}
