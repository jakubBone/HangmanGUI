import javax.swing.*;
import java.util.ArrayList;

public class GibbetImage {
    ImageIcon welcomeImage = new ImageIcon("src\\images\\Welcome.png");
    ImageIcon gibbet1 = new ImageIcon("src\\images\\Gibbet_1.png");
    ImageIcon gibbet2 = new ImageIcon("src\\images\\Gibbet_2.png");
    ImageIcon gibbet3 = new ImageIcon("src\\images\\Gibbet_3.png");
    ImageIcon gibbet4 = new ImageIcon("src\\images\\Gibbet_4.png");
    ImageIcon gibbet5 = new ImageIcon("src\\images\\Gibbet_5.png");
    ImageIcon gibbet6 = new ImageIcon("src\\images\\Gibbet_6.png");
    ImageIcon gibbet7 = new ImageIcon("src\\images\\Gibbet_7.png");
    ImageIcon gibbet8 = new ImageIcon("src\\images\\Gibbet_8.png");
    ImageIcon gibbet9 = new ImageIcon("src\\images\\Gibbet_9.png");
    ImageIcon gibbet10 = new ImageIcon("src\\images\\Gibbet_10.png");
    ImageIcon gibbet11 = new ImageIcon("src\\images\\Gibbet_11.png");

    ArrayList<ImageIcon> images = new ArrayList<>();
    private static int currentImageIndex = 0;

    public GibbetImage(){
        images.add(welcomeImage);
        images.add(gibbet1);
        images.add(gibbet2);
        images.add(gibbet3);
        images.add(gibbet4);
        images.add(gibbet5);
        images.add(gibbet6);
        images.add(gibbet7);
        images.add(gibbet8);
        images.add(gibbet9);
        images.add(gibbet10);
        images.add(gibbet11);
    }

    public ImageIcon getImage(){
        return images.get(currentImageIndex);
    }

    public void incrementCurrentImageIndex(){
        currentImageIndex++;
    }
}
