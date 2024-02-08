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
    Game game = new Game();
    GibbetImage gibbetImage = new GibbetImage();
    public static int imageIndex;

    public HangmanGUI() {
        userName = JOptionPane.showInputDialog("Welcome in Hangman Game! Please enter your name:").toUpperCase();
        setFrame();
        setAttemptsLabel();
        setTextField();
        setGuessButton();
        setWordLabel();
        setImageLabel();
        setMainPanel();
        setGuessPanel();
        addComponentsToFrame();

        performAction();

    }

    private void setFrame(){
        frame = new JFrame("Hangman Game");
        frame.setSize(700, 700);
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void setAttemptsLabel(){
        attemptsLabel = new JLabel("Hello " + userName + "! Let's guess the hidden word!");
        attemptsLabel.setHorizontalAlignment(SwingConstants.CENTER);
        attemptsLabel.setFont(new Font(attemptsLabel.getFont().getName(), Font.PLAIN, 20));
    }
    private void setTextField(){
        textField = new JTextField(1);
        textField.setFont(new Font(textField.getFont().getName(), Font.PLAIN, 30)); // Letter size
        textField.setPreferredSize(new Dimension(textField.getPreferredSize().width, textField.getPreferredSize().height)); // height
    }

    private void setGuessButton(){
        guessButton = new JButton("Guess");
        guessButton.setFont(new Font(guessButton.getFont().getName(), Font.PLAIN, 20)); //Letter size
        guessButton.setPreferredSize(new Dimension(100, 50)); // height
    }

    private void setWordLabel(){
        wordLabel = new JLabel(Game.getHiddenWord());
        wordLabel.setFont(new Font(wordLabel.getFont().getName(), Font.PLAIN, 60)); // Letter size
        wordLabel.setPreferredSize(new Dimension(Game.getHiddenWord().length() * 30, wordLabel.getPreferredSize().height)); // set letter to 30pix
        wordLabel.setHorizontalAlignment(SwingConstants.CENTER);
    }

    private void setImageLabel(){
        imageLabel = new JLabel();
        imageLabel.setHorizontalAlignment(JLabel.CENTER);
    }

    private void setMainPanel(){
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBackground(Color.white);
    }

    private void setGuessPanel(){
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
    }
    private void addComponentsToFrame(){
        mainPanel.add(attemptsLabel, BorderLayout.NORTH);
        mainPanel.add(imageLabel, BorderLayout.CENTER);
        mainPanel.add(guessPanel, BorderLayout.SOUTH);
        frame.add(mainPanel);
    }
    private void performAction(){
        imageLabel.setIcon(gibbetImage.images.get(imageIndex));
        guessButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(game.ifAttemptsExhausted()){
                    JOptionPane.showMessageDialog(null, "All attempts exhausted! You lost :(");
                    System.exit(0);
                }

                String guessedLetter = textField.getText().toUpperCase();

                if (guessedLetter.length() != 1) {
                        JOptionPane.showMessageDialog(frame, "Please enter a single letter...", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                        return;
                }

                if(game.checkGuess(guessedLetter.charAt(0))){
                    attemptsLabel.setText("Hit! Well done " + userName + "! Keep going!");
                } else{
                    game.setAttemptsCounter();
                    attemptsLabel.setText("Yikes! That must have hurt... Be careful! You still have "
                            + String.valueOf(game.getAttemptsCounter()) + " attempts left");
                    imageIndex --;
                    updateImage();

                }
                wordLabel.setText(String.valueOf(Game.getHiddenWord()));
                clearTextField(textField);
            }
        });
    }

    private void updateImage(){
        imageLabel.setIcon()
    }
    private void clearTextField(JTextField field){
        field.setText("");
    }
}

