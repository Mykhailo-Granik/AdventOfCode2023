package solutions.dec25;

import java.util.List;

public class Solution {


    public int calculateNetworkScore(List<String> connectionDescriptions) {
        Network network = new Network(connectionDescriptions);
        return new NetworkScoreCalculator(network).calculateScore();
    }
}
