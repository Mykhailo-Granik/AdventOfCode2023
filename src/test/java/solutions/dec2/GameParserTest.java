package solutions.dec2;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GameParserTest {

    @Test
    public void shouldParseGameWithOneSetOfRedCubes() {
        GameParser underTest = new GameParser();
        Game result = underTest.parse("Game 1: 1 red");
        assertEquals(new Game(List.of(new SetOfCubes(1, 0, 0)), 1), result);
    }

    @Test
    public void shouldParseGameWithOneSetOfBlueCubes() {
        GameParser underTest = new GameParser();
        Game result = underTest.parse("Game 1: 2 blue");
        assertEquals(new Game(List.of(new SetOfCubes(0, 0, 2)), 1), result);
    }

    @Test
    public void shouldParseGameWithOneSetOfGreenCubes() {
        GameParser underTest = new GameParser();
        Game result = underTest.parse("Game 2: 3 green");
        assertEquals(new Game(List.of(new SetOfCubes(0, 3, 0)), 2), result);
    }

    @Test
    public void shouldGameWithRedGreenAndBlueCubes() {
        GameParser underTest = new GameParser();
        Game result = underTest.parse("Game 3: 1 red, 2 green, 3 blue");
        assertEquals(new Game(List.of(new SetOfCubes(1, 2, 3)), 3), result);
    }

    @Test
    public void shouldParseGameWithTwoSetsOfCubes() {
        GameParser underTest = new GameParser();
        Game result = underTest.parse("Game 4: 1 red, 2 green, 3 blue; 2 red, 3 green, 4 blue");
        assertEquals(new Game(List.of(new SetOfCubes(1, 2, 3), new SetOfCubes(2, 3, 4)), 4), result);
    }

}