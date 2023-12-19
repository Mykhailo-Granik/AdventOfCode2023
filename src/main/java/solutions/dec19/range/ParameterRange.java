package solutions.dec19.range;

import java.util.Objects;

public class ParameterRange {

    private final String parameterName;
    private final int from;
    private final int to;

    public ParameterRange(String parameterName, int from, int to) {
        this.parameterName = parameterName;
        this.from = from;
        this.to = to;
    }

    public int length() {
        return Math.max(to - from + 1, 0);
    }

    public boolean isEmpty() {
        return length() == 0;
    }

    public String getParameterName() {
        return parameterName;
    }

    public ParameterRange withFrom(int from) {
        return new ParameterRange(parameterName, from, to);
    }

    public ParameterRange withTo(int to) {
        return new ParameterRange(parameterName, from, to);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParameterRange that = (ParameterRange) o;
        return from == that.from && to == that.to && Objects.equals(parameterName, that.parameterName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(parameterName, from, to);
    }

    @Override
    public String toString() {
        return "ParameterRange{" +
                "parameterName='" + parameterName + '\'' +
                ", from=" + from +
                ", to=" + to +
                '}';
    }
}
