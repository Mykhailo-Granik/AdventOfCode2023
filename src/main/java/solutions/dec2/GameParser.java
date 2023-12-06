package solutions.dec2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class GameParser {

    public Game parse(String game) {
        String[] partsOfGame = game.split(";");
        List<SetOfCubes> setsOfCubes = Arrays.stream(partsOfGame)
                .map(this::parseSetOfCubes)
                .collect(toList());
        return new Game(setsOfCubes, parseId(game));
    }

    private SetOfCubes parseSetOfCubes(String setOfCubes) {
        return new SetOfCubes(
                parseColor(setOfCubes, "red"),
                parseColor(setOfCubes, "green"),
                parseColor(setOfCubes, "blue")
        );
    }

    private Integer parseId(String game) {
        int firstColon = game.indexOf(":");
        return Integer.parseInt(game.substring(5, firstColon));
    }

    private Integer parseColor(String setOfCubes, String color) {
        String[] partsOfGame = setOfCubes.split(" ");
        int redIndex = findColorPartIndex(partsOfGame, color);
        if (redIndex == -1) {
            return 0;
        }
        return Integer.parseInt(partsOfGame[redIndex - 1]);
    }

    private int findColorPartIndex(String[] partsOfSet, String color) {
        for (int i = 0; i < partsOfSet.length; i++) {
            if (partsOfSet[i].equals(color)) {
                return i;
            }
            if (partsOfSet[i].equals(color + ";")) {
                return i;
            }
            if (partsOfSet[i].equals(color + ",")) {
                return i;
            }
        }
        return -1;
    }

}
