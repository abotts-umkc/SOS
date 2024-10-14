package sosGame449;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class JUnit_TestGameMode {

    @Test
    public void testSimpleGameModeSelected() {
        SOSGameView view = new SOSGameView();
        view.simpleGameOption.setSelected(true);

        assertTrue(view.isSimpleGameSelected(), "Simple game mode should be selected.");
        assertFalse(view.generalGameOption.isSelected(), "General game mode should not be selected.");
    }

    @Test
    public void testGeneralGameModeSelected() {
        SOSGameView view = new SOSGameView();
        view.generalGameOption.setSelected(true);

        assertTrue(view.generalGameOption.isSelected(), "General game mode should be selected.");
        assertFalse(view.isSimpleGameSelected(), "Simple game mode should not be selected.");
    }

    @Test
    public void testDefaultGameMode() {
        SOSGameView view = new SOSGameView();

        assertTrue(view.isSimpleGameSelected(), "Default game mode should be simple.");
        assertFalse(view.generalGameOption.isSelected(), "General game mode should not be selected by default.");
    }
}

