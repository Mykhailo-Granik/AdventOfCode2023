package solutions.dec20;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

public class Generator {

    private Set<BigInteger> generate(long value) {
        Set<BigInteger> numbers = new HashSet<>();
        BigInteger start = BigInteger.valueOf(value);
        for (int i = 1; i <= 10000000; ++i) {
            numbers.add(start.multiply(BigInteger.valueOf(i)).add(BigInteger.valueOf(i - 1)));
        }
        return numbers;
    }

    public BigInteger findIntersection() {
        Generator generator = new Generator();
        Set<BigInteger> numbers1 = generator.generate(3846);
        Set<BigInteger> numbers2 = generator.generate(3922);
        Set<BigInteger> numbers3 = generator.generate(4000);
        Set<BigInteger> numbers4 = generator.generate(4090);
        for (BigInteger number : numbers1) {
            if (numbers2.contains(number) && numbers3.contains(number) && numbers4.contains(number)) {
                return number;
            }
        }
        throw new RuntimeException("No intersection found");
    }

}
