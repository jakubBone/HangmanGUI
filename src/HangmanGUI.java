import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class HangmanGUI {
    private JFrame frame;
    private JPanel mainPanel;
    private JPanel guessPanel;
    private JLabel wordLabel;
    private JLabel imageLabel;
    private JLabel instructionLabel;
    private JTextField textField;
    private JButton guessButton;
    private static final String IMAGES_FOLDER_PATH = "images";
    Game game = new Game();

    public HangmanGUI() {
        game.randomizeWord();

        frame = new JFrame("Hangman Game");
        frame.setSize(600, 600);


        instructionLabel = new JLabel("GUESS THE WORD:");
        instructionLabel.setFont(new Font(instructionLabel.getFont().getName(), Font.PLAIN, 20));
        //TEXT
        textField = new JTextField(1);
        textField.setPreferredSize(new Dimension(50, textField.getPreferredSize().height));
        // BUTTON
        guessButton = new JButton("Guess");
        guessButton.setFont(new Font(guessButton.getFont().getName(), Font.PLAIN, 20));
        guessButton.setPreferredSize(new Dimension(100, 50));
        // WORD
        wordLabel = new JLabel(String.valueOf(Game.hiddenWord));
        wordLabel.setFont(new Font(wordLabel.getFont().getName(), Font.PLAIN, 80));

        imageLabel = new JLabel();
        imageLabel.setPreferredSize(new Dimension(300, 300));
        imageLabel.setHorizontalAlignment(JLabel.CENTER);

        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        guessPanel = new JPanel();
        guessPanel.setLayout(new BoxLayout(guessPanel, BoxLayout.Y_AXIS));
        guessPanel.setBorder(BorderFactory.createEmptyBorder(20, 150, 20, 150));


        guessPanel.add(instructionLabel);
        guessPanel.add(wordLabel);
        guessPanel.add(Box.createRigidArea(new Dimension(0, 40))); // Przerwa o wysokości 10 pikseli
        guessPanel.add(textField);
        guessPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Przerwa o wysokości 10 pikseli
        guessPanel.add(guessButton);



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

