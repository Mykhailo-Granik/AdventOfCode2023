package solutions.dec13;

import java.util.stream.IntStream;

public class RegularLandSymmetryCalculator implements LandSymmetryCalculator {
    @Override
    public int horizontalMirrorLocationOrMinusOne(Land land) {
        return horizontalMirrorLocationIgnoringRow(land, -1);
    }

    private boolean isSymmetricalHorizontally(Land land, int row) {
        int topPartIndex = row;
        int bottomPartIndex = row + 1;
        while ((topPartIndex >= 0) && (bottomPartIndex < land.getLandMap().size())) {
            if (!land.getLandMap().get(topPartIndex).equals(land.getLandMap().get(bottomPartIndex))) {
                return false;
            }
            --topPartIndex;
            ++bottomPartIndex;
        }
        return true;
    }


    @Override
    public int verticalMirrorLocationOrMinusOne(Land land) {
        return verticalMirrorLocationIgnoringColumn(land, -1);
    }

    @Override
    public int horizontalMirrorLocationIgnoringRow(Land land, int rowToIgnore) {
        for (int row = 0; row < land.getLandMap().size() - 1; ++row) {
            if (row == rowToIgnore) {
                continue;
            }
            if (isSymmetricalHorizontally(land, row)) {
                return row + 1;
            }
        }
        return -1;
    }

    @Override
    public int verticalMirrorLocationIgnoringColumn(Land land, int columnToIgnore) {
        for (int column = 0; column < land.getLandMap().get(0).length() - 1; ++column) {
            if (column == columnToIgnore) {
                continue;
            }
            if (isSymmetricalVertically(land, column)) {
                return column + 1;
            }
        }
        return -1;
    }

    private boolean isSymmetricalVertically(Land land, int column) {
        int leftPartIndex = column;
        int rightPartIndex = column + 1;
        while ((leftPartIndex >= 0) && (rightPartIndex < land.getLandMap().get(0).length())) {
            if (!isSymmetricalVertically(land, leftPartIndex, rightPartIndex)) {
                return false;
            }
            --leftPartIndex;
            ++rightPartIndex;
        }
        return true;
    }

    private boolean isSymmetricalVertically(Land land, int leftColumn, int rightColumn) {
        return IntStream.range(0, land.getLandMap().size())
                .allMatch(row -> land.getLandMap().get(row).charAt(leftColumn) == land.getLandMap().get(row).charAt(rightColumn));
    }
}
