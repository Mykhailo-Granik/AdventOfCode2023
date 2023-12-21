package solutions.dec21;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InfiniteGridCalculator {

    private final List<String> grid;
    private final int steps;

    public InfiniteGridCalculator(List<String> grid, int steps) {
        this.grid = grid;
        this.steps = steps;
    }

    // The solution takes into account feature of the input
    public long count() {
        int fullGrids = steps / grid.size();
        int toSub = 2;
        List<Integer> nonWallsWithDistanceParity = List.of(
                nonWallsMatchingPredicate(cell -> (distanceFromCenter(cell) % 2) == 0) - toSub,
                nonWallsMatchingPredicate(cell -> (distanceFromCenter(cell) % 2) == 1) - toSub
        );
        System.out.println("Non walls with distance parity : " + nonWallsWithDistanceParity);
        int currentParity = steps % 2;
        long res = nonWallsWithDistanceParity.get(currentParity);
        for (int gridDistance = 1; gridDistance < fullGrids; ++gridDistance) {
            long totalGrids = 4L * gridDistance;
            currentParity = 1 - currentParity;
            res += totalGrids * nonWallsWithDistanceParity.get(currentParity);
        }
        int totalIterations = 0;
        long previousSum = 0;
        System.out.println("Full grids : " + fullGrids);
        for (int gridOnBorderColumn = -fullGrids; gridOnBorderColumn <= fullGrids; ++gridOnBorderColumn) {
            totalIterations++;
            if (totalIterations % 500 == 0) {
                System.out.println(totalIterations + " done");
            }
            int gridOnBorderRow = fullGrids - Math.abs(gridOnBorderColumn);
            int val = 2;
            if ((Math.abs(gridOnBorderRow) > 2) && (Math.abs(gridOnBorderColumn) > 2)) {
                res += previousSum;
                continue;
            }
            List<Cell> centers = new ArrayList<>();
            if (gridOnBorderColumn < 0) {
                centers.add(center(gridOnBorderColumn + 1, gridOnBorderRow));
                centers.add(center(gridOnBorderColumn + 1, -gridOnBorderRow));
            } else if (gridOnBorderColumn > 0) {
                centers.add(center(gridOnBorderColumn - 1, -gridOnBorderRow));
                centers.add(center(gridOnBorderColumn - 1, gridOnBorderRow));
            }
            if (gridOnBorderRow != 0) {
                centers.add(center(gridOnBorderColumn, gridOnBorderRow - 1));
                centers.add(center(gridOnBorderColumn, -gridOnBorderRow + 1));
            }
            centers = centers.stream().distinct().collect(Collectors.toList());
            Set<Cell> topLeftCorners = Stream.of(
                    topLeftCorner(gridOnBorderColumn, gridOnBorderRow),
                    topLeftCorner(gridOnBorderColumn, -gridOnBorderRow),
                    topLeftCorner(gridOnBorderColumn, gridOnBorderRow + 1),
                    topLeftCorner(gridOnBorderColumn, -gridOnBorderRow - 1)
            ).distinct().collect(Collectors.toSet());
            Set<Cell> cells = centers.stream()
                    .flatMap(center -> reachable(grid.size() + grid.size() / 2, center).stream())
                    .filter(cell -> belongToNeededGrids(topLeftCorners, cell))
                    .collect(Collectors.toSet());
            res += cells.size();
            previousSum = cells.size();
        }
        return res;
    }

    private boolean belongToNeededGrids(Set<Cell> topLeftCorners, Cell cell) {
        return topLeftCorners.stream().anyMatch(topLeftCorner -> insideOfGrid(topLeftCorner, cell));
    }

    private boolean insideOfGrid(Cell topLeftCorner, Cell cell) {
        return cell.getRow() >= topLeftCorner.getRow() && cell.getRow() < topLeftCorner.getRow() + grid.size() &&
                cell.getColumn() >= topLeftCorner.getColumn() && cell.getColumn() < topLeftCorner.getColumn() + grid.get(0).length();
    }

    private Set<Cell> reachable(int steps, Cell start) {
        Queue<Cell> queue = new LinkedList<>();
        Map<Cell, Integer> distances = new HashMap<>();
        distances.put(start, 0);
        queue.add(start);
        while (!queue.isEmpty()) {
            Cell current = queue.poll();
            if (distances.get(current) > steps) {
                break;
            }
            int currentDistance = distances.get(current);
            for (Cell neighbor : neighbors(current)) {
                if (!distances.containsKey(neighbor)) {
                    distances.put(neighbor, currentDistance + 1);
                    queue.add(neighbor);
                }
            }
        }
        return new HashSet<>(distances.keySet())
                .stream()
                .filter(cell -> distances.get(cell) <= steps)
                .filter(cell -> (distances.get(cell) % 2) == (steps % 2))
                .collect(Collectors.toSet());
    }

    private Set<Cell> neighbors(Cell cell) {
        return Stream.of(
                        new Cell(cell.getRow(), cell.getColumn() - 1),
                        new Cell(cell.getRow(), cell.getColumn() + 1),
                        new Cell(cell.getRow() - 1, cell.getColumn()),
                        new Cell(cell.getRow() + 1, cell.getColumn())
                )
                .filter(this::cellIsNotARock)
                .collect(Collectors.toSet());
    }

    private boolean cellIsNotARock(Cell cell) {
        int row;
        if (cell.getRow() >= 0) {
            row = cell.getRow() % grid.size();
        } else {
            row = grid.size() - negativeModulo(cell.getRow(), grid.size());
        }
        int col;
        if (cell.getColumn() >= 0) {
            col = cell.getColumn() % grid.get(row).length();
        } else {
            col = grid.get(row).length() - negativeModulo(cell.getColumn(), grid.get(row).length());
        }
        return grid.get(row).charAt(col) != '#';
    }

    int negativeModulo(int a, int b) {
        int result = Math.abs(a) % b;
        if (result == 0) {
            return b;
        }
        return result;
    }

    public long calculate() {
        int fullGrids = steps / grid.size();
        long res = 0;
        for (int row = 0; row < grid.size(); ++row) {
            for (int col = 0; col < grid.get(row).length(); ++col) {
                System.out.println("Row : " + row + ", col : " + col);
                if (grid.get(row).charAt(col) == '#') {
                    continue;
                }
                for (int gridRow = -fullGrids; gridRow <= fullGrids; ++gridRow) {
                    int actualRowInGridRow = row + gridRow * grid.size();
                    int leftBoundInActualRow = -(steps - grid.size() / 2) + Math.abs(actualRowInGridRow - grid.size() / 2);
                    int rightBoundInActualRow = (steps + grid.size() / 2) - Math.abs(actualRowInGridRow - grid.size() / 2);
                    if ((leftBoundInActualRow > col) || (rightBoundInActualRow < col)) {
                        continue;
                    }
                    int distanceFromCenter = Math.abs(actualRowInGridRow - grid.size() / 2) + Math.abs(col - grid.get(0).length() / 2);
                    int appearancesToLeft = (col - leftBoundInActualRow) / grid.get(0).length();
                    if (distanceFromCenter % 2 == 0) {
                        res += (appearancesToLeft + 1) / 2;
                    } else {
                        res += (appearancesToLeft) / 2 + 1;
                    }
                    int appearancesToRight = (rightBoundInActualRow - col) / grid.get(0).length();
                    if (distanceFromCenter % 2 == 0) {
                        res += (appearancesToRight + 1) / 2;
                    } else {
                        res += (appearancesToRight) / 2;
                    }
                }
            }
        }
        return res;
    }

    private Cell topLeftCorner(int gridOnBorderColumn, int gridOnBorderRow) {
        return new Cell(gridOnBorderRow * grid.size(), gridOnBorderColumn * grid.get(0).length());
    }

    private Cell center(int gridOnBorderColumn, int gridOnBorderRow) {
        return new Cell(gridOnBorderRow * grid.size() + grid.size() / 2, gridOnBorderColumn * grid.get(0).length() + grid.get(0).length() / 2);
    }

    private long calculateForGrid(Cell topLeftCorner, int distance) {
        long res = 0;
        Cell center = new Cell(grid.size() / 2, grid.get(0).length() / 2);
        for (int row = 0; row < grid.size(); ++row) {
            for (int col = 0; col < grid.get(row).length(); ++col) {
                if (grid.get(row).charAt(col) == '#') {
                    continue;
                }
                int distanceFromCenter = Math.abs(row + topLeftCorner.getRow() - center.getRow())
                        + Math.abs(col + topLeftCorner.getColumn() - center.getColumn());
                if ((distanceFromCenter % 2) != (distance % 2)) {
                    continue;
                }
                if (distanceFromCenter <= distance) {
                    res++;
                }
            }
        }
        return res;
    }

    private int distanceFromCenter(Cell cell) {
        return Math.abs(cell.getRow() - grid.size() / 2) + Math.abs(cell.getColumn() - grid.get(0).length() / 2);
    }

    private int nonWallsMatchingPredicate(Predicate<Cell> predicate) {
        int res = 0;
        for (int row = 0; row < grid.size(); ++row) {
            for (int col = 0; col < grid.get(row).length(); ++col) {
                if (grid.get(row).charAt(col) == '#') {
                    continue;
                }
                if (predicate.test(new Cell(row, col))) {
                    res++;
                }
            }
        }
        return res;
    }
}
