package solutions.dec3;

import java.util.ArrayList;
import java.util.List;

public class Asterisks {

    public List<Asterisk> findAllAsterisks(List<String> grid) {
        List<Asterisk> asterisks = new ArrayList<>();
        for (int row = 0; row < grid.size(); row++) {
            for (int column = 0; column < grid.get(row).length(); column++) {
                if (isGear(grid, row, column)) {
                    asterisks.add(new Asterisk(row, column));
                }
            }
        }
        return asterisks;
    }

    private boolean isGear(List<String> grid, int row, int column) {
        return grid.get(row).charAt(column) == '*';
    }
}
