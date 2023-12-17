package solutions.dec17;

public class UltraCrubiclesAllowedToStopPredicate implements AllowedToStopPredicate {
    @Override
    public boolean test(GraphNode graphNode) {
        return graphNode.getStepsTaken() >= 4;
    }
}
