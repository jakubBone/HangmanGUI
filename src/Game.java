
import java.util.Random;
import java.util.Scanner;

public class Game{
    Scanner scanner = new Scanner(System.in);
    public static String word;
    public static char[] wordInTable;
    public static char[] hiddenWord;
    public static int attemptsCounter = 12;
    public static boolean ifGameContinue = true;
    private String[] words = {"BIKE", "CROCODILE", "MOVIE", "ERROR", "MEXICO", "AIRPORT"};

    public void createAndHideWord() {
        Random random = new Random();
        int index = random.nextInt(words.length);
        word = words[index];
        wordInTable = word.toCharArray();                   // First the word is fragmented into chars and located in wordInTable
        hiddenWord = new char[word.length()];
        for (int i = 0; i < word.length(); i++ ) {           // The char[] hiddenWord is filled by '_'
            hiddenWord[i] = '_';
        }
        System.out.print("Word to guess: ");
        for (int i = 0; i < word.length(); i++) {
            System.out.print(hiddenWord[i]);
        }
        System.out.println(" Number of letters: " + word.length());
        System.out.println();
    }

    public boolean checkGuess(char letter) {
        boolean isValid = false;
        for (int i = 0; i < wordInTable.length; i++) {
            if (wordInTable[i] == letter) {
                hiddenWord[i] = letter;
                isValid = true;
            }
        }
        return isValid;
    }

    public static String getHiddenWord() {
        StringBuilder formattedWord = new StringBuilder();
        for (int i = 0; i < hiddenWord.length; i++) {
            formattedWord.append(hiddenWord[i]);
            if (i < hiddenWord.length - 1) {
                formattedWord.append(" ");
            }
        }
        return formattedWord.toString();
    }
}