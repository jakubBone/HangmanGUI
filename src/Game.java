
import java.util.Random;
import java.util.Scanner;

public class Game{
    Scanner scanner = new Scanner(System.in);
    private static String word;
    private static char[] wordInTable;
    private static char[] hiddenWord;
    private static int attemptsCounter = 11;
    private String[] words = {"BIKE", "CROCODILE", "MOVIE", "ERROR", "MEXICO", "AIRPORT"};

    public Game(){
        initializeWord();
    }

    private void initializeWord() {
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
                wordInTable[i] = 'x';
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

    public void decrementAttemptsCounter() {
         attemptsCounter--;
    }
    public int getAttemptsCounter() {
        return attemptsCounter;
    }
    public boolean ifAttemptsExhausted(){
        return attemptsCounter == 0;
    }
    public boolean isWordGuessed() {
        return !String.valueOf(hiddenWord).contains("_");
    }

    public boolean ifGameFinished(){
        return ifAttemptsExhausted() || isWordGuessed();
    }
}