import javax.swing.*;
import java.awt.*;

public class HangmanGUI {
    private JFrame frame;
    private JPanel imagePanel;
    private JPanel mainPanel;
    private JPanel topPanel;
    private JPanel middlePanel;
    private JPanel bottomPanel;
    private JLabel wordLabel;
    private JTextField letterField;
    private JButton guessButton;

    public HangmanGUI() {
        frame = new JFrame("Hangman Game");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        letterField = new JTextField(1);
        guessButton = new JButton("Enter");

        int windowHeight = frame.getHeight();

        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        topPanel = new JPanel();
        wordLabel = new JLabel("Guess the word: " + new String(Game.hiddenWord));

        topPanel.add(wordLabel);
        mainPanel.add(topPanel, BorderLayout.NORTH);

        middlePanel = new JPanel();
        letterField = new JTextField(1);
        middlePanel.add(letterField);
        mainPanel.add(middlePanel, BorderLayout.CENTER);

        bottomPanel = new JPanel();
        guessButton = new JButton("Enter");
        bottomPanel.add(guessButton);
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);

        frame.setLayout(new BorderLayout());
        frame.add(mainPanel);

        imagePanel = new JPanel();
        imagePanel.setPreferredSize(new Dimension(500, windowHeight / 2));
        frame.add(imagePanel, BorderLayout.NORTH);

        frame.setVisible(true);
    }
}

