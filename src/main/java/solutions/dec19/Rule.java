package solutions.dec19;

import solutions.dec19.action.Action;
import solutions.dec19.condition.PartCondition;

import java.util.Objects;

public class Rule {

    private final PartCondition condition;
    private final Action action;

    public Rule(PartCondition condition, Action action) {
        this.condition = condition;
        this.action = action;
    }

    public PartCondition getCondition() {
        return condition;
    }

    public Action getAction() {
        return action;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rule rule = (Rule) o;
        return Objects.equals(condition, rule.condition) && Objects.equals(action, rule.action);
    }

    @Override
    public int hashCode() {
        return Objects.hash(condition, action);
    }

    @Override
    public String toString() {
        return "Rule{" +
                "condition=" + condition +
                ", action=" + action +
                '}';
    }
}
