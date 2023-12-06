package solutions;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Solution1Dec1Test {

    @Test
    public void shouldCalculateForLineWithOneNumber() {
        Solution1Dec1 underTest = new Solution1Dec1(Collections.singletonList("1"));
        assertEquals(11, underTest.findCalibration());
    }

    @Test
    public void shouldCalculateForLineWithTwoNumbers() {
        Solution1Dec1 underTest = new Solution1Dec1(Collections.singletonList("12"));
        assertEquals(12, underTest.findCalibration());
    }

    @Test
    public void shouldIgnoreLeadingNonDigitCharacters() {
        Solution1Dec1 underTest = new Solution1Dec1(Collections.singletonList("a12"));
        assertEquals(12, underTest.findCalibration());
    }

    @Test
    public void shouldIgnoreTrailingNonDigitCharacters() {
        Solution1Dec1 underTest = new Solution1Dec1(Collections.singletonList("12a"));
        assertEquals(12, underTest.findCalibration());
    }

    @Test
    public void shouldCalculateForMultipleLines() {
        Solution1Dec1 underTest = new Solution1Dec1(List.of("a11n", "c12D"));
        assertEquals(23, underTest.findCalibration());
    }

    @Test
    public void shouldCorrectlyFindFirstDigitSpelledAsWord() {
        Solution1Dec1 underTest = new Solution1Dec1(Collections.singletonList("one2"));
        assertEquals(12, underTest.findCalibration());
    }

    @Test
    public void shouldCorrectlyFindLastDigitSpelledAsWord() {
        Solution1Dec1 underTest = new Solution1Dec1(Collections.singletonList("2one"));
        assertEquals(21, underTest.findCalibration());
    }

}