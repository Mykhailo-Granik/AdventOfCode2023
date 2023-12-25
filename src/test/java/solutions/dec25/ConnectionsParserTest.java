package solutions.dec25;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ConnectionsParserTest {

    @Test
    public void shouldParseConnections() {
        String connectionsDescription = "jqt: rhn xhk nvd";
        ConnectionsParser underTest = new ConnectionsParser();
        assertEquals(
                List.of(
                        new Connection("jqt", "rhn"),
                        new Connection("jqt", "xhk"),
                        new Connection("jqt", "nvd")
                ),
                underTest.parse(connectionsDescription)
        );
    }

}