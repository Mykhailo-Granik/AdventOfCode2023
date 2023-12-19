package solutions.dec19;

import org.junit.jupiter.api.Test;
import solutions.dec19.action.AcceptAction;
import solutions.dec19.action.MoveToWorkflowAction;
import solutions.dec19.action.RejectAction;
import solutions.dec19.condition.AlwaysPassingCondition;
import solutions.dec19.condition.GreaterThanCondition;
import solutions.dec19.condition.LessThanCondition;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RuleParserTest {

    @Test
    public void shouldParseARuleWithLessThanConditionAndSendToAnotherWorkflowAction() {
        RuleParser underTest = new RuleParser();
        assertEquals(
                new Rule(
                        new LessThanCondition("a", 2006),
                        new MoveToWorkflowAction("qkq")
                ),
                underTest.parse("a<2006:qkq")
        );
    }

    @Test
    public void shouldParseARuleWithGreaterThanConditionAndSendToAnotherWorkflowAction() {
        RuleParser underTest = new RuleParser();
        assertEquals(
                new Rule(
                        new GreaterThanCondition("s", 2770),
                        new MoveToWorkflowAction("qs")
                ),
                underTest.parse("s>2770:qs")
        );
    }

    @Test
    public void shouldParseARuleWithAcceptAction() {
        RuleParser underTest = new RuleParser();
        assertEquals(
                new Rule(
                        new GreaterThanCondition("m", 2090),
                        AcceptAction.getInstance()
                ),
                underTest.parse("m>2090:A")
        );
    }

    @Test
    public void shouldParseARuleWithRejectAction() {
        RuleParser underTest = new RuleParser();
        assertEquals(
                new Rule(
                        new GreaterThanCondition("a", 1716),
                        RejectAction.getInstance()
                ),
                underTest.parse("a>1716:R")
        );
    }

    @Test
    public void shouldParseARuleWithoutCondition() {
        RuleParser underTest = new RuleParser();
        assertEquals(
                new Rule(
                        AlwaysPassingCondition.getInstance(),
                        new MoveToWorkflowAction("rfg")
                ),
                underTest.parse("rfg")
        );
    }

}