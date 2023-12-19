package solutions.dec19;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WorkflowsImplTest {

    @Test
    public void shouldFindWorkFlowByName() {
        Workflow workflowToFind = new Workflow("workflow2", null);
        List<Workflow> workflows = List.of(
                new Workflow("workflow1", null),
                workflowToFind,
                new Workflow("workflow3", null)
        );
        assertEquals(workflowToFind, new WorkflowsImpl(workflows).workflowByName("workflow2"));
    }

}