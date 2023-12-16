package solutions.dec16;

import java.util.ArrayList;
import java.util.List;

public class SolutionPart2 {
    public int getMaxNumberOfEnergizedTiles(List<String> contraption) {
        return startingBeams(contraption).stream()
                .mapToInt(beam -> new Contraption(contraption, beam).getNumberOfEnergizedTiles())
                .max()
                .orElseThrow();
    }

    private List<Beam> startingBeams(List<String> contraption) {
        List<Beam> result = new ArrayList<>();
        for (int i = 0; i < contraption.size(); i++) {
            result.add(new Beam(i, 0, Direction.RIGHT));
            result.add(new Beam(i, contraption.get(i).length() - 1, Direction.LEFT));
        }
        for (int i = 0; i < contraption.get(0).length(); i++) {
            result.add(new Beam(0, i, Direction.DOWN));
            result.add(new Beam(contraption.size() - 1, i, Direction.UP));
        }
        return result;
    }
}
