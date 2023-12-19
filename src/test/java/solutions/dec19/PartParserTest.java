package solutions.dec19;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PartParserTest {

    @Test
    public void shouldParseAPart() {
        PartParser underTest = new PartParser();
        Part part = underTest.parse("{x=787,m=2655,a=1222,s=2876}");
        assertEquals(new Part(787, 2655, 1222, 2876), part);
    }

}