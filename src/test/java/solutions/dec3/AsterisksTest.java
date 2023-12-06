package solutions.dec3;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AsterisksTest {

    @Test
    public void shouldReturnEmptyListWhenNoGears() {
        Asterisks underTest = new Asterisks();
        assertEquals(0, underTest.findAllAsterisks(List.of(".")).size());
    }

    @Test
    public void shouldFindOneGear() {
        Asterisks underTest = new Asterisks();
        assertEquals(List.of(new Asterisk(0,0)), underTest.findAllAsterisks(List.of("*")));
    }

    @Test
    public void shouldFindMultipleGears() {
        Asterisks underTest = new Asterisks();
        assertEquals(
                List.of(new Asterisk(0,0), new Asterisk(1,1)),
                underTest.findAllAsterisks(List.of("*.", ".*"))
        );
    }

}