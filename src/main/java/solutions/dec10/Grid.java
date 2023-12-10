package solutions.dec10;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Collections.emptyList;

public class Grid {

    private final List<StringBuilder> grid;

    public Grid(List<String> grid) {
        this.grid = grid.stream()
                .map(StringBuilder::new)
                .collect(Collectors.toList());
    }

    public Coordinate findStart() {
        for (int y = 0; y < grid.size(); y++) {
            StringBuilder row = grid.get(y);
            for (int x = 0; x < row.length(); x++) {
                if (row.charAt(x) == 'S') {
                    return new Coordinate(x, y);
                }
            }
        }
        throw new IllegalArgumentException("No start found");
    }

    public char charAt(Coordinate coordinate) {
        return grid.get(coordinate.getY()).charAt(coordinate.getX());
    }

    public void replaceCharAt(Coordinate coordinate, char character) {
        grid.get(coordinate.getY()).setCharAt(coordinate.getX(), character);
    }

    public int numberOfRows() {
        return grid.size();
    }

    public int numberOfColumns() {
        return grid.get(0).length();
    }

    public int cycleLengthOrMinusOne(Coordinate coordinate, Direction direction) {
        return cycleOrEmptyList(coordinate, direction).isEmpty() ? -1 :
                cycleOrEmptyList(coordinate, direction).size();
    }

    public List<Coordinate> cycleOrEmptyList(Coordinate coordinate, Direction direction) {
        Coordinate currentCoordinate = coordinate;
        Direction currentDirection = direction;
        int movesMade = 0;
        List<Coordinate> cycle = new ArrayList<>();
        while (true) {
            movesMade++;
            Pipe pipe = PipeFactory.createPipe(charAt(currentCoordinate));
            if (pipe == Pipe.GROUND) {
                return emptyList();
            }
            Direction nextDirection = pipe.move(currentDirection);
            Coordinate nextCoordinate = currentCoordinate.move(nextDirection);
            cycle.add(nextCoordinate);
            if (nextCoordinate.equals(coordinate) && nextDirection.equals(direction)) {
                return cycle;
            }
            if (outOfBounds(nextCoordinate)) {
                return emptyList();
            }
            if (nextDirection == Direction.INVALID) {
                return emptyList();
            }
            currentCoordinate = nextCoordinate;
            currentDirection = nextDirection;
        }
    }

    public boolean outOfBounds(Coordinate coordinate) {
        return coordinate.getX() < 0 || coordinate.getX() >= grid.get(0).length() ||
                coordinate.getY() < 0 || coordinate.getY() >= grid.size();
    }
}
