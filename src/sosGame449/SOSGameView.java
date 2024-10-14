package sosGame449;

import javax.swing.*;
import java.awt.*;

import javax.swing.*;
import java.awt.*;

public class SOSGameView extends JFrame {
    private static final long serialVersionUID = 1L;

    private JTextField boardSizeField;
    private JButton startGameButton;
    private JPanel boardPanel;
    private JRadioButton playerVsPlayerOption;
    private JRadioButton playerVsComputerOption;
    private JRadioButton redPlayerSOption;
    private JRadioButton redPlayerOOption;
    private JRadioButton bluePlayerSOption;
    private JRadioButton bluePlayerOOption;
    private ButtonGroup redPlayerGroup;
    private ButtonGroup bluePlayerGroup;
    JRadioButton simpleGameOption;
    JRadioButton generalGameOption;
    private ButtonGroup gameTypeGroup;
    private JLabel turnLabel;

    public SOSGameView() {
        setTitle("SOS Game");
        setSize(1000, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel optionsPanel = new JPanel(new GridLayout(4, 2));
        optionsPanel.add(new JLabel("Board Size:"));
        boardSizeField = new JTextField();
        optionsPanel.add(boardSizeField);

        playerVsPlayerOption = new JRadioButton("Player vs Player");
        playerVsComputerOption = new JRadioButton("Player vs Computer");
        ButtonGroup gameModeGroup = new ButtonGroup();
        gameModeGroup.add(playerVsPlayerOption);
        gameModeGroup.add(playerVsComputerOption);
        playerVsPlayerOption.setSelected(true);

        optionsPanel.add(playerVsPlayerOption);
        optionsPanel.add(playerVsComputerOption);

        simpleGameOption = new JRadioButton("Simple Game");
        generalGameOption = new JRadioButton("General Game");
        gameTypeGroup = new ButtonGroup();
        gameTypeGroup.add(simpleGameOption);
        gameTypeGroup.add(generalGameOption);
        simpleGameOption.setSelected(true);

        optionsPanel.add(simpleGameOption);
        optionsPanel.add(generalGameOption);

        startGameButton = new JButton("Start Game");
        optionsPanel.add(startGameButton);

        add(optionsPanel, BorderLayout.NORTH);

        boardPanel = new JPanel();
        boardPanel.setPreferredSize(new Dimension(600, 400));
        boardPanel.setBorder(BorderFactory.createEmptyBorder(20, 100, 20, 100));
        add(boardPanel, BorderLayout.CENTER);

        // whos turn is it
        turnLabel = new JLabel("It is the Red Player's Turn", SwingConstants.CENTER);
        turnLabel.setFont(new Font("Arial", Font.BOLD, 16));
        add(turnLabel, BorderLayout.SOUTH);

        // blue player, it initiated backwards i have to fix it 
        // all blue is red and all red is blue 
        JPanel redPlayerPanel = new JPanel(new GridLayout(3, 1));
        redPlayerPanel.setPreferredSize(new Dimension(150, 50));
        redPlayerPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10), "Blue Player"));
        redPlayerSOption = new JRadioButton("S");
        redPlayerOOption = new JRadioButton("O");
        redPlayerGroup = new ButtonGroup();
        redPlayerGroup.add(redPlayerSOption);
        redPlayerGroup.add(redPlayerOOption);
        redPlayerSOption.setSelected(true);
        redPlayerPanel.add(redPlayerSOption);
        redPlayerPanel.add(redPlayerOOption);

        add(redPlayerPanel, BorderLayout.WEST);

        // red player, all panels are backwards 
        JPanel bluePlayerPanel = new JPanel(new GridLayout(3, 1));
        bluePlayerPanel.setPreferredSize(new Dimension(150, 50));
        bluePlayerPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10), "Red Player"));
        bluePlayerSOption = new JRadioButton("S");
        bluePlayerOOption = new JRadioButton("O");
        bluePlayerGroup = new ButtonGroup();
        bluePlayerGroup.add(bluePlayerSOption);
        bluePlayerGroup.add(bluePlayerOOption);
        bluePlayerSOption.setSelected(true);
        bluePlayerPanel.add(bluePlayerSOption);
        bluePlayerPanel.add(bluePlayerOOption);

        add(bluePlayerPanel, BorderLayout.EAST);
    }
    public void enableRedPlayerButtons() {
        redPlayerSOption.setEnabled(true);
        redPlayerOOption.setEnabled(true);
    }

    public void disableRedPlayerButtons() {
        redPlayerSOption.setEnabled(false);
        redPlayerOOption.setEnabled(false);
    }

    public void enableBluePlayerButtons() {
        bluePlayerSOption.setEnabled(true);
        bluePlayerOOption.setEnabled(true);
    }

    public void disableBluePlayerButtons() {
        bluePlayerSOption.setEnabled(false);
        bluePlayerOOption.setEnabled(false);
    }

    public void updateTurnLabel(String text) {
        turnLabel.setText(text);
    }


    public JTextField getBoardSizeField() {
        return boardSizeField;
    }

    public JButton getStartGameButton() {
        return startGameButton;
    }

    public JPanel getBoardPanel() {
        return boardPanel;
    }

    public boolean isPlayerVsPlayerSelected() {
        return playerVsPlayerOption.isSelected();
    }

    public boolean isSimpleGameSelected() {
        return simpleGameOption.isSelected();
    }

    public char getSelectedLetter(boolean isPlayerOneTurn) {
        if (isPlayerOneTurn) {
            return redPlayerSOption.isSelected() ? 'S' : 'O';
        } else {
            return bluePlayerSOption.isSelected() ? 'S' : 'O';
        }
    }

    public void updateButtonColor(JButton button, boolean isPlayerOneTurn) {
        if (isPlayerOneTurn) {
            button.setForeground(Color.RED);
            turnLabel.setText("It is the Blue Player's Turn");
        } else {
            button.setForeground(Color.BLUE);
            turnLabel.setText("It is the Red Player's Turn");
        }
    }
} 