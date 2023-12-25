package solutions.dec25;

import java.util.List;

public class NetworkScoreCalculator {

    private final Network network;

    public NetworkScoreCalculator(Network network) {
        this.network = network;
    }

    public int calculateScore() {
        List<Connection> connections = network.getConnections();
        for (int i = 0; i < connections.size(); ++i) {
            for (int j = i + 1; j < connections.size(); ++j) {
                Connection bridge = network.findBridge(List.of(connections.get(i), connections.get(j)));
                if (bridge == null) {
                    continue;
                }
                List<Integer> componentSizes = network.sizesOfComponentsIgnoringEdges(
                        List.of(bridge, connections.get(i), connections.get(j))
                );
                if (componentSizes.size() == 2) {
                    return componentSizes.get(0) * componentSizes.get(1);
                }
            }
        }
        throw new IllegalStateException("No solution found");
    }
}
