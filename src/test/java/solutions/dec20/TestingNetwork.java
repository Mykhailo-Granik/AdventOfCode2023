package solutions.dec20;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TestingNetwork extends Network {

    private final List<PulsePackage> history;

    public TestingNetwork() {
        super(List.of());
        this.history = new ArrayList<>();
    }

    public List<PulsePackage> getHistory() {
        return history;
    }

    @Override
    public void sendPulse(PulsePackage pulsePackage) {
        history.add(pulsePackage);
    }

    public static class SendPulseLog {
        private final Pulse pulse;
        private final String destination;

        public SendPulseLog(Pulse pulse, String destination) {
            this.pulse = pulse;
            this.destination = destination;
        }


        public Pulse getPulse() {
            return pulse;
        }

        public String getDestination() {
            return destination;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            SendPulseLog that = (SendPulseLog) o;
            return pulse == that.pulse && Objects.equals(destination, that.destination);
        }

        @Override
        public int hashCode() {
            return Objects.hash(pulse, destination);
        }
    }

}
