package solutions.dec15;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HashTest {

    @Test
    public void shouldCalculateHashOfAOneCharString() {
        Hash underTest = new Hash("H");
        assertEquals(200, underTest.calculate());
    }

    @Test
    public void shouldCalculateHashOfAStringWithMultipleChars() {
        Hash underTest = new Hash("HASH");
        assertEquals(52, underTest.calculate());
    }

}