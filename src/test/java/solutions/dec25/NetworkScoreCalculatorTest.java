package solutions.dec25;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NetworkScoreCalculatorTest {

    @Test
    public void shouldCalculateScore() {
        Network network = new Network(
                List.of(
                        "jqt: rhn xhk nvd",
                        "rsh: frs pzl lsr",
                        "xhk: hfx",
                        "cmg: qnr nvd lhk bvb",
                        "rhn: xhk bvb hfx",
                        "bvb: xhk hfx",
                        "pzl: lsr hfx nvd",
                        "qnr: nvd",
                        "ntq: jqt hfx bvb xhk",
                        "nvd: lhk",
                        "lsr: lhk",
                        "rzs: qnr cmg lsr rsh",
                        "frs: qnr lhk lsr"
                )
        );
        NetworkScoreCalculator networkScoreCalculator = new NetworkScoreCalculator(network);
        assertEquals(54, networkScoreCalculator.calculateScore());
    }

}