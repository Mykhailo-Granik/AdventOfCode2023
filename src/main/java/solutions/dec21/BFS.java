package solutions.dec21;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {

    private final List<String> grid;

    public BFS(List<String> grid) {
        this.grid = grid;
    }

    public void distances() {
        Cell start = new Cell(65, 130);
        int[][] distances = new int[grid.size()][grid.get(0).length()];
        for (int[] distance : distances) {
            Arrays.fill(distance, Integer.MAX_VALUE);
        }
        Queue<Cell> queue = new LinkedList<>();
        queue.add(start);
        distances[start.getRow()][start.getColumn()] = 0;
        while (!queue.isEmpty()) {
            Cell cell = queue.poll();
            NextCellsGenerator nextCellsGenerator = new NextCellsGenerator(grid);
            List<Cell> nextCells = nextCellsGenerator.generate(cell);
            for (Cell nextCell : nextCells) {
                if (distances[nextCell.row][nextCell.column] == Integer.MAX_VALUE) {
                    distances[nextCell.row][nextCell.column] = distances[cell.row][cell.column] + 1;
                    queue.add(nextCell);
                }
            }
        }
        for (int row = 0; row < grid.size(); ++row) {
            for (int column = 0; column < grid.get(0).length(); ++column) {
                if (grid.get(row).charAt(column) == '#') {
                    continue;
                }
                int d1 = distances[row][column];
                int d2 = Math.abs(row - start.getRow()) + Math.abs(column - start.getColumn());
                if (d1 != d2) {
                    System.out.println("FAIL " + row + " " + column + " " + d1 + " " + d2);
                }
            }
        }
    }
}
