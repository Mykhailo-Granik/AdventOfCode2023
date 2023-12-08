package solutions.dec8;

public class NodeParser {
    public Node parse(String nodeString) {
        String[] parts = nodeString.split(" ");
        return new Node(
                parts[0],
                parts[2].substring(1, parts[2].length() - 1),
                parts[3].substring(0, parts[3].length() - 1)
        );
    }
}
