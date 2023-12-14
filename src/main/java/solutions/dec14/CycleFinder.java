package solutions.dec14;

import java.util.HashMap;
import java.util.Map;

public class CycleFinder {

    private static final int ROTATIONS = 1000000000;

    public void findCycle(Platform platform) {
        Map<Platform, Integer> visitedPlatforms = new HashMap<>();
        int iteration = 0;
        while (true) {
            if (visitedPlatforms.containsKey(platform)) {
                outputSolution(platform, visitedPlatforms, iteration);
                return;
            }
            visitedPlatforms.put(platform, iteration);
            platform = rotate(platform);
            iteration++;
        }
    }

    private void outputSolution(Platform platform, Map<Platform, Integer> visitedPlatforms, int iteration) {
        int cycleLength = iteration - visitedPlatforms.get(platform);
        int rotationsIndexInCycle = ROTATIONS % cycleLength;
        int currentIndexInCycle = iteration % cycleLength;
        int iterationWithSameStateAsGiven = iteration - currentIndexInCycle + rotationsIndexInCycle;
        Platform platformOfGivenIteration = visitedPlatforms.entrySet().stream()
                .filter(entry -> entry.getValue() == iterationWithSameStateAsGiven)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElseThrow();
        PlatformScoreCalculator calculator = new PlatformScoreCalculator();
        System.out.println(calculator.calculateScore(platformOfGivenIteration));
    }

    private Platform rotate(Platform platform) {
        PlatformTilt platformTilt = new PlatformTilt();
        Platform result = platformTilt.tiltNorth(platform);
        result = platformTilt.tiltWest(result);
        result = platformTilt.tiltSouth(result);
        result = platformTilt.tiltEast(result);
        return result;
    }


}
