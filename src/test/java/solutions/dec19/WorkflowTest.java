package solutions.dec19;

import org.junit.jupiter.api.Test;
import solutions.dec19.action.AcceptAction;
import solutions.dec19.action.RejectAction;
import solutions.dec19.condition.GreaterThanCondition;
import solutions.dec19.condition.LessThanCondition;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WorkflowTest {

    @Test
    public void shouldCorrectlyProcessPatIfFirstRuleWorks() {
        Workflow workflow = new Workflow(
                "ab",
                List.of(
                        new Rule(
                                new GreaterThanCondition("x", 0),
                                AcceptAction.getInstance()
                        ),
                        new Rule(
                                new LessThanCondition("x", 0),
                                RejectAction.getInstance()
                        )
                )
        );
        assertEquals(PartStatus.ACCEPTED, workflow.process(new Part(1, 2, 3, 4), null));
    }

    @Test
    public void shouldCorrectlyProcessPatIfSecondRuleWorks() {
        Workflow workflow = new Workflow(
                "ab",
                List.of(
                        new Rule(
                                new GreaterThanCondition("x", 0),
                                AcceptAction.getInstance()
                        ),
                        new Rule(
                                new LessThanCondition("x", 0),
                                RejectAction.getInstance()
                        )
                )
        );
        assertEquals(PartStatus.REJECTED, workflow.process(new Part(-1, 2, 3, 4), null));
    }

}