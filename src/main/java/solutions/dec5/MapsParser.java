package solutions.dec5;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class MapsParser {

    public static final int HEADER_LINES_COUNT = 1;

    public List<Map> parse(List<String> almanac) {
        return mapsInsideAlmanac(almanac).stream()
                .map(this::parseMap)
                .collect(toList());
    }

    private Map parseMap(List<String> almanac) {
        return new Map(
                parseSource(almanac.get(0)),
                parseDestination(almanac.get(0)),
                parseRanges(almanac)
        );
    }

    private List<List<String>> mapsInsideAlmanac(List<String> almanac) {
        int mapStartLine = 0;
        List<List<String>> maps = new ArrayList<>();
        while (mapStartLine < almanac.size()) {
            maps.add(parseMap(almanac, mapStartLine));
            mapStartLine += maps.get(maps.size() - 1).size() + 1;
        }
        return maps;
    }

    private List<String> parseMap(List<String> almanac, int mapStartLine) {
        int mapEndLine = mapStartLine;
        while (mapEndLine < almanac.size()) {
            if (almanac.get(mapEndLine).equals("")) {
                break;
            }
            mapEndLine++;
        }
        return almanac.subList(mapStartLine, mapEndLine);
    }

    private String parseSource(String header) {
        return header.split("-")[0];
    }

    private String parseDestination(String header) {
        return header.split("-")[2].split(" ")[0];
    }

    private List<Map.MappingRange> parseRanges(List<String> map) {
        return map.stream()
                .skip(HEADER_LINES_COUNT)
                .map(this::parseRange)
                .collect(toList());
    }

    private Map.MappingRange parseRange(String range) {
        String[] rangeParts = range.split(" ");
        return new Map.MappingRange(
                Long.parseLong(rangeParts[0]),
                Long.parseLong(rangeParts[HEADER_LINES_COUNT]),
                Long.parseLong(rangeParts[2])
        );
    }
}
