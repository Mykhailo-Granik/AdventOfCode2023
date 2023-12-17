package main;


import solutions.dec17.Solution;
import solutions.dec17.UltraCrubiclesAllowedToStopPredicate;
import solutions.dec17.UltraCrubiclesNextNodesGenerator;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solver {

    public static void main(String[] args) throws FileNotFoundException {
        List<String> grid = readLinesFromFile();
        Solution solution = new Solution(
                new UltraCrubiclesNextNodesGenerator(grid.size(), grid.get(0).length()),
                new UltraCrubiclesAllowedToStopPredicate()
        );
        System.out.println(solution.calculateShortestPath(grid));
    }

    private static List<String> readLinesFromFile() throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileInputStream("input.txt"));
        List<String> lines = new ArrayList<>();
        while (scanner.hasNextLine()) {
            lines.add(scanner.nextLine());
        }
        return lines;
    }

}
