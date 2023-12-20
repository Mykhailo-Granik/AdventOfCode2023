package solutions.dec20;

import java.util.*;

public class Network {

    private final List<Module> modules;
    private final List<Module> unknownModules;
    private long lowPulsesReceived;
    private long highPulsesReceived;
    private final Queue<Module> modulesToProcess;

    public Network(List<Module> modules) {
        this.modules = modules;
        unknownModules = new ArrayList<>();
        for (Module module : modules) {
            for (String destination : module.destinations) {
                moduleByName(destination).addInput(module.getName());
            }
        }
        modules.addAll(unknownModules);
        modulesToProcess = new LinkedList<>();
    }

    private Module moduleByName(String name) {
        Optional<Module> foundModule = modules.stream()
                .filter(module -> module.getName().equals(name))
                .findFirst();
        if (foundModule.isPresent()) {
            return foundModule.get();
        }
        Module newModule = new BroadcastModule(name, List.of());
        unknownModules.add(newModule);
        return newModule;
    }

    public void sendPulse(PulsePackage pulsePackage) {
        Module destination = moduleByName(pulsePackage.getDestination());
        modulesToProcess.add(destination);
        destination.receivePulse(pulsePackage);
        if (pulsePackage.getPulse() == Pulse.LOW) {
            lowPulsesReceived++;
        } else {
            highPulsesReceived++;
        }
    }

    private void processModules() {
        while (!modulesToProcess.isEmpty()) {
            Module module = modulesToProcess.poll();
            module.sendPulse(this);
        }
    }

    public void sendPulseAndPropagate(PulsePackage pulsePackage) {
        sendPulse(pulsePackage);
        processModules();
    }

    public long getLowPulsesReceived() {
        return lowPulsesReceived;
    }

    public long getHighPulsesReceived() {
        return highPulsesReceived;
    }
}
