package solutions.dec14;

public class PlatformScoreCalculator {
    public int calculateScore(Platform platform) {
        int res = 0;
        for (int row = 0; row < platform.getGrid().size(); ++row) {
            for (int column = 0; column < platform.getGrid().get(row).length(); ++column) {
                if (platform.getGrid().get(row).charAt(column) == 'O') {
                    res += platform.getGrid().size() - row;
                }
            }
        }
        return res;
    }
}
