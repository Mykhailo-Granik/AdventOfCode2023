package solutions.dec25;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    public void shouldCalculateNetworkScore() {
        List<String> connectionDescriptions = List.of(
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
        );
        Solution solution = new Solution();
        assertEquals(54, solution.calculateNetworkScore(connectionDescriptions));
    }

}