package solutions.dec13;

public interface LandSymmetryCalculator {

    int horizontalMirrorLocationOrMinusOne(Land land);

    int verticalMirrorLocationOrMinusOne(Land land);

    int horizontalMirrorLocationIgnoringRow(Land land, int rowToIgnore);

    int verticalMirrorLocationIgnoringColumn(Land land, int columnToIgnore);

}
