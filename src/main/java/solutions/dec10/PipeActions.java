package solutions.dec10;

import java.util.Set;

public interface PipeActions {

    Direction move(Direction previousDirection);

    Set<Direction> allowedDirectionsToArriveFrom();

}
