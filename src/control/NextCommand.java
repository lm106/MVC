package control;

import java.util.List;
import model.Image;
import view.ImageDisplay;

/**
 *
 * @author Luzma
 * @version 27-11-2020
 * @since Práctica en Aula
 */
public class NextCommand implements Command{
    private final List<Image> images;
    private final ImageDisplay imageDisplay;

    public NextCommand(List<Image> images, ImageDisplay imageDisplay) {
        this.images = images;
        this.imageDisplay = imageDisplay;
    }
    @Override
    public void execute() {        
        imageDisplay.show(next());
    }

    private Image next() {
        int index = images.indexOf(imageDisplay.image());
        return images.get((index+1)% images.size()); //modulo, es decir size es 4 si index 1, entonces 1+1 mod 4  = 2 
    }
    
    
    
}
