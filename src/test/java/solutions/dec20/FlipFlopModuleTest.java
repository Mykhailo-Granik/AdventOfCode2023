package solutions.dec20;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FlipFlopModuleTest {

    public static final String UNDER_TEST_NAME = "source";
    public static final String OTHER_MODULE_NAME = "destination";

    @Test
    public void whenFlipFlopModuleReceivesHighPulseNothingShouldHappen() {
        TestingNetwork network = new TestingNetwork();
        FlipFlopModule underTest = new FlipFlopModule(UNDER_TEST_NAME, List.of(OTHER_MODULE_NAME));
        underTest.receivePulse(new PulsePackage(Pulse.HIGH, UNDER_TEST_NAME, OTHER_MODULE_NAME));
        underTest.sendPulse(network);
        assertTrue(network.getHistory().isEmpty());
        assertEquals(FlipFlopModule.State.OFF, underTest.getState());
    }

    @Test
    public void whenFlipFlopModuleReceivesLowPulseAndItWasOffShouldTurnOnAndSendHighPulse() {
        TestingNetwork network = new TestingNetwork();
        FlipFlopModule underTest = new FlipFlopModule(UNDER_TEST_NAME, List.of(OTHER_MODULE_NAME));
        underTest.receivePulse(new PulsePackage(Pulse.LOW, UNDER_TEST_NAME, OTHER_MODULE_NAME));
        underTest.sendPulse(network);
        assertEquals(
                List.of(
                        new PulsePackage(
                                Pulse.HIGH,
                                UNDER_TEST_NAME,
                                OTHER_MODULE_NAME
                        )
                ),
                network.getHistory()
        );
        assertEquals(FlipFlopModule.State.ON, underTest.getState());
    }

    @Test
    public void whenFlipFlopModuleReceivesLowPulseAndItWasOnShouldTurnOffAndSendLowPulse() {
        TestingNetwork network = new TestingNetwork();
        FlipFlopModule underTest = new FlipFlopModule(UNDER_TEST_NAME, List.of(OTHER_MODULE_NAME));
        underTest.setState(FlipFlopModule.State.ON);
        underTest.receivePulse(new PulsePackage(Pulse.LOW, UNDER_TEST_NAME, OTHER_MODULE_NAME));
        underTest.sendPulse(network);
        assertEquals(
                List.of(
                        new PulsePackage(
                                Pulse.LOW,
                                UNDER_TEST_NAME,
                                OTHER_MODULE_NAME
                        )
                ),
                network.getHistory()
        );
        assertEquals(FlipFlopModule.State.OFF, underTest.getState());
    }

    @Test
    public void shouldProcessMultipleSendRequests() {
        FlipFlopModule underTest = new FlipFlopModule(UNDER_TEST_NAME, List.of(OTHER_MODULE_NAME));
        underTest.receivePulse(new PulsePackage(Pulse.LOW, UNDER_TEST_NAME, OTHER_MODULE_NAME));
        underTest.sendPulse(new TestingNetwork());
        TestingNetwork network = new TestingNetwork();
        underTest.sendPulse(network);
        assertTrue(network.getHistory().isEmpty());
    }

}