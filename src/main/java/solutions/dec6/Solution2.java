package solutions.dec6;

import java.util.List;

public class Solution2 {

    public int calculateNumberOfWaysToWin(List<String> raceRecord) {
        return new WaysToWinTheRaceCounter(
                new RaceRecordIgnoringSpacesParser().parse(raceRecord.get(0), raceRecord.get(1))
        ).count();
    }

}
