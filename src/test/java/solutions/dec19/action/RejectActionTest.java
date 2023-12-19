package solutions.dec19.action;

import org.junit.jupiter.api.Test;
import solutions.dec19.Part;
import solutions.dec19.PartStatus;
import solutions.dec19.Workflows;
import solutions.dec19.WorkflowsImpl;
import solutions.dec19.range.ParametersRange;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RejectActionTest {

    @Test
    public void shouldAlwaysRejectPart() {
        RejectAction underTest = RejectAction.getInstance();
        Part part = new Part(1, 2, 3, 4);
        Workflows workflows = new WorkflowsImpl(null);
        assertEquals(PartStatus.REJECTED, underTest.apply(part, workflows));
    }

    @Test
    public void shouldReturnEmptyListWhenProcessingParametersRange() {
        RejectAction underTest = RejectAction.getInstance();
        ParametersRange parametersRange = new ParametersRange(
                null
        );
        assertEquals(0, underTest.apply(parametersRange, null).size());
    }

}