package sosGame449;

import javax.swing.SwingUtilities;

public class SOSGameMain {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                SOSGame model = new SOSGame(5); 
                SOSGameView view = new SOSGameView();
                new SOSGameController(model, view);
                view.setVisible(true);
            }
        });
    }
}
