package solutions.dec19;

import solutions.dec19.range.ParameterRange;
import solutions.dec19.range.ParametersRange;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class SolutionPart2 {


    public long calculateTotalNumberOfPassingParts(List<String> input) {
        int separatorIndex = input.indexOf("");
        WorkflowParser workflowParser = new WorkflowParser();
        Workflows workflows = new WorkflowsImpl(
                input.subList(0, separatorIndex).stream()
                        .map(workflowParser::parse)
                        .collect(toList())
        );
        Workflow startingWorkflow = workflows.workflowByName("in");
        ParametersRange parametersRange = new ParametersRange(
                List.of(
                        new ParameterRange("x", 1, 4000),
                        new ParameterRange("m", 1, 4000),
                        new ParameterRange("a", 1, 4000),
                        new ParameterRange("s", 1, 4000)
                )
        );
        List<ParametersRange> ranges = startingWorkflow.process(parametersRange, workflows);
        return ranges.stream()
                .mapToLong(ParametersRange::numberOfItemsInRange)
                .sum();
    }
}
