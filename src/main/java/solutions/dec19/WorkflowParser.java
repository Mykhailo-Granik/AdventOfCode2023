package solutions.dec19;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WorkflowParser {

    public Workflow parse(String workflow) {
        int ruleStartIndex = workflow.indexOf('{');
        return new Workflow(
                parseName(workflow, ruleStartIndex),
                parseRules(workflow, ruleStartIndex)
        );
    }

    private String parseName(String workflow, int ruleStartIndex) {
        return workflow.substring(0, ruleStartIndex);
    }

    private List<Rule> parseRules(String workflow, int ruleStartIndex) {
        RuleParser ruleParser = new RuleParser();
        return Arrays.stream(
                        workflow.substring(ruleStartIndex + 1, workflow.length() - 1).split(","))
                .map(ruleParser::parse)
                .collect(Collectors.toList());
    }

}
