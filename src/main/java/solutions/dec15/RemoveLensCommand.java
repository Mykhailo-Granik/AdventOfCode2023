package solutions.dec15;

public class RemoveLensCommand implements BoxesCommand {

    private final String command;

    public RemoveLensCommand(String command) {
        this.command = command;
    }

    @Override
    public void apply(Boxes boxes) {
        String label = command.substring(0, command.length() - 1);
        int boxIndex = new Hash(label).calculate();
        boxes.boxWithIndex(boxIndex).removeLensWithLabel(label);
    }
}
