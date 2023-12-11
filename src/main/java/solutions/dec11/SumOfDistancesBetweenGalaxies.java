package solutions.dec11;

import java.util.List;

public class SumOfDistancesBetweenGalaxies {


    public long calculate(GalaxiesImage image) {
        List<Galaxy> galaxies = image.findGalaxiesConsideringExpansion();
        long res = 0;
        for (int i = 0; i < galaxies.size(); ++i) {
            for (int j = i + 1; j < galaxies.size(); ++j) {
                res += galaxies.get(i).distanceTo(galaxies.get(j));
            }
        }
        return res;
    }
}
