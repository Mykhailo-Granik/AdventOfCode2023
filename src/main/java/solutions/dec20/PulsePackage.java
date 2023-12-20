package solutions.dec20;

import java.util.Objects;

public class PulsePackage {

    private final Pulse pulse;
    private final String source;
    private final String destination;

    public PulsePackage(Pulse pulse, String source, String destination) {
        this.pulse = pulse;
        this.source = source;
        this.destination = destination;
    }

    public Pulse getPulse() {
        return pulse;
    }

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PulsePackage that = (PulsePackage) o;
        return pulse == that.pulse && Objects.equals(source, that.source) && Objects.equals(destination, that.destination);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pulse, source, destination);
    }

    @Override
    public String toString() {
        return "PulsePackage{" +
                "pulse=" + pulse +
                ", source='" + source + '\'' +
                ", destination='" + destination + '\'' +
                '}';
    }
}
