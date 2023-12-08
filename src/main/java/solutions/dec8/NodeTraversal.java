package solutions.dec8;

import java.util.*;
import java.util.stream.Collectors;

public class NodeTraversal {

    private static final String STARTING_NODE = "AAA";
    private static final String FINISH_NODE = "ZZZ";

    private final List<Node> nodes;
    private final String commands;

    public NodeTraversal(List<Node> nodes, String commands) {
        this.nodes = nodes;
        this.commands = commands;
    }


    public int getNumberOfStepsFromStartToFinish() {
        Map<String, Node> nodesByName = nodesByName();
        String currentNodeName = STARTING_NODE;
        int commandIndex = 0;
        int steps = 0;
        while (!currentNodeName.equals(FINISH_NODE)) {
            Node currentNode = nodesByName.get(currentNodeName);
            currentNodeName = currentNode.go(commands.charAt(commandIndex));
            commandIndex++;
            if (commandIndex == commands.length()) {
                commandIndex = 0;
            }
            steps++;
        }
        nodes.stream().filter(node -> node.getName().endsWith("A"))
                .forEach(node -> findInfo(node.getName(), nodesByName));
        return steps;
    }

    // This is data analysis code, used to solve part2 of the problem
    private void findInfo(String startingNode, Map<String, Node> nodesByName) {
        System.out.println("Starting from " + startingNode);
        Map<String, Set<Integer>> visitedNodeTimes = new HashMap<>();
        Map<String, List<Integer>> visitedNodeTimesList = new HashMap<>();
        String currentNodeName = startingNode;
        int commandIndex = 0;
        int steps = 0;
        while (true) {
            if (currentNodeName.endsWith("Z")) {
                System.out.println("Reached " + currentNodeName + " after " + steps + " steps");
            }
            Node currentNode = nodesByName.get(currentNodeName);
            visitedNodeTimes.computeIfAbsent(currentNodeName, k -> new HashSet<>());
            visitedNodeTimesList.computeIfAbsent(currentNodeName, k -> new ArrayList<>());
            if (visitedNodeTimes.get(currentNodeName).contains(commandIndex)) {
                int loopStart = -1;
                for (Integer value : visitedNodeTimesList.get(currentNodeName)) {
                    if (value % commands.length() == commandIndex) {
                        loopStart = value;
                        break;
                    }
                }
                System.out.println("Loop detected at " + currentNodeName + " after " + steps + " steps, loop start = " + loopStart + ", loop length = " + (steps - loopStart));
                break;
            }
            visitedNodeTimesList.get(currentNodeName).add(steps);
            visitedNodeTimes.get(currentNodeName).add(commandIndex);
            currentNodeName = currentNode.go(commands.charAt(commandIndex));
            commandIndex++;
            if (commandIndex == commands.length()) {
                commandIndex = 0;
            }
            steps++;
        }
        visitedNodeTimes.forEach((k, v) -> {
            if (k.endsWith("Z")) {
                System.out.println(k + " " + v);
            }
        });
    }

    private Map<String, Node> nodesByName() {
        return nodes.stream()
                .collect(Collectors.toUnmodifiableMap(Node::getName, node -> node));
    }
}
