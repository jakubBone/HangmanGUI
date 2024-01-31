
import javax.swing.*;
public class HangmanTest {

    public static void main(String[] args)  {
        Gibbet gibbet = new Gibbet();
        Game game = new Game();

        gibbet.createEmptyGibbet();
        System.out.println();
        game.randomizeWord();

        SwingUtilities.invokeLater(() -> new HangmanGUI());

        while(Game.ifGameContinue){
            game.checkGuess();
            System.out.println();
        }
    }
}
