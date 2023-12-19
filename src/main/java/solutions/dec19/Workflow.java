package solutions.dec19;

import solutions.dec19.range.ParametersRange;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Workflow {

    private final String name;
    private final List<Rule> rules;

    public Workflow(String name, List<Rule> rules) {
        this.name = name;
        this.rules = rules;
    }

    public PartStatus process(Part part, Workflows workflows) {
        return rules.stream()
                .filter(rule -> rule.getCondition().test(part))
                .findFirst()
                .map(rule -> rule.getAction().apply(part, workflows))
                .orElseThrow();
    }

    public List<ParametersRange> process(ParametersRange parametersRange, Workflows workflows) {
        List<ParametersRange> result = new ArrayList<>();
        for (Rule rule : rules) {
            ParametersRange passingParameters = rule.getCondition().passingCondition(parametersRange);
            result.addAll(rule.getAction().apply(passingParameters, workflows));
            parametersRange = rule.getCondition().failingCondition(parametersRange);
        }
        return result;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Workflow workflow = (Workflow) o;
        return Objects.equals(name, workflow.name) && Objects.equals(rules, workflow.rules);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, rules);
    }

    @Override
    public String toString() {
        return "Workflow{" +
                "name='" + name + '\'' +
                ", rules=" + rules +
                '}';
    }
}
