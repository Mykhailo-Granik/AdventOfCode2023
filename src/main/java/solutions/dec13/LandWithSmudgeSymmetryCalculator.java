package solutions.dec13;

import java.util.ArrayList;
import java.util.List;

public class LandWithSmudgeSymmetryCalculator implements LandSymmetryCalculator {

    @Override
    public int horizontalMirrorLocationOrMinusOne(Land land) {
        RegularLandSymmetryCalculator regularLandSymmetryCalculator = new RegularLandSymmetryCalculator();
        int oldHorizontalMirrorLocation =
                regularLandSymmetryCalculator.horizontalMirrorLocationOrMinusOne(land);
        List<Land> landsWithSmudge = generateAllPossibleWithOneSmudge(land);
        return landsWithSmudge.stream()
                .mapToInt(landWithSmudge -> regularLandSymmetryCalculator.horizontalMirrorLocationIgnoringRow(landWithSmudge, oldHorizontalMirrorLocation - 1))
                .filter(mirrorLocation -> mirrorLocation != oldHorizontalMirrorLocation)
                .filter(mirrorLocation -> mirrorLocation != -1)
                .findFirst()
                .orElse(-1);
    }

    private List<Land> generateAllPossibleWithOneSmudge(Land land) {
        List<String> landMap = land.getLandMap();
        List<Land> lands = new ArrayList<>();
        for (int row = 0; row < landMap.size(); row++) {
            for (int column = 0; column < landMap.get(row).length(); column++) {
                lands.add(createLandWithSmudge(landMap, row, column));
            }
        }
        return lands;
    }

    private Land createLandWithSmudge(List<String> landMap, int row, int column) {
        char otherChar = landMap.get(row).charAt(column) == '#' ? '.' : '#';
        List<String> updatedMap = new ArrayList<>(landMap);
        updatedMap.set(row, landMap.get(row).substring(0, column) + otherChar + landMap.get(row).substring(column + 1));
        return new Land(updatedMap);
    }

    @Override
    public int verticalMirrorLocationOrMinusOne(Land land) {
        RegularLandSymmetryCalculator regularLandSymmetryCalculator = new RegularLandSymmetryCalculator();
        int oldVerticalMirrorLocation = regularLandSymmetryCalculator.verticalMirrorLocationOrMinusOne(land);
        List<Land> landsWithSmudge = generateAllPossibleWithOneSmudge(land);
        return landsWithSmudge.stream()
                .mapToInt(landWithSmudge -> regularLandSymmetryCalculator.verticalMirrorLocationIgnoringColumn(landWithSmudge, oldVerticalMirrorLocation - 1))
                .filter(mirrorLocation -> mirrorLocation != oldVerticalMirrorLocation)
                .filter(mirrorLocation -> mirrorLocation != -1)
                .findFirst()
                .orElse(-1);
    }

    @Override
    public int horizontalMirrorLocationIgnoringRow(Land land, int row) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int verticalMirrorLocationIgnoringColumn(Land land, int columnToIgnore) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
