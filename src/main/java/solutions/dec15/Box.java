package solutions.dec15;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Box {

    private final int index;
    private final List<Lens> lenses;

    public Box(int index) {
        this.index = index;
        this.lenses = new ArrayList<>();
    }

    public int getScore() {
        int res = 0;
        for (int i = 0; i < lenses.size(); i++) {
            res += lenses.get(i).getFocalLength() * (i + 1);
        }
        return res * (index + 1);
    }

    public void addLens(Lens lens) {
        int lensIndex = getLensIndexWithLabelOrMinusOne(lens.getLabel());
        if (lensIndex == -1) {
            lenses.add(lens);
        } else {
            lenses.set(lensIndex, lens);
        }
    }

    private int getLensIndexWithLabelOrMinusOne(String label) {
        for (int i = 0; i < lenses.size(); i++) {
            if (lenses.get(i).getLabel().equals(label)) {
                return i;
            }
        }
        return -1;
    }

    public void removeLensWithLabel(String label) {
        this.lenses.removeIf(lens -> lens.getLabel().equals(label));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Box box = (Box) o;
        return index == box.index && Objects.equals(lenses, box.lenses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(index, lenses);
    }
}
