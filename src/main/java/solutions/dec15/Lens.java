package solutions.dec15;

public class Lens {

    private final String label;
    private final int focalLength;

    public Lens(String label, int focalLength) {
        this.label = label;
        this.focalLength = focalLength;
    }

    public int getFocalLength() {
        return focalLength;
    }

    public String getLabel() {
        return label;
    }
}
