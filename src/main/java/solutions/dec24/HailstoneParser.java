package solutions.dec24;

import static java.lang.Long.parseLong;

public class HailstoneParser {


    public Hailstone parse(String hailstone) {
        //"20, 19, 15 @  1, -5, -3"
        String startingPositions = hailstone.substring(0, hailstone.indexOf("@")).trim();
        String velocities = hailstone.substring(hailstone.indexOf("@") + 1).trim();
        String[] startingPositionsArray = startingPositions.split(", ");
        String[] velocitiesArray = velocities.split(", ");
        return new Hailstone(
                new CoordinateChangeVector(
                        parseLong(startingPositionsArray[0].trim()),
                        parseLong(velocitiesArray[0].trim())
                ),
                new CoordinateChangeVector(
                        parseLong(startingPositionsArray[1].trim()),
                        parseLong(velocitiesArray[1].trim())
                ),
                new CoordinateChangeVector(
                        parseLong(startingPositionsArray[2].trim()),
                        parseLong(velocitiesArray[2].trim())
                )
        );
    }
}
