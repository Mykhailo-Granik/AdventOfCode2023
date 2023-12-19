package solutions.dec19;

import solutions.dec19.action.AcceptAction;
import solutions.dec19.action.Action;
import solutions.dec19.action.MoveToWorkflowAction;
import solutions.dec19.action.RejectAction;
import solutions.dec19.condition.AlwaysPassingCondition;
import solutions.dec19.condition.GreaterThanCondition;
import solutions.dec19.condition.LessThanCondition;
import solutions.dec19.condition.PartCondition;

public class RuleParser {

    public Rule parse(String rule) {
        if (rule.contains(":")) {
            return parseRuleWithCondition(rule);
        }
        return new Rule(
                AlwaysPassingCondition.getInstance(),
                parseAction(rule)
        );
    }

    private Rule parseRuleWithCondition(String rule) {
        String condition = rule.split(":")[0];
        String action = rule.split(":")[1];
        return new Rule(parseCondition(condition), parseAction(action));
    }

    private PartCondition parseCondition(String condition) {
        if (condition.contains("<")) {
            return new LessThanCondition(
                    condition.split("<")[0],
                    Integer.parseInt(condition.split("<")[1])
            );
        }
        if (condition.contains(">")) {
            return new GreaterThanCondition(
                    condition.split(">")[0],
                    Integer.parseInt(condition.split(">")[1])
            );
        }
        throw new IllegalArgumentException("Unknown condition: " + condition);
    }

    private Action parseAction(String action) {
        switch (action) {
            case "A":
                return AcceptAction.getInstance();
            case "R":
                return RejectAction.getInstance();
            default:
                return new MoveToWorkflowAction(action);
        }
    }
}
