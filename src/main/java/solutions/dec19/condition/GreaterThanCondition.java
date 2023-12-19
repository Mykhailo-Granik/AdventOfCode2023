package solutions.dec19.condition;

import solutions.dec19.Part;
import solutions.dec19.range.ParameterRange;
import solutions.dec19.range.ParametersRange;

import java.util.Objects;

public class GreaterThanCondition implements PartCondition {
    private final String parameterName;
    private final int value;

    public GreaterThanCondition(String parameterName, int value) {
        this.parameterName = parameterName;
        this.value = value;
    }

    @Override
    public boolean test(Part part) {
        return part.getParameter(parameterName) > value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GreaterThanCondition that = (GreaterThanCondition) o;
        return value == that.value && Objects.equals(parameterName, that.parameterName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(parameterName, value);
    }

    @Override
    public ParametersRange passingCondition(ParametersRange parametersRange) {
        ParameterRange parameterRange =
                parametersRange.findParameterRangeByName(parameterName).withFrom(value + 1);
        return parametersRange.updateRangeForParameter(parameterRange);
    }

    @Override
    public ParametersRange failingCondition(ParametersRange parametersRange) {
        ParameterRange parameterRange =
                parametersRange.findParameterRangeByName(parameterName).withTo(value);
        return parametersRange.updateRangeForParameter(parameterRange);
    }
}
