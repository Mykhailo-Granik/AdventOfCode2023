package solutions.dec11;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GalaxyTest {

    @Test
    public void shouldFindDistanceToGalaxyToTheRight() {
        Galaxy underTest = new Galaxy(1, 1);
        Galaxy other = new Galaxy(1, 3);
        assertEquals(2, underTest.distanceTo(other));
    }

    @Test
    public void shouldFindDistanceToGalaxyToTheLeft() {
        Galaxy underTest = new Galaxy(1, 3);
        Galaxy other = new Galaxy(1, 1);
        assertEquals(2, underTest.distanceTo(other));
    }

    @Test
    public void shouldFindDistanceToGalaxyAbove() {
        Galaxy underTest = new Galaxy(3, 1);
        Galaxy other = new Galaxy(1, 1);
        assertEquals(2, underTest.distanceTo(other));
    }

    @Test
    public void shouldFindDistanceToGalaxyBelow() {
        Galaxy underTest = new Galaxy(1, 1);
        Galaxy other = new Galaxy(3, 1);
        assertEquals(2, underTest.distanceTo(other));
    }

}