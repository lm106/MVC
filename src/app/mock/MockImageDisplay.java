package app.mock;

import model.Image;
import view.ImageDisplay;

/**
 *
 * @author Luzma
 * @version 27-11-2020
 * @since Práctica en Aula
 */
public class MockImageDisplay implements ImageDisplay{

    private Image image;

    @Override
    public void show(Image image) {
        System.out.print(image.getName());
    }

    @Override
    public Image image() {
        return image;
    }
    
}
