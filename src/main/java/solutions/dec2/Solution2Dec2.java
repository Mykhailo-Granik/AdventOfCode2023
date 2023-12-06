package solutions.dec2;

import java.util.List;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.ToIntFunction;

public class Solution2Dec2 {

    public int sumOfPowers(List<String> games) {
        return games.stream()
                .map(game -> new GameParser().parse(game))
                .mapToInt(this::power)
                .sum();
    }

    private int power(Game game) {
        return redsCubesInTheBag(game) *
                blueCubesInTheBag(game) *
                greenCubesInTheBag(game);
    }

    private int redsCubesInTheBag(Game game) {
        return cubesInTgeBag(game, SetOfCubes::getRed);
    }

    private int blueCubesInTheBag(Game game) {
        return cubesInTgeBag(game, SetOfCubes::getBlue);
    }

    private int greenCubesInTheBag(Game game) {
        return cubesInTgeBag(game, SetOfCubes::getGreen);
    }

    private int cubesInTgeBag(Game game, ToIntFunction<SetOfCubes> cubes) {
        return game.getSetsOfCubes().stream()
                .mapToInt(cubes)
                .max()
                .orElse(0);
    }

}
