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
    private JTextField textField;
    private JButton guessButton;
    private static final String IMAGES_FOLDER_PATH = "images";
    Game game = new Game();

    public HangmanGUI() {
        game.randomizeWord();

        frame = new JFrame("Hangman Game");
        frame.setSize(600, 600);

        textField = new JTextField(1);
        guessButton = new JButton("Guess");
        wordLabel = new JLabel(String.valueOf(Game.hiddenWord));

        imageLabel = new JLabel();
        imageLabel.setPreferredSize(new Dimension(200, 200));
        imageLabel.setHorizontalAlignment(JLabel.CENTER);

        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        guessPanel = new JPanel();

        //////////////////////////////////////////////////////////
        guessPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        guessPanel.setLayout(new BoxLayout(guessPanel, BoxLayout.Y_AXIS));
        /////////////////////////////////////////////////////////
        
        guessPanel.add(wordLabel);
        guessPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Przerwa o wysokości 10 pikseli
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

