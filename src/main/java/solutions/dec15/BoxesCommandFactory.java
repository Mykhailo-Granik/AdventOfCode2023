package solutions.dec15;

public class BoxesCommandFactory {

    public BoxesCommand create(String command) {
        if (command.endsWith("-")) {
            return new RemoveLensCommand(command);
        }
        if (command.contains("=")) {
            return new UpsertLensCommand(command);
        }
        throw new IllegalArgumentException("Unknown command: " + command);
    }
}
