package solutions.dec15;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BoxesCommandFactoryTest {

    @Test
    public void shouldCreateRemoveCommand() {
        BoxesCommandFactory underTest = new BoxesCommandFactory();
        assertTrue(underTest.create("pq-") instanceof RemoveLensCommand);
    }

    @Test
    public void shouldCreateUpsertCommand() {
        BoxesCommandFactory underTest = new BoxesCommandFactory();
        assertTrue(underTest.create("pq=3") instanceof UpsertLensCommand);
    }

    @Test
    public void shouldThrowExceptionForUnknownCommand() {
        BoxesCommandFactory underTest = new BoxesCommandFactory();
        assertThrows(IllegalArgumentException.class, () -> underTest.create("pq"));
    }

}