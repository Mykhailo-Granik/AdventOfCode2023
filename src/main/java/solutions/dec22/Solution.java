package solutions.dec22;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class Solution {


    public int calculateNumberOfBricksToDisinegrate(List<String> bricksDescriptions) {
        BrickParser brickParser = new BrickParser();
        List<Brick> bricks = bricksDescriptions.stream()
                .map(brickParser::parse)
                .collect(toList());
        return new BricksToDisintegrateCalculator(bricks).calculateTotalAmountOfFalls();
    }
}
