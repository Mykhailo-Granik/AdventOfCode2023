package solutions.dec5;

import java.util.List;
import java.util.stream.Stream;

public interface SeedsParser {

    Stream<Long> seeds(String header, List<Map> maps);

}
