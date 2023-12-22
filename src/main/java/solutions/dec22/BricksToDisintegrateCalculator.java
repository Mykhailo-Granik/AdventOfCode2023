package solutions.dec22;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class BricksToDisintegrateCalculator {

    private final List<Brick> bricks;

    public BricksToDisintegrateCalculator(List<Brick> bricks) {
        this.bricks = bricks;
    }

    public int calculate() {
        boolean[] canBeDisintegrated = whatCanBeDisintegrated();
        int res = 0;
        for (int i = 0; i < bricks.size(); ++i) {
            if (canBeDisintegrated[i]) {
                res++;
            }
        }
        return res;
    }

    public int calculateTotalAmountOfFalls() {
        boolean[] canBeDisintegrated = whatCanBeDisintegrated();
        List<Brick> bricksAfterFall = fall();
        List<List<Integer>> supports = new ArrayList<>();
        for (int i = 0; i < bricksAfterFall.size(); ++i) {
            supports.add(new ArrayList<>());
        }
        int[] bricksThatSupportMe = new int[bricksAfterFall.size()];
        for (int i = 1; i < bricksAfterFall.size(); ++i) {
            Brick currentBrick = bricksAfterFall.get(i);
            int maxZThatSupportsCurrentBrick = 0;
            List<Integer> intersections = new ArrayList<>();
            for (int j = 0; j < i; ++j) {
                Brick previousBrick = bricksAfterFall.get(j);
                if (currentBrick.projectionOnXY().intersects(previousBrick.projectionOnXY())) {
                    int maxZOfPreviousBrick = previousBrick.getSecondEnd().getZ();
                    if (maxZOfPreviousBrick > maxZThatSupportsCurrentBrick) {
                        maxZThatSupportsCurrentBrick = maxZOfPreviousBrick;
                        intersections.clear();
                        intersections.add(j);
                    } else if (maxZOfPreviousBrick == maxZThatSupportsCurrentBrick) {
                        intersections.add(j);
                    }
                }
            }
            bricksThatSupportMe[i] = intersections.size();
            for (Integer intersection : intersections) {
                supports.get(intersection).add(i);
            }
        }
        int res = 0;
        for (int disintegratedBrickIndex = 0; disintegratedBrickIndex < bricks.size(); ++disintegratedBrickIndex) {
            if (canBeDisintegrated[disintegratedBrickIndex]) {
                continue;
            }
            int[] fallenBricksThatSupportMe = new int[bricksAfterFall.size()];
            for (Integer brick : supports.get(disintegratedBrickIndex)) {
                fallenBricksThatSupportMe[brick] = 1;
            }
            for (int i = 0; i < bricksAfterFall.size(); ++i) {
                if (bricksThatSupportMe[i] == 0) {
                    continue;
                }
                if (fallenBricksThatSupportMe[i] == bricksThatSupportMe[i]) {
                    res++;
                    for (Integer brick : supports.get(i)) {
                        fallenBricksThatSupportMe[brick]++;
                    }
                }
            }
        }
        return res;
    }

    private boolean[] whatCanBeDisintegrated() {
        List<Brick> bricksAfterFall = fall();
        boolean[] canBeDisintegrated = new boolean[bricksAfterFall.size()];
        Arrays.fill(canBeDisintegrated, true);
        for (int i = 0; i < bricksAfterFall.size(); i++) {
            int maxZThatSupportsCurrentBrick = 0;
            Brick currentBrick = bricksAfterFall.get(i);
            List<Integer> intersections = new ArrayList<>();
            for (int j = 0; j < i; ++j) {
                Brick previousBrick = bricksAfterFall.get(j);
                if (currentBrick.projectionOnXY().intersects(previousBrick.projectionOnXY())) {
                    int maxZOfPreviousBrick = previousBrick.getSecondEnd().getZ();
                    if (maxZOfPreviousBrick > maxZThatSupportsCurrentBrick) {
                        maxZThatSupportsCurrentBrick = maxZOfPreviousBrick;
                        intersections.clear();
                        intersections.add(j);
                    } else if (maxZOfPreviousBrick == maxZThatSupportsCurrentBrick) {
                        intersections.add(j);
                    }
                }
            }
            if (intersections.size() == 1) {
                canBeDisintegrated[intersections.get(0)] = false;
            }
        }
        return canBeDisintegrated;
    }

    private List<Brick> fall() {
        List<Brick> sortedBricks = bricks.stream()
                .sorted(Comparator.comparingInt(brick -> brick.getFirstEnd().getZ()))
                .collect(toList());
        List<Brick> result = new ArrayList<>();
        result.add(
                new Brick(
                        new Point3D(sortedBricks.get(0).getFirstEnd().getX(), sortedBricks.get(0).getFirstEnd().getY(), 1),
                        new Point3D(sortedBricks.get(0).getSecondEnd().getX(), sortedBricks.get(0).getSecondEnd().getY(), sortedBricks.get(0).getSecondEnd().getZ() - sortedBricks.get(0).getFirstEnd().getZ() + 1)
                )
        );
        for (int i = 1; i < sortedBricks.size(); ++i) {
            Brick currentBrick = sortedBricks.get(i);
            int bestZPossible = 1;
            for (Brick previousBrick : result) {
                if (currentBrick.projectionOnXY().intersects(previousBrick.projectionOnXY())) {
                    int maxZOfPreviousBrick = previousBrick.getSecondEnd().getZ();
                    if (maxZOfPreviousBrick + 1 > bestZPossible) {
                        bestZPossible = maxZOfPreviousBrick + 1;
                    }
                }
            }
            int difference = currentBrick.getFirstEnd().getZ() - bestZPossible;
            if (difference < 0) {
                throw new RuntimeException("Brick " + currentBrick + " cannot fall");
            }
            result.add(new Brick(
                    new Point3D(currentBrick.getFirstEnd().getX(), currentBrick.getFirstEnd().getY(), currentBrick.getFirstEnd().getZ() - difference),
                    new Point3D(currentBrick.getSecondEnd().getX(), currentBrick.getSecondEnd().getY(), currentBrick.getSecondEnd().getZ() - difference)
            ));
        }
        return result;
    }
}
