package solutions.dec10;

import java.util.Map;

import static solutions.dec10.Pipe.*;

public class PipeFactory {

    private static final Map<Character, Pipe> pipeByCharacter = Map.of(
            '|', VERTICAL,
            '-', HORIZONTAL,
            'L', BEND_DOWN_RIGHT,
            'J', BEND_DOWN_LEFT,
            '7', BEND_UP_LEFT,
            'F', BEND_UP_RIGHT,
            '.', GROUND
    );

    public static Pipe createPipe(char pipe) {
        if (pipeByCharacter.containsKey(pipe)) {
            return pipeByCharacter.get(pipe);
        }
        throw new IllegalArgumentException("Unknown pipe: " + pipe);
    }

    public static Character charForPipe(Pipe pipe) {
        return pipeByCharacter.entrySet().stream()
                .filter(entry -> entry.getValue() == pipe)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElseThrow();
    }
}
