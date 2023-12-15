package solutions.dec15;

import java.util.ArrayList;
import java.util.List;

public class Boxes {

    private final List<Box> boxes;

    public Boxes(int amount) {
        boxes = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            boxes.add(new Box(i));
        }
    }

    public Box boxWithIndex(int index) {
        return boxes.get(index);
    }

    public int calculateTotalScore() {
        return boxes.stream().mapToInt(Box::getScore).sum();
    }
}
