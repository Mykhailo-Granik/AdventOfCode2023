package solutions.dec19;

import java.util.List;

public class WorkflowsImpl implements Workflows {

    private final List<Workflow> workflows;

    public WorkflowsImpl(List<Workflow> workflows) {
        this.workflows = workflows;
    }

    @Override
    public Workflow workflowByName(String name) {
        return workflows.stream()
                .filter(workflow -> workflow.getName().equals(name))
                .findFirst()
                .orElseThrow();
    }

}
