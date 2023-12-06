package solutions.dec5;

import java.util.List;

public class SeedToLocationMapper {

    private final List<Map> maps;

    public SeedToLocationMapper(List<Map> maps) {
        this.maps = maps;
    }

    public long seedLocation(long seed) {
        Map currentMap = mapWithSource("seed");
        long currentValue = seed;
        while (!currentMap.getDestination().equals("location")) {
            currentValue = currentMap.get(currentValue);
            currentMap = mapWithSource(currentMap.getDestination());
        }
        return currentMap.get(currentValue);
    }

    public List<Range> seedLocations(List<Range> seeds) {
        Map currentMap = mapWithSource("seed");
        List<Range> currentRanges = seeds;
        while (!currentMap.getDestination().equals("location")) {
            currentRanges = currentMap.mapRanges(currentRanges);
            currentMap = mapWithSource(currentMap.getDestination());
        }
        return currentMap.mapRanges(currentRanges);
    }

    private Map mapWithSource(String source) {
        return maps.stream()
                .filter(map -> map.getSource().equals(source))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("No map found for source: " + source));
    }

}
