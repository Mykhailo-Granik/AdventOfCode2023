package solutions.dec6;

public class WaysToWinTheRaceCounter {

    private final RaceRecord raceRecord;

    public WaysToWinTheRaceCounter(RaceRecord raceRecord) {
        this.raceRecord = raceRecord;
    }

    public int count() {
        int res = 0;
        for (int waitingTime = 1; waitingTime < raceRecord.getTime(); ++waitingTime) {
            long speed = waitingTime;
            long timeLeft = raceRecord.getTime() - waitingTime;
            if (speed * timeLeft > raceRecord.getBestDistance()) {
                res++;
            }
        }
        return res;
    }
}
