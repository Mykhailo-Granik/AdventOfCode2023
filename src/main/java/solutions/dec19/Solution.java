package solutions.dec19;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class Solution {


    public int calculateTheTotalScoreOfAcceptedParts(List<String> input) {
        int separatorIndex = input.indexOf("");
        WorkflowParser workflowParser = new WorkflowParser();
        Workflows workflows = new WorkflowsImpl(
                input.subList(0, separatorIndex).stream()
                        .map(workflowParser::parse)
                        .collect(toList())
        );
        PartParser partParser = new PartParser();
        List<Part> parts = input.subList(separatorIndex + 1, input.size()).stream()
                .map(partParser::parse)
                .collect(toList());
        Workflow startingWorkflow = workflows.workflowByName("in");
        List<Part> acceptedParts = parts.stream()
                .filter(part -> startingWorkflow.process(part, workflows) == PartStatus.ACCEPTED)
                .collect(toList());
        return new ScoreCalculator(acceptedParts).calculateTotalScore();
    }
}
