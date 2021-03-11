package kz.abzal.UIElements;

import javax.swing.*;
import java.awt.*;

public class ImagePanel extends JComponent {
    //just JComponent with image to switch background image
    private Image image;
    public ImagePanel(Image image) {
        this.image = image;
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this);
    }
}
