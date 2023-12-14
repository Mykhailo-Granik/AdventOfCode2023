package solutions.dec14;

import java.util.List;
import java.util.Objects;

public class Platform {

    private final List<String> grid;

    public Platform(List<String> grid) {
        this.grid = grid;
    }

    public List<String> getGrid() {
        return grid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Platform platform = (Platform) o;
        return Objects.equals(grid, platform.grid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(grid);
    }

    @Override
    public String toString() {
        return grid.toString();
    }
}
