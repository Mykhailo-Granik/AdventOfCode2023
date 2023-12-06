package solutions;

import java.util.List;

public class Solution1Dec1 {

    private static final List<String> digitsAsStrings = List.of("one", "two", "three", "four", "five", "six", "seven", "eight", "nine");

    private final List<String> input;

    public Solution1Dec1(List<String> input) {
        this.input = input;
    }

    public int findCalibration() {
        return input.stream()
                .mapToInt(this::calibrationForString)
                .sum();
    }

    private int calibrationForString(String input) {
        return findFirstDigit(input) * 10 + findLastDigit(input);
    }

    private int findFirstDigit(String input) {
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (Character.isDigit(c)) {
                return c - '0';
            }
            if (findDigitSpelledAsWord(input, i) != 0) {
                return findDigitSpelledAsWord(input, i);
            }
        }
        return 0;
    }

    private int findDigitSpelledAsWord(String input, int index) {
        for (int i = 0; i < digitsAsStrings.size(); i++) {
            String digitAsString = digitsAsStrings.get(i);
            if (input.startsWith(digitAsString, index)) {
                return i + 1;
            }
        }
        return 0;
    }

    private int findLastDigit(String input) {
        for (int i = input.length() - 1; i >= 0; i--) {
            char c = input.charAt(i);
            if (Character.isDigit(c)) {
                return c - '0';
            }
            if (findDigitSpelledAsWord(input, i) != 0) {
                return findDigitSpelledAsWord(input, i);
            }
        }
        return 0;
    }


}
