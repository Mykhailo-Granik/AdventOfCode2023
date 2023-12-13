package solutions.dec13;

import java.util.List;
import java.util.Objects;

public class Land {

    private final List<String> landMap;

    public Land(List<String> landMap) {
        this.landMap = landMap;
    }

    public List<String> getLandMap() {
        return landMap;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Land land = (Land) o;
        return Objects.equals(landMap, land.landMap);
    }

    @Override
    public int hashCode() {
        return Objects.hash(landMap);
    }

    @Override
    public String toString() {
        return landMap.toString();
    }
}
