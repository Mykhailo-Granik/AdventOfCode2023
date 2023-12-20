package solutions.dec20;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BroadcastModuleTest {

    public static final String BROADCAST = "broadcast";
    public static final String DESTINATION = "destination";
    public static final String SOURCE = "source";

    @Test
    public void shouldBroadcastTheSamePulse() {
        BroadcastModule underTest = new BroadcastModule(BROADCAST, List.of(DESTINATION));
        underTest.receivePulse(new PulsePackage(Pulse.HIGH, SOURCE, BROADCAST));
        TestingNetwork network = new TestingNetwork();
        underTest.sendPulse(network);
        assertEquals(
                List.of(new PulsePackage(Pulse.HIGH, BROADCAST, DESTINATION)),
                network.getHistory()
        );
    }

    @Test
    public void shouldProcessMultipleSendRequests() {
        BroadcastModule underTest = new BroadcastModule(BROADCAST, List.of(DESTINATION));
        underTest.receivePulse(new PulsePackage(Pulse.LOW, SOURCE, BROADCAST));
        underTest.sendPulse(new TestingNetwork());
        TestingNetwork network = new TestingNetwork();
        underTest.sendPulse(network);
        assertTrue(network.getHistory().isEmpty());
    }

}