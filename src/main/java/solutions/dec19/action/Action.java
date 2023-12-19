package solutions.dec19.action;

import solutions.dec19.Part;
import solutions.dec19.PartStatus;
import solutions.dec19.Workflows;
import solutions.dec19.range.ParametersRange;

import java.util.List;

public interface Action {

    PartStatus apply(Part part, Workflows workflows);

    List<ParametersRange> apply(ParametersRange parametersRange, Workflows workflows);

}
