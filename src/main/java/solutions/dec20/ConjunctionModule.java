package solutions.dec20;

import java.util.*;

public class ConjunctionModule extends Module {

    private final Map<String, Pulse> inputPulses;
    private final List<PulsePackage> receivedPulses;

    public ConjunctionModule(String name, List<String> destinations) {
        super(name, destinations);
        inputPulses = new HashMap<>();
        receivedPulses = new ArrayList<>();
    }

    @Override
    public void sendPulse(Network network) {
        for (PulsePackage pulsePackage : receivedPulses) {
            sendPulse(network, pulsePackage);
        }
        receivedPulses.clear();
    }

    private void sendPulse(Network network, PulsePackage cause) {
        inputPulses.put(cause.getSource(), cause.getPulse());
        if (allInputsHaveHighPulse()) {
            broadcastPackage(network, Pulse.LOW);
        } else {
            if (Set.of("dh", "mk", "vf", "rn").contains(name)) {
                System.out.println(name + " sending HIGH during iteration " + Solution.ITERATION);
            }
            broadcastPackage(network, Pulse.HIGH);
        }
    }

    private boolean allInputsHaveHighPulse() {
        for (String input : inputs) {
            if (inputPulses.getOrDefault(input, Pulse.LOW) == Pulse.LOW) {
                return false;
            }
        }
        return true;
    }

    private void broadcastPackage(Network network, Pulse pulse) {
        for (String destination : destinations) {
            network.sendPulse(new PulsePackage(pulse, name, destination));
        }
    }

    @Override
    public void receivePulse(PulsePackage pulsePackage) {
        receivedPulses.add(pulsePackage);
    }
}
