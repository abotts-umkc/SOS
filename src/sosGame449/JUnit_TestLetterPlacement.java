package sosGame449;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class JUnit_TestLetterPlacement {

    @Test
    public void testPlaceLetter() {
        SOSGame game = new SOSGame(3); 

        boolean placedFirst = game.placeLetter(0, 0, 'S');
        assertTrue(placedFirst, "First placement should be successful.");

        boolean placedAgain = game.placeLetter(0, 0, 'O');
        assertFalse(placedAgain, "Second placement on the same cell should fail.");

        boolean placedAnother = game.placeLetter(1, 1, 'O');
        assertTrue(placedAnother, "Placing 'O' in an empty cell should be successful.");
    }

    @Test
    public void testIsPlayerOneTurn() {
        SOSGame game = new SOSGame(3);

        assertFalse(game.isPlayerOneTurn(), "Initially, it should be Player One's turn.");

        game.placeLetter(0, 0, 'S'); 
        assertTrue(game.isPlayerOneTurn(), "After Player One's move, it should be Player Two's turn.");

        game.placeLetter(1, 1, 'O'); 
        assertFalse(game.isPlayerOneTurn(), "After Player Two's move, it should be Player One's turn again.");
    }
}
