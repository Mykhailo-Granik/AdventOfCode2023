package solutions.dec5;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SeedToLocationMapperTest {

    @Test
    public void shouldFindLocationForDirectMap() {
        SeedToLocationMapper seedToLocationMapper = new SeedToLocationMapper(List.of(
                new Map("seed", "location", List.of(
                        new Map.MappingRange(50, 98, 2),
                        new Map.MappingRange(52, 50, 48)
                ))
        ));
        assertEquals(52, seedToLocationMapper.seedLocation(50));
    }

    @Test
    public void shouldFindLocationForMultipleMaps() {
        Map seedToSoilMap = new Map("seed", "soil", List.of(
                new Map.MappingRange(50, 98, 2),
                new Map.MappingRange(52, 50, 48)
        ));
        Map soilToLocationMap = new Map("soil", "location", List.of(
                new Map.MappingRange(1, 1, 2),
                new Map.MappingRange(32, 3, 1)
        ));
        assertEquals(
                32,
                new SeedToLocationMapper(
                        List.of(
                                seedToSoilMap,
                                soilToLocationMap
                        )
                ).seedLocation(3)
        );
    }
}