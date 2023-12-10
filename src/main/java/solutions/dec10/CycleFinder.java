package solutions.dec10;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class CycleFinder {

    public List<Coordinate> findCycle(Grid grid) {
        Coordinate coordinate = grid.findStart();
        for (Pipe possiblePipe : possiblePipes()) {
            grid.replaceCharAt(coordinate, PipeFactory.charForPipe(possiblePipe));
            List<Coordinate> cycle = grid.cycleOrEmptyList(coordinate, allowedPipeDirection(possiblePipe));
            if (cycle.isEmpty()) {
                continue;
            }
            return cycle;
        }
        throw new IllegalArgumentException("No cycle found");
    }

    private Direction allowedPipeDirection(Pipe possiblePipe) {
        return possiblePipe.allowedDirectionsToArriveFrom()
                .stream()
                .sorted()
                .findFirst()
                .orElseThrow();
    }

    private List<Pipe> possiblePipes() {
        return Arrays.stream(Pipe.values())
                .filter(pipe -> pipe != Pipe.GROUND)
                .collect(toList());
    }

}
