package solutions.dec5;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class SimpleSeedsParser implements SeedsParser {

    @Override
    public Stream<Long> seeds(String header, List<Map> maps) {
        return Arrays.stream(header.split(" "))
                .skip(1)
                .mapToLong(Long::parseLong)
                .boxed();
    }

}
