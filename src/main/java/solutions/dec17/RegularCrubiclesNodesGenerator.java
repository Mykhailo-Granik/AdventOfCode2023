package solutions.dec17;

import java.util.HashSet;
import java.util.Set;

import static java.util.stream.Collectors.toSet;

public class RegularCrubiclesNodesGenerator implements NextNodesGenerator {

    private final int rows;
    private final int columns;

    public RegularCrubiclesNodesGenerator(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
    }

    @Override
    public Set<GraphNode> nextNodes(GraphNode node) {
        Set<GraphNode> nextNodes = new HashSet<>();
        nextNodes.add(
                new GraphNode(
                        node.getRow() + node.getDirection().getDeltaRow(),
                        node.getColumn() + node.getDirection().getDeltaColumn(),
                        node.getDirection(),
                        node.getStepsTaken() + 1
                )
        );
        for (Direction rotation : node.getDirection().rotations()) {
            nextNodes.add(new GraphNode(node.getRow() + rotation.getDeltaRow(), node.getColumn() + rotation.getDeltaColumn(), rotation, 1));
        }
        return nextNodes.stream()
                .filter(this::isInsideGrid)
                .filter(this::lessThanFourStepsTaken)
                .collect(toSet());
    }

    private boolean isInsideGrid(GraphNode node) {
        return node.getRow() >= 0 && node.getRow() < rows && node.getColumn() >= 0 && node.getColumn() < columns;
    }

    private boolean lessThanFourStepsTaken(GraphNode node) {
        return node.getStepsTaken() < 4;
    }

}
