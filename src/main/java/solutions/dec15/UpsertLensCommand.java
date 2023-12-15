package solutions.dec15;

public class UpsertLensCommand implements BoxesCommand {
    private final String command;

    public UpsertLensCommand(String command) {
        this.command = command;
    }

    @Override
    public void apply(Boxes boxes) {
        String[] parts = command.split("=");
        String label = parts[0];
        int focalLength = Integer.parseInt(parts[1]);
        int boxIndex = new Hash(label).calculate();
        boxes.boxWithIndex(boxIndex).addLens(new Lens(label, focalLength));
    }
}
