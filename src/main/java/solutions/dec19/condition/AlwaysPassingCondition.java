package solutions.dec19.condition;

import solutions.dec19.Part;
import solutions.dec19.range.ParametersRange;

public class AlwaysPassingCondition implements PartCondition {

    private static AlwaysPassingCondition instance;

    private AlwaysPassingCondition() {
    }

    public static AlwaysPassingCondition getInstance() {
        if (instance == null) {
            instance = new AlwaysPassingCondition();
        }
        return instance;
    }

    @Override
    public boolean test(Part part) {
        return true;
    }

    @Override
    public ParametersRange passingCondition(ParametersRange parametersRange) {
        return parametersRange;
    }

    @Override
    public ParametersRange failingCondition(ParametersRange parametersRange) {
        return ParametersRange.empty();
    }
}
