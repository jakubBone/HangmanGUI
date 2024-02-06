import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class HangmanGUI {
    private String userName;
    private JFrame frame;
    private JPanel mainPanel;
    private JPanel guessPanel;
    private JLabel wordLabel;
    private JLabel attemptsLabel;
    private JLabel imageLabel;
    private JTextField textField;
    private JButton guessButton;
    private static final String IMAGES_FOLDER_PATH = "images";
    Game game = new Game();


    public HangmanGUI() {
        game.createAndHideWord();

        userName = JOptionPane.showInputDialog("Welcome in Hangman Game! Please enter your name:").toUpperCase();
        frame = new JFrame("Hangman Game");
        frame.setSize(700, 700);

        //ATTEMPTS
        attemptsLabel = new JLabel("Hello Buddy! Let's try to guess the hidden word!");
        attemptsLabel.setHorizontalAlignment(SwingConstants.CENTER);
        attemptsLabel.setFont(new Font(attemptsLabel.getFont().getName(), Font.PLAIN, 20));

        //TEXT
        textField = new JTextField(1);
        textField.setFont(new Font(textField.getFont().getName(), Font.PLAIN, 30)); // Letter size
        textField.setPreferredSize(new Dimension(textField.getPreferredSize().width, textField.getPreferredSize().height)); // height

        // BUTTON
        guessButton = new JButton("Guess");
        guessButton.setFont(new Font(guessButton.getFont().getName(), Font.PLAIN, 20)); //Letter size
        guessButton.setPreferredSize(new Dimension(100, 50)); // height

        // WORD
        wordLabel = new JLabel(Game.getHiddenWord());
        wordLabel.setFont(new Font(wordLabel.getFont().getName(), Font.PLAIN, 60)); // Letter size
        wordLabel.setPreferredSize(new Dimension(Game.getHiddenWord().length() * 30, wordLabel.getPreferredSize().height)); // set letter to 30pix
        wordLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // IMAGE
        imageLabel = new JLabel();
        imageLabel.setHorizontalAlignment(JLabel.CENTER);

        // MAIN PANEL
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBackground(Color.white);

        // GUESS PANEL
        guessPanel = new JPanel(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(5, 0, 5, 0);
        guessPanel.add(wordLabel, gbc);
        gbc.gridy = 1;
        guessPanel.add(textField, gbc);
        gbc.gridy = 2;
        guessPanel.add(guessButton, gbc);

        mainPanel.add(attemptsLabel, BorderLayout.NORTH); //
        mainPanel.add(imageLabel, BorderLayout.CENTER);
        mainPanel.add(guessPanel, BorderLayout.SOUTH);

        frame.setLayout(new BorderLayout());
        frame.add(mainPanel);

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        readImage("C:\\Users\\Jakub Bone\\Z2J\\HangmanGUI\\src\\images\\gibbet_1.jpg");

        guessButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String guessedLetter = textField.getText();
                handleGuess(guessedLetter);
                wordLabel.setText(String.valueOf(Game.getHiddenWord()));
            }
        });
    }

    private void handleGuess(String guessedLetter){

        // Check is quessedLetter is single Lletter
        if (guessedLetter.length() != 1) {
            // Exception handling
            JOptionPane.showMessageDialog(frame, "Please enter a single letter...", "Invalid Input", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if(game.checkGuess(guessedLetter.charAt(0))){
            attemptsLabel.setText("Hit! Well done " + userName + "! Keep going!");
        } else{
            Game.attemptsCounter--;
            attemptsLabel.setText("Yikes! That must have hurt... Be careful! You still have "
                    + String.valueOf(Game.attemptsCounter) + " attempts left");
        }

    }


    private void readImage (String address) {
        try {
            BufferedImage image = ImageIO.read(new File(address));
            ImageIcon icon = new ImageIcon(image);
            imageLabel.setIcon(icon);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

