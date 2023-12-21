package main;


import solutions.dec21.Solution;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solver {

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println(new Solution(64).numberOfReachableCells(readLinesFromFile()));
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
