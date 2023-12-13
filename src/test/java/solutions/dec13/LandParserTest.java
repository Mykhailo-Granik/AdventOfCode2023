package solutions.dec13;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LandParserTest {

    @Test
    public void shouldParseSingleLandMap() {
        List<String> input = List.of(
                "##.#",
                ".#.#",
                "#.#.",
                "####"
        );
        assertEquals(List.of(new Land(input)), new LandParser().parse(input));
    }

    @Test
    public void shouldParseMultipleLandMaps() {
        List<String> input = List.of(
                "##.#",
                ".#.#",
                "#.#.",
                "####",
                "",
                "##.#",
                ".#.#",
                "#.#.",
                "####"
        );
        assertEquals(List.of(new Land(input.subList(0, 4)), new Land(input.subList(5, 9))), new LandParser().parse(input));
    }

}