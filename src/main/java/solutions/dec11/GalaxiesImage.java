package solutions.dec11;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static java.util.stream.Collectors.toList;

public class GalaxiesImage {

    private final List<String> image;
    private final long expansionFactor;

    public GalaxiesImage(List<String> image, long expansionFactor) {
        this.image = image;
        this.expansionFactor = expansionFactor;
    }

    public GalaxiesImage expand() {
        List<String> expandedVerticallyImage = expandVertically();
        return new GalaxiesImage(expandHorizontally(expandedVerticallyImage), expansionFactor);
    }

    private List<String> expandVertically() {
        List<String> expandedImage = new ArrayList<>();
        for (String line : image) {
            expandedImage.add(line);
            if (!containsGalaxies(line)) {
                expandedImage.add(line);
            }
        }
        return expandedImage;
    }

    private boolean containsGalaxies(String line) {
        return line.contains("#");
    }

    private List<String> expandHorizontally(List<String> image) {
        List<StringBuilder> expandedImage = new ArrayList<>();
        for (int i = 0; i < image.size(); ++i) {
            expandedImage.add(new StringBuilder());
        }
        for (int column = 0; column < image.get(0).length(); ++column) {
            addColumn(image, expandedImage, column);
            if (!containsGalaxies(column, image)) {
                addColumn(image, expandedImage, column);
            }
        }
        return expandedImage.stream()
                .map(StringBuilder::toString)
                .collect(toList());
    }

    private void addColumn(List<String> source, List<StringBuilder> destination, int sourceColumn) {
        for (int row = 0; row < source.size(); ++row) {
            destination.get(row).append(source.get(row).charAt(sourceColumn));
        }
    }

    private boolean containsGalaxies(int column, List<String> image) {
        return image.stream()
                .map(line -> line.charAt(column))
                .anyMatch(character -> character == '#');
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GalaxiesImage galaxiesImage = (GalaxiesImage) o;
        return Objects.equals(image, galaxiesImage.image);
    }

    @Override
    public int hashCode() {
        return Objects.hash(image);
    }

    @Override
    public String toString() {
        return image.toString();
    }

    public List<Galaxy> findGalaxies() {
        List<Galaxy> galaxies = new ArrayList<>();
        for (int i = 0; i < image.size(); ++i) {
            for (int j = 0; j < image.get(i).length(); ++j) {
                if (image.get(i).charAt(j) == '#') {
                    galaxies.add(new Galaxy(i, j));
                }
            }
        }
        return galaxies;
    }

    public List<Galaxy> findGalaxiesConsideringExpansion() {
        List<Galaxy> galaxies = new ArrayList<>();
        int emptyRows = 0;
        for (int i = 0; i < image.size(); ++i) {
            if (!containsGalaxies(image.get(i))) {
                ++emptyRows;
                continue;
            }
            int emptyColumns = 0;
            for (int j = 0; j < image.get(i).length(); ++j) {
                if (!containsGalaxies(j, image)) {
                    ++emptyColumns;
                    continue;
                }
                if (image.get(i).charAt(j) == '#') {
                    galaxies.add(
                            new Galaxy(i + emptyRows * (expansionFactor - 1),
                                    j + emptyColumns * (expansionFactor - 1))
                    );
                }
            }
        }
        return galaxies;
    }
}
