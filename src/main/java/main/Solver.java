package main;

import solutions.dec5.RangeSeedsParser;
import solutions.dec5.SimpleSeedsParser;
import solutions.dec5.Solution5Dec;
import solutions.dec6.Solution1;
import solutions.dec6.Solution2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solver {

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println(new Solution2().calculateNumberOfWaysToWin(readLinesFromFile()));
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
