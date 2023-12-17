package solutions.dec17;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class GraphNode {

    private final int row;
    private final int column;
    private final Direction direction;
    private final int stepsTaken;

    public GraphNode(int row, int column, Direction direction, int stepsTaken) {
        this.row = row;
        this.column = column;
        this.direction = direction;
        this.stepsTaken = stepsTaken;
    }

    public Set<GraphNode> nextNodes() {
        Set<GraphNode> graphNodes = new HashSet<>();
        graphNodes.add(new GraphNode(row + direction.getDeltaRow(), column + direction.getDeltaColumn(), direction, stepsTaken + 1));
        for (Direction rotation : direction.rotations()) {
            graphNodes.add(new GraphNode(row + rotation.getDeltaRow(), column + rotation.getDeltaColumn(), rotation, 1));
        }
        return graphNodes;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public int getStepsTaken() {
        return stepsTaken;
    }

    public Direction getDirection() {
        return direction;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GraphNode graphNode = (GraphNode) o;
        return row == graphNode.row && column == graphNode.column && stepsTaken == graphNode.stepsTaken && direction == graphNode.direction;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, column, direction, stepsTaken);
    }
}
