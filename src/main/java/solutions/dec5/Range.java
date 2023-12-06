package solutions.dec5;

public class Range {

    private final long from;
    private final long to;

    public Range(long from, long to) {
        this.from = from;
        this.to = to;
    }

    public static Range empty() {
        return new Range(0, -1);
    }

    public boolean isEmpty() {
        return from == 0 && to == -1;
    }

    public boolean isNotEmpty() {
        return !isEmpty();
    }

    public long getFrom() {
        return from;
    }

    public long getTo() {
        return to;
    }
}
