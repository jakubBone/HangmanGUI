
import java.util.Scanner;
public class HangmanTest {

    public static void main(String[] args)  {

        Gibbet gibbet = new Gibbet();
        Game game = new Game();
        Scanner sc = new Scanner(System.in);

        gibbet.createEmptyGibbet();
        System.out.println();
        game.askForWord();


        while(Game.ifGameContinue){
            game.checkGuess();
            System.out.println();
        }
    }
}
}
