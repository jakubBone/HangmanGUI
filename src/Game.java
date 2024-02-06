
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Game extends Gibbet {
    Scanner scanner = new Scanner(System.in);
    public static String word;
    public static char[] wordInTable;
    public static char[] hiddenWord;
    public static int counter;
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

    public void checkGuess(char letter) {                              // The method checks if is the letter in the word
        for (int i = 0; i < wordInTable.length; i++) {
            if (wordInTable[i] == letter) {
                wordInTable[i] = '-';                   // If guess is correct the the letters is repleaced with '-'
                hiddenWord[i] = letter;
            }
        }
    }

    public static String getHiddenWord(){
        ArrayList <Character> word = new ArrayList<>();
        for(char element: hiddenWord){
            word.add(element);
            word.add(' ');
        }
        StringBuilder result = new StringBuilder();

        for(Character element: word){
            result.append(element);
        }
        return result.toString();
    }

}