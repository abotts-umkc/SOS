package sosGame449;

import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class SOSGameController {
    private SOSGame model;
    private SOSGameView view;

    public SOSGameController(SOSGame model, SOSGameView view) {
        this.model = model;
        this.view = view;

        view.getStartGameButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startGame();
            }
        });
    }

    private void startGame() {
        try {
            int boardSize = Integer.parseInt(view.getBoardSizeField().getText());
            if (boardSize < 3) {
                throw new NumberFormatException("Board size must be at least 3.");
            }

            String gameType = view.isSimpleGameSelected() ? "simple" : "general";
            JOptionPane.showMessageDialog(view, "Starting a " + gameType + " game.");

            model = new SOSGame(boardSize);

            view.updateTurnLabel("It is the Red Player's Turn");

            // Update the board 
            updateBoard();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(view, "Invalid board size. Please enter a number greater than or equal to 3.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }



    private void updateBoard() {
        view.getBoardPanel().removeAll();
        int boardSize = model.getBoardSize();
        view.getBoardPanel().setLayout(new GridLayout(boardSize, boardSize));

        JButton[][] boardButtons = new JButton[boardSize][boardSize];
        for (int row = 0; row < boardSize; row++) {
            for (int col = 0; col < boardSize; col++) {
                JButton button = new JButton();
                final int r = row;
                final int c = col;
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        placeLetter(r, c, button);
                    }
                });
                boardButtons[row][col] = button;
                view.getBoardPanel().add(button);
            }
        }
        view.getBoardPanel().revalidate();
        view.getBoardPanel().repaint();
    }

    private void placeLetter(int row, int col, JButton button) {
        // force update the selected button 
        SwingUtilities.invokeLater(() -> {
            char letter = view.getSelectedLetter(model.isPlayerOneTurn());
            System.out.println("Player's turn: " + (model.isPlayerOneTurn() ? "Red" : "Blue"));
            System.out.println("Selected letter: " + letter);

            if (model.placeLetter(row, col, letter)) {
                button.setText(String.valueOf(letter));
                view.updateButtonColor(button, model.isPlayerOneTurn());

                //  radio buttons for each player on and off
                if (model.isPlayerOneTurn()) {
                    view.enableRedPlayerButtons();
                    view.disableBluePlayerButtons();
                } else {
                    view.enableBluePlayerButtons();
                    view.disableRedPlayerButtons();
                }
            } else {
                JOptionPane.showMessageDialog(view, "Invalid move. The cell is already occupied.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
    }
}