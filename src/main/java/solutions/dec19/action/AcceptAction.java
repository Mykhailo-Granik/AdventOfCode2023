package solutions.dec19.action;

import solutions.dec19.Part;
import solutions.dec19.PartStatus;
import solutions.dec19.Workflows;
import solutions.dec19.range.ParametersRange;

import java.util.List;

public class AcceptAction implements Action {

    private static AcceptAction instance;

    private AcceptAction() {

    }

    public static AcceptAction getInstance() {
        if (instance == null) {
            instance = new AcceptAction();
        }
        return instance;
    }

    @Override
    public PartStatus apply(Part part, Workflows workflows) {
        return PartStatus.ACCEPTED;
    }

    @Override
    public List<ParametersRange> apply(ParametersRange parametersRange, Workflows workflows) {
        return List.of(parametersRange);
    }

}
