package solutions.dec20;

import java.util.ArrayList;
import java.util.List;

public class FlipFlopModule extends Module {

    private State state;
    private final List<PulsePackage> receivedPulses;

    public FlipFlopModule(String name, List<String> destinations) {
        super(name, destinations);
        receivedPulses = new ArrayList<>();
        this.state = State.OFF;
    }

    @Override
    public void sendPulse(Network network) {
        for (PulsePackage pulsePackage : receivedPulses) {
            sendPulse(network, pulsePackage);
        }
        receivedPulses.clear();
    }

    private void sendPulse(Network network, PulsePackage cause) {
        if (cause.getPulse() == Pulse.LOW) {
            for (String destination : destinations) {
                network.sendPulse(new PulsePackage(pulseValue(), name, destination));
            }
            state = state.switchState();
        }
    }

    private Pulse pulseValue() {
        if (state == State.OFF) {
            return Pulse.HIGH;
        }
        return Pulse.LOW;
    }

    @Override
    public void receivePulse(PulsePackage pulsePackage) {
        receivedPulses.add(pulsePackage);
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public enum State {
        ON {
            @Override
            public State switchState() {
                return OFF;
            }
        },
        OFF {
            @Override
            public State switchState() {
                return ON;
            }
        };

        public abstract State switchState();
    }
}
