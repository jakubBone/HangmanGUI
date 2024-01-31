import javax.swing.*;
import java.awt.*;

public class HangmanGUI {
    private JFrame frame;
    private JPanel gibbetPanel;
    private JLabel wordLabel;
    private JTextField letterField;
    private JButton guessButton;

        public HangmanGUI(){
            frame = new JFrame("Hangman Game");
            frame.setSize(500, 500);
            frame.setVisible(true);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            gibbetPanel = new JPanel();
            wordLabel = new JLabel("Guess the word: " + new String(Game.hiddenWord));
            letterField = new JTextField(1);
            guessButton = new JButton("Enter");

            gibbetPanel.add(wordLabel);
            gibbetPanel.add(letterField);
            gibbetPanel.add(guessButton);

            frame.setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.weighty = 1.0;

            frame.add(gibbetPanel, gbc);

        }
}
