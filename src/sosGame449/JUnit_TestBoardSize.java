package sosGame449;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class JUnit_TestBoardSize {

    @Test
    public void testValidBoardSize() {
        SOSGame game = new SOSGame(3);

        assertEquals(3, game.getBoardSize(), "Board size should be 3.");
    }

    @Test
    public void testInvalidBoardSize() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new SOSGame(2); 
        });
        assertEquals("Board size must be at least 3.", exception.getMessage());
    }

    @Test
    public void testLargerBoardSize() {
        SOSGame game = new SOSGame(10);

        assertEquals(10, game.getBoardSize(), "Board size should be 10.");
    }
}
