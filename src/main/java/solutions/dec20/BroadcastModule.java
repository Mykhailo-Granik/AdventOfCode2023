package solutions.dec20;

import java.util.ArrayList;
import java.util.List;

public class BroadcastModule extends Module {

    private final List<PulsePackage> receivedPulses;

    public BroadcastModule(String name, List<String> destinations) {
        super(name, destinations);
        receivedPulses = new ArrayList<>();
    }


    @Override
    public void sendPulse(Network network) {
        for (PulsePackage pulsePackage : receivedPulses) {
            for (String destination : destinations) {
                network.sendPulse(new PulsePackage(pulsePackage.getPulse(), name, destination));
            }
        }
        receivedPulses.clear();
    }

    @Override
    public void receivePulse(PulsePackage pulsePackage) {
        receivedPulses.add(pulsePackage);
    }
}
