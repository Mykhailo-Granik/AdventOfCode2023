package solutions.dec9;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Values {

    private final List<Long> values;

    public Values(List<Long> values) {
        this.values = values;
    }

    public List<Long> getValuesAsList() {
        return new ArrayList<>(values);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Values values1 = (Values) o;
        return Objects.equals(values, values1.values);
    }

    @Override
    public int hashCode() {
        return Objects.hash(values);
    }

    @Override
    public String toString() {
        return values.toString();
    }
}
