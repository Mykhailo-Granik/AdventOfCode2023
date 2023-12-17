package solutions.dec16;

import solutions.dec17.Direction;

import java.util.List;

public class Solution {

    public int getNumberOfEnergizedTiles(List<String> contraption) {
        return new Contraption(contraption, new Beam(0, 0, Direction.RIGHT)).getNumberOfEnergizedTiles();
    }
}
