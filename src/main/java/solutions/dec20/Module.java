package solutions.dec20;

import java.util.ArrayList;
import java.util.List;

public abstract class Module {

    protected final String name;
    protected final List<String> destinations;
    protected final List<String> inputs;

    public Module(String name, List<String> destinations) {
        this.name = name;
        this.destinations = destinations;
        this.inputs = new ArrayList<>();
    }

    public abstract void sendPulse(Network network);

    public abstract void receivePulse(PulsePackage pulsePackage);

    public void addInput(String input) {
        inputs.add(input);
    }

    public String getName() {
        return name;
    }

    public List<String> getDestinations() {
        return destinations;
    }
}
