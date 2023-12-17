package solutions.dec17;

import java.util.*;

public class Grid {

    private final List<String> grid;
    private final NextNodesGenerator nextNodesGenerator;
    private final AllowedToStopPredicate allowedToStopPredicate;

    public Grid(List<String> grid, NextNodesGenerator nextNodesGenerator, AllowedToStopPredicate allowedToStopPredicate) {
        this.grid = grid;
        this.nextNodesGenerator = nextNodesGenerator;
        this.allowedToStopPredicate = allowedToStopPredicate;
    }

    public int findShortestPath() {
        Map<GraphNode, Integer> distances = new HashMap<>();
        PriorityQueue<GraphNode> queue = new PriorityQueue<>(Comparator.comparingInt(distances::get));
        GraphNode startRight = new GraphNode(0, 0, Direction.RIGHT, 0);
        distances.put(startRight, 0);
        queue.add(startRight);
        GraphNode startDown = new GraphNode(0, 0, Direction.DOWN, 0);
        distances.put(startDown, 0);
        queue.add(startDown);
        while (!queue.isEmpty()) {
            GraphNode current = queue.poll();
            if ((current.getRow() == grid.size() - 1) && (current.getColumn() == grid.get(0).length() - 1) && allowedToStopPredicate.test(current)) {
                return distances.get(current);
            }
            Set<GraphNode> nextNodes = nextNodesGenerator.nextNodes(current);
            for (GraphNode nextNode : nextNodes) {
                if (distances.containsKey(nextNode)) {
                    continue;
                }
                int distance = distances.get(current) + cost(nextNode.getRow(), nextNode.getColumn());
                distances.put(nextNode, distance);
                queue.add(nextNode);
            }
        }
        throw new IllegalStateException("No path found");
    }

    private int cost(int row, int column) {
        return grid.get(row).charAt(column) - '0';
    }

}
