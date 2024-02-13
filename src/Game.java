import java.util.Random;
public class Game{
    Scanner scanner = new Scanner(System.in);
    private static String word;
    private static char[] wordInTable;
    private static char[] hiddenWord;
    private static int attemptsCounter = 11;
    private String[] words = {"JAVA", "PYTHON", "DEVELOPER", "SWING"};

    public Game(){
        initWord();
    }

    // Randomizing the word from array and hide the letters to '_'
    private void initWord() {
        Random random = new Random();
        int index = random.nextInt(words.length);
        word = words[index];
        wordInTable = word.toCharArray();
        hiddenWord = new char[word.length()];
        for (int i = 0; i < word.length(); i++ ) {
            hiddenWord[i] = '_';
        }
    }

    public boolean ifLetterGuessed(char letter) {
        boolean isValid = false;
        for (int i = 0; i < wordInTable.length; i++) {
            if (wordInTable[i] == letter) {
                hiddenWord[i] = letter;
                isValid = true;
            }
        }
        return isValid;
    }

    // Preparing a delimited hidden word using append(" ") e.g. BIKE -> B I K E
    // The pattern is suitable for display in a Frame
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
    public boolean areAttemptsExhausted(){
        return attemptsCounter == 0;
    }
    public boolean ifWordGuessed() {
        return !String.valueOf(hiddenWord).contains("_");
    }
    public boolean ifGameFinished(){
        return areAttemptsExhausted() || ifWordGuessed();
    }
}