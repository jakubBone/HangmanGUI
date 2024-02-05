
import javax.swing.*;
public class HangmanTest {

    public static void main(String[] args)  {
        SwingUtilities.invokeLater(() -> new HangmanGUI());
        Game game = new Game();
        game.handleGame();
        Game.getHiddenWord();
    }
}
