package solutions.dec24;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class Solution {

    public long calculatePathsCollisions(List<String> hailstonesDescriptions, long coordinateLeftBound, long coordinateRightBound) {
        HailstoneParser parser = new HailstoneParser();
        List<Hailstone> hailstones = hailstonesDescriptions.stream()
                .map(parser::parse)
                .collect(toList());

//        return new IntersectionCalculator(
//                hailstones,
//                coordinateLeftBound,
//                coordinateRightBound
//        ).calculateNumberOfIntersections();
        return new StoneLauncher(hailstones).findSumOfInitialStoneCoordinates();
    }
}
