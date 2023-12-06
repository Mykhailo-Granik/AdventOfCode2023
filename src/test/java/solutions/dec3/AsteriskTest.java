package solutions.dec3;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AsteriskTest {

    @Test
    public void shouldReturnZeroRationWhenNoNumbersProvided() {
        Asterisk underTest = new Asterisk(0, 0);
        assertEquals(0, underTest.getRatioIfGearOrZero(Collections.emptyList()));
    }

    @Test
    public void shouldReturnActualRatioIfGear() {
        Asterisk underTest = new Asterisk(0, 1);
        assertEquals(6, underTest.getRatioIfGearOrZero(
                List.of(
                        new NumberInGrid(List.of("2*3"), 0, 0, 1),
                        new NumberInGrid(List.of("2*3"), 0, 2, 3)
                )
        ));
    }
}