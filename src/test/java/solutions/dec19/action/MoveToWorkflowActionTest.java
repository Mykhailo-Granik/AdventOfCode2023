package solutions.dec19.action;

import org.junit.jupiter.api.Test;
import solutions.dec19.Part;
import solutions.dec19.PartStatus;
import solutions.dec19.Workflow;
import solutions.dec19.Workflows;
import solutions.dec19.range.ParameterRange;
import solutions.dec19.range.ParametersRange;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MoveToWorkflowActionTest {

    public static final String NAME = "name";

    @Test
    public void shouldReturnAcceptedWhenWorkflowSaysSo() {
        MoveToWorkflowAction underTest = new MoveToWorkflowAction(NAME);
        Part part = new Part(1, 2, 3, 4);
        Workflows workflows = new TestingWorkflows(new TestingWorkflow(PartStatus.ACCEPTED, null));
        assertEquals(PartStatus.ACCEPTED, underTest.apply(part, workflows));
    }

    @Test
    public void shouldReturnRejectedWhenWorkflowSaysSo() {
        MoveToWorkflowAction underTest = new MoveToWorkflowAction(NAME);
        Part part = new Part(1, 2, 3, 4);
        Workflows workflows = new TestingWorkflows(new TestingWorkflow(PartStatus.REJECTED, null));
        assertEquals(PartStatus.REJECTED, underTest.apply(part, workflows));
    }

    @Test
    public void shouldReturnParametersRangesFromLinkedWorkflow() {
        MoveToWorkflowAction underTest = new MoveToWorkflowAction(NAME);
        ParametersRange parametersRange = new ParametersRange(
                List.of(
                        new ParameterRange("a", 1, 2),
                        new ParameterRange("b", 3, 4)
                )
        );
        Workflows workflows = new TestingWorkflows(new TestingWorkflow(null, List.of(parametersRange)));
        assertEquals(List.of(parametersRange), underTest.apply(parametersRange, workflows));
    }

    private static class TestingWorkflows implements Workflows {

        private final Workflow workflow;

        public TestingWorkflows(Workflow workflow) {
            this.workflow = workflow;
        }

        @Override
        public Workflow workflowByName(String name) {
            return workflow;
        }
    }

    private static class TestingWorkflow extends Workflow {

        private final PartStatus result;
        private final List<ParametersRange> parametersRanges;

        public TestingWorkflow(PartStatus result, List<ParametersRange> parametersRanges) {
            super(null, null);
            this.result = result;
            this.parametersRanges = parametersRanges;
        }

        @Override
        public PartStatus process(Part part, Workflows workflows) {
            return result;
        }

        @Override
        public List<ParametersRange> process(ParametersRange parametersRange, Workflows workflows) {
            return parametersRanges;
        }
    }

}