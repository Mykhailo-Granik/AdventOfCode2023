package solutions.dec20;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ConjunctionModuleTest {

    public static final String UNDER_TEST_NAME = "conjunction";
    public static final String DESTINATION_NAME = "destination";
    public static final String SOURCE_1 = "source1";
    public static final String SOURCE_2 = "source2";

    @Test
    public void whenAllInputsSendHighPulseShouldSendLowPulse() {
        TestingNetwork network = new TestingNetwork();
        ConjunctionModule underTest = new ConjunctionModule(UNDER_TEST_NAME, List.of(DESTINATION_NAME));
        underTest.addInput(SOURCE_1);
        underTest.addInput(SOURCE_2);
        underTest.receivePulse(new PulsePackage(Pulse.HIGH, SOURCE_1, UNDER_TEST_NAME));
        underTest.receivePulse(new PulsePackage(Pulse.HIGH, SOURCE_2, UNDER_TEST_NAME));
        underTest.sendPulse(network);
        assertEquals(
                List.of(
                        new PulsePackage(
                                Pulse.HIGH,
                                UNDER_TEST_NAME,
                                DESTINATION_NAME
                        ),
                        new PulsePackage(
                                Pulse.LOW,
                                UNDER_TEST_NAME,
                                DESTINATION_NAME
                        )
                ),
                network.getHistory()
        );
    }

    @Test
    public void shouldProcessMultipleSendRequests() {
        ConjunctionModule underTest = new ConjunctionModule(UNDER_TEST_NAME, List.of(DESTINATION_NAME));
        underTest.addInput(SOURCE_1);
        underTest.addInput(SOURCE_2);
        underTest.receivePulse(new PulsePackage(Pulse.LOW, SOURCE_1, UNDER_TEST_NAME));
        underTest.sendPulse(new TestingNetwork());
        TestingNetwork network = new TestingNetwork();
        underTest.sendPulse(network);
        assertTrue(network.getHistory().isEmpty());
    }

}