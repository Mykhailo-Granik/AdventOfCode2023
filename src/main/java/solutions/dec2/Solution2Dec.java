package solutions.dec2;

import java.util.List;

public class Solution2Dec {

    private static final int RED_CUBES = 12;
    private static final int GREEN_CUBES = 13;
    private static final int BLUE_CUBES = 14;

    public int sumOfValidIds(List<String> games) {
        return games.stream()
                .map(game -> new GameParser().parse(game))
                .filter(this::isValid)
                .mapToInt(Game::getId)
                .sum();
    }

    private boolean isValid(Game game) {
        return game.getSetsOfCubes().stream()
                .allMatch(this::isValid);
    }

    private boolean isValid(SetOfCubes setOfCubes) {
        return setOfCubes.getRed() <= RED_CUBES &&
                setOfCubes.getGreen() <= GREEN_CUBES &&
                setOfCubes.getBlue() <= BLUE_CUBES;
    }

}
