package solutions.dec24;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class StoneLauncher {

    public static final double EPSILON = 0.00001;
    public static final int LIMIT = 10000;
    public static final int SCALE = 15;
    private final List<Hailstone> hailstones;

    public StoneLauncher(List<Hailstone> hailstones) {
        this.hailstones = hailstones;
    }

    public long findSumOfInitialStoneCoordinates() {
        for (int deltaX = -LIMIT; deltaX <= LIMIT; ++deltaX) {
            System.out.println(deltaX);
            for (int deltaY = -LIMIT; deltaY <= LIMIT; ++deltaY) {
                long sum = findSumOfInitialStoneCoordinates(deltaX, deltaY);
                if (sum == Long.MAX_VALUE) {
                    continue;
                }
                return sum;
            }
        }
        throw new IllegalStateException("No solution found");
    }

    private long findSumOfInitialStoneCoordinates(int dx, int dy) {
        Random random = new Random();
        int randomIndex1 = random.nextInt(hailstones.size());
        Hailstone hailstone1 = hailstones.get(randomIndex1);
        int randomIndex2 = random.nextInt(hailstones.size());
        while (randomIndex2 == randomIndex1) {
            randomIndex2 = random.nextInt(hailstones.size());
        }
        Hailstone hailstone2 = hailstones.get(randomIndex2);
        BigDecimal m = BigDecimal.valueOf(dx - hailstone1.getxChange().getDelta());
        BigDecimal n = BigDecimal.valueOf(dy - hailstone1.getyChange().getDelta());
        BigDecimal o = BigDecimal.valueOf(dx - hailstone2.getxChange().getDelta());
        BigDecimal p = BigDecimal.valueOf(dy - hailstone2.getyChange().getDelta());
        BigDecimal q = BigDecimal.valueOf(hailstone1.getxChange().getStart());
        BigDecimal r = BigDecimal.valueOf(hailstone1.getyChange().getStart());
        BigDecimal s = BigDecimal.valueOf(hailstone2.getxChange().getStart());
        BigDecimal t = BigDecimal.valueOf(hailstone2.getyChange().getStart());
        BigDecimal denominator = n.multiply(o).subtract(m.multiply(p));
        if (denominator.abs().compareTo(BigDecimal.valueOf(EPSILON)) < 0) {
            return findSumOfInitialStoneCoordinates(dx, dy);
        }
        BigDecimal x = m.multiply(o).multiply(r).negate().add(m.multiply(o).multiply(t)).subtract(m.multiply(p).multiply(s)).add(n.multiply(o).multiply(q))
                .divide(denominator, SCALE, RoundingMode.HALF_UP);


        BigDecimal y = m.multiply(p).multiply(r).negate().add(n.multiply(o).multiply(t)).add(n.multiply(p).multiply(q)).subtract(n.multiply(p).multiply(s))
                .divide(denominator, SCALE, RoundingMode.HALF_UP);

        BigDecimal t1 = o.multiply(r).subtract(o.multiply(t)).subtract(p.multiply(q)).add(p.multiply(s))
                .divide(denominator, SCALE, RoundingMode.HALF_UP);

        BigDecimal t2 = m.multiply(r).subtract(m.multiply(t)).subtract(n.multiply(q)).add(n.multiply(s))
                .divide(denominator, SCALE, RoundingMode.HALF_UP);

        if (t1.compareTo(BigDecimal.valueOf(-EPSILON)) < 0 || t2.compareTo(BigDecimal.valueOf(-EPSILON)) < 0) {
            return Long.MAX_VALUE;
        }

        // Check if x or y is not close to an integer within EPSILON
        if (x.subtract(BigDecimal.valueOf(Math.round(x.doubleValue()))).abs().doubleValue() > EPSILON
                || y.subtract(BigDecimal.valueOf(Math.round(y.doubleValue()))).abs().doubleValue() > EPSILON) {
            return Long.MAX_VALUE;
        }

        // Calculate dz using BigDecimal
        BigDecimal dzNumerator = BigDecimal.valueOf(hailstone2.getzChange().getStart())
                .add(t2.multiply(BigDecimal.valueOf(hailstone2.getzChange().getDelta())))
                .subtract(BigDecimal.valueOf(hailstone1.getzChange().getStart())
                        .add(t1.multiply(BigDecimal.valueOf(hailstone1.getzChange().getDelta()))));
        BigDecimal dzDenominator = t2.subtract(t1);
        BigDecimal dz = dzNumerator.divide(dzDenominator, RoundingMode.HALF_UP);

        // Check if dz is not close to an integer within EPSILON
        if (dz.subtract(BigDecimal.valueOf(Math.round(dz.doubleValue()))).abs().doubleValue() > EPSILON) {
            return Long.MAX_VALUE;
        }

        // Calculate z using BigDecimal
        BigDecimal z = BigDecimal.valueOf(hailstone1.getzChange().getStart())
                .add(t1.multiply(BigDecimal.valueOf(hailstone1.getzChange().getDelta())))
                .subtract(dz.multiply(t1));

        // Check if z is not close to an integer within EPSILON
        if (z.subtract(BigDecimal.valueOf(Math.round(z.doubleValue()))).abs().doubleValue() > EPSILON) {
            return Long.MAX_VALUE;
        }

//        System.out.println("deltaX = " + dx + ", deltaY = " + dy + ", deltaZ = " + dz + ", x = " + x + ", y = " + y + ", z = " + z);
        for (Hailstone hailstone : hailstones) {
            BigDecimal txNumerator = x.subtract(BigDecimal.valueOf(hailstone.getxChange().getStart()));
            BigDecimal txDenominator = BigDecimal.valueOf(hailstone.getxChange().getDelta()).subtract(BigDecimal.valueOf(dx));
            boolean checkTx = true;
            if (txDenominator.compareTo(BigDecimal.ZERO) == 0) {
                if (txNumerator.compareTo(BigDecimal.ZERO) != 0) {
                    return Long.MAX_VALUE;
                }
                checkTx = false;
            }
            BigDecimal tx = null;
            if (checkTx) {
                tx = txNumerator.divide(txDenominator, RoundingMode.HALF_UP);
            }

            boolean checkTy = true;
            BigDecimal tyNumerator = y.subtract(BigDecimal.valueOf(hailstone.getyChange().getStart()));
            BigDecimal tyDenominator = BigDecimal.valueOf(hailstone.getyChange().getDelta()).subtract(BigDecimal.valueOf(dy));
            if (tyDenominator.compareTo(BigDecimal.ZERO) == 0) {
                if (tyNumerator.compareTo(BigDecimal.ZERO) != 0) {
                    return Long.MAX_VALUE;
                }
                checkTy = false;
            }
            BigDecimal ty = null;
            if (checkTy) {
                ty = tyNumerator.divide(tyDenominator, RoundingMode.HALF_UP);
            }

            BigDecimal tzNumerator = z.subtract(BigDecimal.valueOf(hailstone.getzChange().getStart()));
            BigDecimal tzDenominator = BigDecimal.valueOf(hailstone.getzChange().getDelta()).subtract(dz);
            boolean checkTz = true;
            if (tzDenominator.compareTo(BigDecimal.ZERO) == 0) {
                if (tzNumerator.compareTo(BigDecimal.ZERO) != 0) {
                    return Long.MAX_VALUE;
                }
                checkTz = false;
            }
            BigDecimal tz = null;
            if (checkTz) {
                tz = tzNumerator.divide(tzDenominator, RoundingMode.HALF_UP);
            }
            List<BigDecimal> tList = new ArrayList<>();
            tList.add(tx);
            tList.add(ty);
            tList.add(tz);
            tList.removeIf(Objects::isNull);
            for (int i = 0; i < tList.size(); i++) {
                BigDecimal tx1 = tList.get(i);
                if (t.compareTo(BigDecimal.valueOf(-EPSILON)) < 0) {
                    return Long.MAX_VALUE;
                }
                for (int j = i + 1; j < tList.size(); j++) {
                    BigDecimal tx2 = tList.get(j);
                    if (tx1.subtract(tx2).abs().doubleValue() > EPSILON) {
                        return Long.MAX_VALUE;
                    }
                }
            }
        }
        System.out.println("deltaX = " + dx + ", deltaY = " + dy + ", deltaZ = " + dz + ", x = " + x + ", y = " + y + ", z = " + z);
        return x.longValue() + y.longValue() + z.longValue();
    }
}
