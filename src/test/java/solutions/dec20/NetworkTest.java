package solutions.dec20;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NetworkTest {

    @Test
    public void shouldPropagatePulseOverNetwork() {
        List<Module> modules = List.of(
                new BroadcastModule("broadcaster", List.of("a", "b", "c")),
                new FlipFlopModule("a", List.of("b")),
                new FlipFlopModule("b", List.of("c")),
                new FlipFlopModule("c", List.of("inv")),
                new ConjunctionModule("inv", List.of("a"))
        );
        Network network = new Network(modules);
        network.sendPulseAndPropagate(new PulsePackage(Pulse.LOW, "button", "broadcaster"));
        assertEquals(8, network.getLowPulsesReceived());
        assertEquals(4, network.getHighPulsesReceived());
    }

    @Test
    public void shouldPropagateMultiplePulsesOverNetwork() {
        List<Module> modules = List.of(
                new BroadcastModule("broadcaster", List.of("a")),
                new FlipFlopModule("a", List.of("inv", "con")),
                new ConjunctionModule("inv", List.of("b")),
                new FlipFlopModule("b", List.of("con")),
                new ConjunctionModule("con", List.of("output")),
                new BroadcastModule("output", List.of())
        );
        Network network = new Network(modules);
        network.sendPulseAndPropagate(new PulsePackage(Pulse.LOW, "button", "broadcaster"));
        network.sendPulseAndPropagate(new PulsePackage(Pulse.LOW, "button", "broadcaster"));
        network.sendPulseAndPropagate(new PulsePackage(Pulse.LOW, "button", "broadcaster"));
        network.sendPulseAndPropagate(new PulsePackage(Pulse.LOW, "button", "broadcaster"));
        assertEquals(17, network.getLowPulsesReceived());
        assertEquals(11, network.getHighPulsesReceived());
    }

}