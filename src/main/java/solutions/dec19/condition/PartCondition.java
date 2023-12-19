package solutions.dec19.condition;

import solutions.dec19.Part;
import solutions.dec19.range.ParametersRange;

import java.util.function.Predicate;

public interface PartCondition extends Predicate<Part> {

    ParametersRange passingCondition(ParametersRange parametersRange);

    ParametersRange failingCondition(ParametersRange parametersRange);

}
