package solutions.dec15;

import java.util.List;

public class SolutionPart2 {


    public int calculateScore(List<String> initializationSequence) {
        Boxes boxes = new Boxes(256);
        BoxesCommandFactory boxesCommandFactory = new BoxesCommandFactory();
        new InputParser().parse(initializationSequence.get(0)).stream()
                .map(boxesCommandFactory::create)
                .forEach(boxesCommand -> boxesCommand.apply(boxes));
        return boxes.calculateTotalScore();
    }
}
