package solutions.dec5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.*;

public class Solution5Dec {

    private final SeedsParser seedsParser;

    public Solution5Dec(SeedsParser seedsParser) {
        this.seedsParser = seedsParser;
    }

    public long minLocationForSeeds(List<String> almanac) {
        List<Map> maps = new MapsParser().parse(almanac.subList(2, almanac.size()));
        SeedToLocationMapper seedToLocationMapper = new SeedToLocationMapper(maps);
        return seedToLocationMapper.seedLocations(ranges(almanac.get(0))).stream()
                .map(Range::getFrom)
                .min(Long::compareTo)
                .orElseThrow();
    }

    private List<Range> ranges(String header) {
        String[] parts = header.split(" ");
        List<Range> ranges = new ArrayList<>();
        for (int i = 1; i < parts.length; i += 2) {
            long start = Long.parseLong(parts[i]);
            long end = start + Long.parseLong(parts[i + 1]);
            ranges.add(new Range(start, end));
        }
        return ranges;
    }
}
