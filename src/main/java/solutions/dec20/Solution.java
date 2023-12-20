package solutions.dec20;

import java.util.List;
import java.util.stream.Collectors;

public class Solution {

    public static int ITERATION = 0;

    public long calculateProductOfSignalOccurrences(List<String> input) {
        ModuleParser parser = new ModuleParser();
        List<Module> modules = input.stream().map(parser::parse).collect(Collectors.toList());
        Network network = new Network(modules);
        for (int i = 0; i < 1000; ++i) {
            ITERATION = i;
            network.sendPulseAndPropagate(
                    new PulsePackage(Pulse.LOW, "button", "broadcaster")
            );
        }
        return network.getHighPulsesReceived() * network.getLowPulsesReceived();
    }

}
