package app.swing;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import model.Image;
import view.ImageDisplay;

/**
 *
 * @author Luzma
 * @version 11-12-2020
 * @since Práctica en Aula
 */
public class ImagePanel extends JPanel implements ImageDisplay{
    private Image image;
    private BufferedImage data;

    public ImagePanel() {
    }
    
    @Override
    public void paint(Graphics g){
        Box box = new Box(data.getWidth(), data.getHeight(), this.getWidth(), this.getHeight());
        g.drawImage(data, box.x, box.y, box.width, box.height, null);
    }

    @Override
    public void show(Image image) {
        this.image = image;
        this.data = load(new File(image.getName()));
        repaint();
    }

    @Override
    public Image image() {
        return this.image;
    }

    private BufferedImage load(File file) {
        try {
            return ImageIO.read(file);
        } catch (IOException ex) {
            System.out.println("ERROR: (file not found" + ex.getMessage());
            return null;
        }
    }

    private static class Box {
        final int x, y, width, height;
        public Box(int width, int height, int width0, int height0) {
            double imageRatio = width/height;
            double panelRatio = width0 /height0;
            this.width = (int) (imageRatio >= panelRatio ? width0 : width*height0 / height);
            this.height = (int) (imageRatio <= panelRatio ? height0 : height * width0 / height);
            this.x = (int) ((width0 - this.width)/2);
            this.y = (int) ((height0 - this.height)/2);
        }
    }
    
    
    
    
}
