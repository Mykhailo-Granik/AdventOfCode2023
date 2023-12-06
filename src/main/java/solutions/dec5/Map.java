package solutions.dec5;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

import static java.util.stream.Collectors.toList;

public class Map {

    private final String source;
    private final String destination;
    private final List<MappingRange> mappingRanges;

    public Map(String source, String destination, List<MappingRange> mappingRanges) {
        this.source = source;
        this.destination = destination;
        this.mappingRanges = mappingRanges;
    }

    public long get(long value) {
        return mappingRanges.stream()
                .filter(range -> range.isInMappingRange(value))
                .findFirst()
                .map(range -> range.mapToDestination(value))
                .orElse(value);
    }

    public List<Range> mapRanges(List<Range> ranges) {
        return ranges.stream()
                .flatMap(range -> mapRange(range).stream())
                .collect(toList());
    }

    private List<Range> mapRange(Range range) {
        List<Range> sortedIntersections = mappingRanges.stream()
                .map(mappingRange -> mappingRange.intersectWith(range))
                .filter(Range::isNotEmpty)
                .sorted(Comparator.comparingLong(Range::getFrom))
                .collect(toList());
        List<Range> result = new ArrayList<>();
        long currentLeftBound = range.getFrom();
        for (Range intersection : sortedIntersections) {
            if (currentLeftBound < intersection.getFrom()) {
                result.add(new Range(currentLeftBound, intersection.getFrom() - 1));
            }
            result.add(new Range(get(intersection.getFrom()), get(intersection.getTo())));
            currentLeftBound = intersection.getTo() + 1;
        }
        if (currentLeftBound <= range.getTo()) {
            result.add(new Range(currentLeftBound, range.getTo()));
        }
        return result;
    }

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }

    public List<MappingRange> getRanges() {
        return mappingRanges;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Map map = (Map) o;
        return Objects.equals(source, map.source) && Objects.equals(destination, map.destination) && Objects.equals(mappingRanges, map.mappingRanges);
    }

    @Override
    public int hashCode() {
        return Objects.hash(source, destination, mappingRanges);
    }

    public static class MappingRange {
        private final long destinationRangeStart;
        private final long sourceRangeStart;
        private final long rangeSize;

        public MappingRange(long destinationRangeStart, long sourceRangeStart, long rangeSize) {
            this.destinationRangeStart = destinationRangeStart;
            this.sourceRangeStart = sourceRangeStart;
            this.rangeSize = rangeSize;
        }

        public long getDestinationRangeStart() {
            return destinationRangeStart;
        }

        public long getSourceRangeStart() {
            return sourceRangeStart;
        }

        public long getRangeSize() {
            return rangeSize;
        }

        public boolean isInMappingRange(long value) {
            return value >= sourceRangeStart && value < sourceRangeStart + rangeSize;
        }

        public Range intersectWith(Range range) {
            long leftBound = Math.max(sourceRangeStart, range.getFrom());
            long rightBound = Math.min(sourceRangeStart + rangeSize - 1, range.getTo());
            if (leftBound < rightBound) {
                return new Range(leftBound, rightBound);
            }
            return Range.empty();
        }

        public long mapToDestination(long value) {
            if (isInMappingRange(value)) {
                return destinationRangeStart + value - sourceRangeStart;
            }
            throw new IllegalArgumentException("Value " + value + " does not belong to range");
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            MappingRange mappingRange = (MappingRange) o;
            return destinationRangeStart == mappingRange.destinationRangeStart && sourceRangeStart == mappingRange.sourceRangeStart && rangeSize == mappingRange.rangeSize;
        }

        @Override
        public int hashCode() {
            return Objects.hash(destinationRangeStart, sourceRangeStart, rangeSize);
        }
    }

}
