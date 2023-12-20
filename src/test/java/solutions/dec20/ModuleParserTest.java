package solutions.dec20;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ModuleParserTest {

    @Test
    public void shouldParseAFlipFlopModule() {
        String input = "%a -> inv, con";
        FlipFlopModule module = (FlipFlopModule) new ModuleParser().parse(input);
        assertEquals("a", module.getName());
        assertEquals(List.of("inv", "con"), module.getDestinations());
        assertEquals(FlipFlopModule.State.OFF, module.getState());
    }

    @Test
    public void shouldParseAConjunctionModule() {
        String input = "&con -> output1, output2";
        ConjunctionModule module = (ConjunctionModule) new ModuleParser().parse(input);
        assertEquals("con", module.getName());
        assertEquals(List.of("output1", "output2"), module.getDestinations());
    }

    @Test
    public void shouldParseABroadcastModule() {
        String input = "broadcaster -> a, b, c";
        BroadcastModule module = (BroadcastModule) new ModuleParser().parse(input);
        assertEquals("broadcaster", module.getName());
        assertEquals(List.of("a", "b", "c"), module.getDestinations());
    }

}