package solutions.dec19;

import java.util.Objects;

public class Part {

    private final int x;
    private final int m;
    private final int a;
    private final int s;

    public Part(int x, int m, int a, int s) {
        this.x = x;
        this.m = m;
        this.a = a;
        this.s = s;
    }

    public int getParameter(String name) {
        switch (name) {
            case "x":
                return x;
            case "m":
                return m;
            case "a":
                return a;
            case "s":
                return s;
            default:
                throw new IllegalArgumentException("Unknown parameter: " + name);
        }
    }

    public int score() {
        return x + m + a + s;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Part part = (Part) o;
        return x == part.x && m == part.m && a == part.a && s == part.s;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, m, a, s);
    }

    @Override
    public String toString() {
        return "Part{" +
                "x=" + x +
                ", m=" + m +
                ", a=" + a +
                ", s=" + s +
                '}';
    }
}
