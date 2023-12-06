package solutions.dec5;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MapsParserTest {

    @Test
    public void shouldCorrectlyParseSourceOfOneMap() {
        List<String> almanac = List.of(
                "seed-to-soil map:",
                "50 98 2",
                "52 50 48"
        );
        MapsParser mapsParser = new MapsParser();
        List<Map> maps = mapsParser.parse(almanac);
        assertEquals("seed", maps.get(0).getSource());
    }

    @Test
    public void shouldCorrectlyParseDestinationOfOneMap() {
        List<String> almanac = List.of(
                "seed-to-soil map:",
                "50 98 2",
                "52 50 48"
        );
        MapsParser mapsParser = new MapsParser();
        List<Map> maps = mapsParser.parse(almanac);
        assertEquals("soil", maps.get(0).getDestination());
    }

    @Test
    public void shouldCorrectlyParseRangesOfOneMap() {
        List<String> almanac = List.of(
                "seed-to-soil map:",
                "50 98 2",
                "52 50 48"
        );
        MapsParser mapsParser = new MapsParser();
        List<Map> maps = mapsParser.parse(almanac);
        assertEquals(
                List.of(
                        new Map.MappingRange(50, 98, 2),
                        new Map.MappingRange(52, 50, 48)
                ),
                maps.get(0).getRanges()
        );
    }

    @Test
    public void shouldCorrectlyParseMultipleMaps() {
        List<String> almanac = List.of(
                "seed-to-soil map:",
                "50 98 2",
                "52 50 48",
                "",
                "soil-to-fertilizer map:",
                "0 15 37",
                "37 52 2",
                "39 0 15"
        );
        List<Map> expected = List.of(
                new Map(
                        "seed",
                        "soil",
                        List.of(
                                new Map.MappingRange(50, 98, 2),
                                new Map.MappingRange(52, 50, 48)
                        )
                ),
                new Map(
                        "soil",
                        "fertilizer",
                        List.of(
                                new Map.MappingRange(0, 15, 37),
                                new Map.MappingRange(37, 52, 2),
                                new Map.MappingRange(39, 0, 15)
                        )
                )
        );
        MapsParser underTest = new MapsParser();
        assertEquals(expected, underTest.parse(almanac));
    }

}