package solutions.dec19;

import org.junit.jupiter.api.Test;
import solutions.dec19.action.AcceptAction;
import solutions.dec19.action.MoveToWorkflowAction;
import solutions.dec19.condition.AlwaysPassingCondition;
import solutions.dec19.condition.GreaterThanCondition;
import solutions.dec19.condition.LessThanCondition;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WorkflowParserTest {

    @Test
    public void shouldParseAWorkflow() {
        WorkflowParser underTest = new WorkflowParser();
        Workflow expected = new Workflow(
                "px",
                List.of(
                        new Rule(
                                new LessThanCondition("a", 2006),
                                new MoveToWorkflowAction("qkq")
                        ),
                        new Rule(
                                new GreaterThanCondition("m", 2090),
                                AcceptAction.getInstance()
                        ),
                        new Rule(
                                AlwaysPassingCondition.getInstance(),
                                new MoveToWorkflowAction("rfg")
                        )
                )
        );
        assertEquals(expected, underTest.parse("px{a<2006:qkq,m>2090:A,rfg}"));
    }

}