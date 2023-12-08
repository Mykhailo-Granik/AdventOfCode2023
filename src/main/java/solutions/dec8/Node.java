package solutions.dec8;

import java.util.Objects;

public class Node {

    private final String name;
    private final String left;
    private final String right;

    public Node(String name, String left, String right) {
        this.name = name;
        this.left = left;
        this.right = right;
    }

    public String getName() {
        return name;
    }

    public String getLeft() {
        return left;
    }

    public String getRight() {
        return right;
    }

    public String go(char direction) {
        if (direction == 'R') {
            return right;
        }
        if (direction == 'L') {
            return left;
        }
        throw new IllegalArgumentException("Direction must be L or R");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return Objects.equals(name, node.name) && Objects.equals(left, node.left) && Objects.equals(right, node.right);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, left, right);
    }

    @Override
    public String toString() {
        return name + " = (" + left + ", " + right + ")";
    }
}
