package solutions.dec14;

import java.util.List;

public class Solution {
    public int calculateScore(List<String> platformGrid) {
        CycleFinder cycleFinder = new CycleFinder();
        cycleFinder.findCycle(new Platform(platformGrid));
        Platform platform = new Platform(platformGrid);
        Platform tilted = new PlatformTilt().tiltNorth(platform);
        return new PlatformScoreCalculator().calculateScore(tilted);
    }
}
