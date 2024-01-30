import java.util.Scanner;

public class Game extends Gibbet {
    Scanner scanner = new Scanner(System.in);
    public static String word;
    public static char[] wordInTable;
    public static char[] hiddenWord;

    public static int counter;

    public static boolean ifGameContinue = true;


    public void askForWord() {
        System.out.print("User 1: Come up with a word: ");  // The method asks User 1 for a word.
        word = scanner.nextLine().toUpperCase();
        wordInTable = word.toCharArray();                   // First the word is fragmented into chars and located in wordInTable
        hiddenWord = new char[word.length()];
        for (int i = 0; i < word.length(); i++) {           // The char[] hiddenWord is filled by '_'
            hiddenWord[i] = '_';
        }
        System.out.print("Word to guess: ");
        for (int i = 0; i < word.length(); i++) {
            System.out.print(hiddenWord[i]);
        }
        System.out.println(" Number of letters: " + word.length());
        System.out.println();
    }

    public void checkGuess() {                              // The method checks if is the letter in the word
        boolean hit = false;
        char userGuess = guessTheLetter();
        for (int i = 0; i < wordInTable.length; i++) {
            if (wordInTable[i] == userGuess) {
                wordInTable[i] = '-';                   // If guess is correct the the letters is repleaced with '-'
                hiddenWord[i] = userGuess;
                hit = true;
            }
        }
        System.out.println("Actual state of word: " + String.valueOf(Game.hiddenWord));
        if(hit) {
            counter++;
            if(counter < word.length())
                System.out.println("Congratulation, you hit the letter!");
            else {
                System.out.println("Great! You won!");
                ifGameContinue = false;
            }
        }
        else {
            if(gibbetElementsCounter < 11) {
                System.out.print("You missed! The gibbet is being formed: ");
                Gibbet.buildAndPrintGibbet();
                gibbetElementsCounter++;
            }
            else {
                Gibbet.buildAndPrintGibbet();
                System.out.println("Gibbet is completed... You lost :( !");
                ifGameContinue = false;
            }
        }
    }

    public char guessTheLetter(){                          // The method asks User 2 for the letter
        char guess;
        while(true) {
            System.out.print("User 2: Guess the letter: ");
            String input = scanner.nextLine().toUpperCase();
            if(input.length() == 1) {
                guess = input.charAt(0);
                if(guess != '\n')
                    break;
            }
        }
        return guess;
    }
}