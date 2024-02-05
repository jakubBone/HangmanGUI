import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;

public class HangmanGUI {
    private JFrame frame;
    private JPanel mainPanel;
    private JPanel guessPanel;
    private JLabel wordLabel;
    private JLabel imageLabel;
    private JTextField textField;
    private JButton guessButton;
    private static final String IMAGES_FOLDER_PATH = "images";
    Game game = new Game();

    public HangmanGUI() {
        game.randomizeWord();

        frame = new JFrame("Hangman Game");
        frame.setSize(600, 600);

        //TEXT
        textField = new JTextField(1);
        textField.setFont(new Font(textField.getFont().getName(), Font.PLAIN, 20)); // Letter size
        textField.setPreferredSize(new Dimension(textField.getPreferredSize().width, textField.getPreferredSize().height)); // height

        // BUTTON
        guessButton = new JButton("Guess");
        guessButton.setFont(new Font(guessButton.getFont().getName(), Font.PLAIN, 20)); //Letter size
        guessButton.setPreferredSize(new Dimension(100, 50)); // height

        // WORD
        wordLabel = new JLabel(String.valueOf(Game.hiddenWord));
        wordLabel.setFont(new Font(wordLabel.getFont().getName(), Font.PLAIN, 80)); // Letter size
        wordLabel.setPreferredSize(new Dimension(wordLabel.getPreferredSize().width, wordLabel.getPreferredSize().height)); // height

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

            }
        });
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

    /*public static ImageIcon loadGibbetImage(int index) {
                String imagePath = IMAGES_FOLDER_PATH + "/gibbet_" + index + ".jpg";
                URL resource = HangmanGUI.class.getClassLoader().getResource(imagePath);

                if (resource != null) {
                    return new ImageIcon(resource);
        } else {
            System.err.println("There is no image: " + imagePath);
            return null;
        }
    }*/
}

