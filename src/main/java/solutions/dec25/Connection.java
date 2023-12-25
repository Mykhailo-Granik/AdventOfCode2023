package solutions.dec25;

import java.util.Objects;

public class Connection {

    private final String end1;
    private final String end2;

    public Connection(String end1, String end2) {
        this.end1 = end1;
        this.end2 = end2;
    }

    public String otherEnd(String end) {
        if (end.equals(end1)) {
            return end2;
        }
        if (end.equals(end2)) {
            return end1;
        }
        throw new IllegalArgumentException("Invalid end: " + end);
    }

    public String getEnd1() {
        return end1;
    }

    public String getEnd2() {
        return end2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Connection that = (Connection) o;
        return Objects.equals(end1, that.end1) && Objects.equals(end2, that.end2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(end1, end2);
    }

    @Override
    public String toString() {
        return "Connection{" +
                "end1='" + end1 + '\'' +
                ", end2='" + end2 + '\'' +
                '}';
    }
}
