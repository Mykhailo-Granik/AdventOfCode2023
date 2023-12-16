package solutions.dec16;

import java.util.*;

import static java.util.stream.Collectors.toList;

public class Contraption {

    private final List<List<Tile>> grid;
    private final Beam start;

    public Contraption(List<String> contraption, Beam start) {
        grid = contraption.stream()
                .map(this::rowOfTiles)
                .collect(toList());
        this.start = start;
    }

    private List<Tile> rowOfTiles(String row) {
        TileFactory tileFactory = new TileFactory();
        return row.chars()
                .mapToObj(c -> (char) c)
                .map(tileFactory::create)
                .collect(toList());
    }

    public int getNumberOfEnergizedTiles() {
        Set<Beam> visited = new HashSet<>();
        visited.add(start);
        Queue<Beam> queue = new LinkedList<>();
        queue.add(start);
        while (!queue.isEmpty()) {
            Beam beam = queue.poll();
            Tile tile = grid.get(beam.getRow()).get(beam.getColumn());
            List<Beam> nextBeams = tile.collide(beam).stream()
                    .filter(nextBeam -> !visited.contains(nextBeam))
                    .filter(nextBeam -> nextBeam.insideGrid(grid.size(), grid.get(0).size()))
                    .collect(toList());
            visited.addAll(nextBeams);
            queue.addAll(nextBeams);
        }
        boolean[][] visitedTiles = new boolean[grid.size()][grid.get(0).size()];
        for (Beam beam : visited) {
            visitedTiles[beam.getRow()][beam.getColumn()] = true;
        }
        int res = 0;
        for (boolean[] visitedTileRow : visitedTiles) {
            for (boolean visitedTile : visitedTileRow) {
                if (visitedTile) {
                    res++;
                }
            }
        }
        return res;
    }
}
