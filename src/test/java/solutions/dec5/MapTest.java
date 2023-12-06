package solutions.dec5;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MapTest {

    @Test
    public void rangeShouldReportTheValueIsOutsideIfItIsLowerThanSourceStart() {
        Map.MappingRange mappingRange = new Map.MappingRange(10, 20, 5);
        assertFalse(mappingRange.isInMappingRange(19));
    }

    @Test
    public void rangeShouldReportTheValueIsOutsideIfItIsHigherThanSourceEnd() {
        Map.MappingRange mappingRange = new Map.MappingRange(10, 20, 5);
        assertFalse(mappingRange.isInMappingRange(25));
    }

    @Test
    public void rangeShouldReportTheValueIsInsideIfItIsBetweenSourceStartAndEnd() {
        Map.MappingRange mappingRange = new Map.MappingRange(10, 20, 5);
        assertTrue(mappingRange.isInMappingRange(20));
        assertTrue(mappingRange.isInMappingRange(24));
    }

    @Test
    public void mappingInsideRangeShouldThrowRuntimeExceptionIfValueDoesNotBelongToRange() {
        Map.MappingRange mappingRange = new Map.MappingRange(10, 20, 5);
        assertThrows(IllegalArgumentException.class, () -> mappingRange.mapToDestination(19));
    }

    @Test
    public void mappingInsideRangeShouldReturnAppropriateDestinationValue() {
        Map.MappingRange mappingRange = new Map.MappingRange(10, 20, 5);
        assertEquals(14, mappingRange.mapToDestination(24));
    }
    @Test
    public void shouldReturnIdentityMappingIfRangesAreEmpty() {
        Map map = new Map("A", "B", List.of());
        assertEquals(3, map.get(3));
    }

    @Test
    public void shouldReturnIdentityMappingIfValueDoesNotBelongToARange() {
        Map map = new Map("A", "B", List.of(new Map.MappingRange(10, 20, 5)));
        assertEquals(3, map.get(3));
    }

    @Test
    public void shouldReturnAppropriateDestinationValueIfValueBelongsToARange() {
        Map map = new Map("A", "B", List.of(new Map.MappingRange(10, 20, 5)));
        assertEquals(14, map.get(24));
    }

}