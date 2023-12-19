package solutions.dec19.action;

import org.junit.jupiter.api.Test;
import solutions.dec19.Part;
import solutions.dec19.PartStatus;
import solutions.dec19.Workflows;
import solutions.dec19.WorkflowsImpl;
import solutions.dec19.range.ParametersRange;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AcceptActionTest {

    @Test
    public void shouldAlwaysAcceptPart() {
        AcceptAction underTest = AcceptAction.getInstance();
        Part part = new Part(1, 2, 3, 4);
        Workflows workflows = new WorkflowsImpl(null);
        assertEquals(PartStatus.ACCEPTED, underTest.apply(part, workflows));
    }

    @Test
    public void shouldReturnGivenParametersRange() {
        AcceptAction underTest = AcceptAction.getInstance();
        ParametersRange parametersRange = new ParametersRange(
                null
        );
        assertEquals(List.of(parametersRange), underTest.apply(parametersRange, null));
    }

}