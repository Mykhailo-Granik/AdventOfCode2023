package solutions.dec19.range;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

public class ParametersRange {

    private final List<ParameterRange> parameterRanges;

    public ParametersRange(List<ParameterRange> parameterRanges) {
        this.parameterRanges = parameterRanges;
    }

    public static ParametersRange empty() {
        return new ParametersRange(List.of());
    }

    public boolean isEmpty() {
        if (parameterRanges.isEmpty()) {
            return true;
        }
        return parameterRanges.stream().anyMatch(ParameterRange::isEmpty);
    }

    public ParameterRange findParameterRangeByName(String name) {
        return parameterRanges.stream()
                .filter(parameterRange -> parameterRange.getParameterName().equals(name))
                .findFirst()
                .orElseThrow();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParametersRange that = (ParametersRange) o;
        return Objects.equals(parameterRanges, that.parameterRanges);
    }

    @Override
    public int hashCode() {
        return Objects.hash(parameterRanges);
    }

    @Override
    public String toString() {
        return "ParametersRange{" +
                "parameterRanges=" + parameterRanges +
                '}';
    }

    public ParametersRange updateRangeForParameter(ParameterRange parameterRange) {
        List<ParameterRange> ranges = new ArrayList<>(parameterRanges);
        int index = IntStream.range(0, parameterRanges.size())
                .filter(i -> parameterRanges.get(i).getParameterName().equals(parameterRange.getParameterName()))
                .findFirst()
                .orElseThrow();
        ranges.set(index, parameterRange);
        return new ParametersRange(ranges);
    }

    public long numberOfItemsInRange() {
        if (isEmpty()) {
            return 0;
        }
        return parameterRanges.stream()
                .mapToLong(ParameterRange::length)
                .reduce(1, (a, b) -> a * b);
    }
}
