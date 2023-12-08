package solutions.dec8;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NodeParserTest {

    @Test
    public void shouldParseNode() {
        String nodeString = "AAA = (BBB, CCC)";
        NodeParser underTest = new NodeParser();
        assertEquals(new Node("AAA", "BBB", "CCC"), underTest.parse(nodeString));
    }

}