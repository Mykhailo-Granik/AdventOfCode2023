package solutions.dec22;

public class BrickParser {

    public Brick parse(String brickDescription) {
        String[] pointsDescription = brickDescription.split("~");
        return new Brick(
                parsePoint(pointsDescription[0]),
                parsePoint(pointsDescription[1])
        );
    }

    private Point3D parsePoint(String pointDescription) {
        String[] coordinates = pointDescription.split(",");
        return new Point3D(
                Integer.parseInt(coordinates[0]),
                Integer.parseInt(coordinates[1]),
                Integer.parseInt(coordinates[2])
        );
    }
}
