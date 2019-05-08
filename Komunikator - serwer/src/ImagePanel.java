import javax.swing.*;
import java.awt.*;

public class ImagePanel extends JPanel {

    ImageIcon bg = new ImageIcon("src/bg.png");

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(bg.getImage(), 0, 0, 600, 350, null);
    }
}