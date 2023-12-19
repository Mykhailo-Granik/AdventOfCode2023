package solutions.dec19.action;

import solutions.dec19.Part;
import solutions.dec19.PartStatus;
import solutions.dec19.Workflows;
import solutions.dec19.range.ParametersRange;

import java.util.List;
import java.util.Objects;

public class MoveToWorkflowAction implements Action {

    private final String workflowName;

    public MoveToWorkflowAction(String workflowName) {
        this.workflowName = workflowName;
    }

    @Override
    public PartStatus apply(Part part, Workflows workflows) {
        return workflows.workflowByName(workflowName).process(part, workflows);
    }

    @Override
    public List<ParametersRange> apply(ParametersRange parametersRange, Workflows workflows) {
        return workflows.workflowByName(workflowName).process(parametersRange, workflows);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MoveToWorkflowAction that = (MoveToWorkflowAction) o;
        return Objects.equals(workflowName, that.workflowName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(workflowName);
    }

    @Override
    public String toString() {
        return "MoveToWorkflowAction{" +
                "workflowName='" + workflowName + '\'' +
                '}';
    }
}
