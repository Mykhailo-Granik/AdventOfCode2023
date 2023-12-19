package solutions.dec19.action;

import solutions.dec19.Part;
import solutions.dec19.PartStatus;
import solutions.dec19.Workflows;
import solutions.dec19.range.ParametersRange;

import java.util.Collections;
import java.util.List;

public class RejectAction implements Action {

    private static RejectAction instance;

    private RejectAction() {

    }

    public static RejectAction getInstance() {
        if (instance == null) {
            instance = new RejectAction();
        }
        return instance;
    }

    @Override
    public PartStatus apply(Part part, Workflows workflows) {
        return PartStatus.REJECTED;
    }

    @Override
    public List<ParametersRange> apply(ParametersRange parametersRange, Workflows workflows) {
        return Collections.emptyList();
    }
}
