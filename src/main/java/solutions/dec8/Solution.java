package solutions.dec8;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class Solution {

    public int findNumberOfSteps(List<String> map) {
        System.out.println(map.get(0).length());
        NodeParser nodeParser = new NodeParser();
        List<Node> nodes = map.subList(2, map.size()).stream()
                .map(nodeParser::parse)
                .collect(toList());
        System.out.println(
                nodes.stream()
                        .filter(node -> node.getName().endsWith("Z"))
                        .count()
        );
        return new NodeTraversal(nodes, map.get(0)).getNumberOfStepsFromStartToFinish();
    }
}
