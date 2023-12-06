package solutions.dec5;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class RangeSeedsParser implements SeedsParser {

    @Override
    public Stream<Long> seeds(String header, List<Map> maps) {
        String[] split = header.split(" ");
        List<Long> seeds = new ArrayList<>();
        for (int i = 1; i < split.length; i+= 2) {
            seeds.add(Long.parseLong(split[i]));
            seeds.add(Long.parseLong(split[i]) + Long.parseLong(split[i + 1]));
        }
        for (Map map : maps) {
            for (Map.MappingRange mappingRange : map.getRanges()) {
                seeds.add(mappingRange.getSourceRangeStart());
                seeds.add(mappingRange.getSourceRangeStart() + mappingRange.getRangeSize());
                seeds.add(mappingRange.getDestinationRangeStart());
                seeds.add(mappingRange.getDestinationRangeStart() + mappingRange.getRangeSize());
            }
        }
        return seeds.stream();
    }
}
