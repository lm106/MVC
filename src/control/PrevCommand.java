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
public class PrevCommand implements Command{
    private final List<Image> images;
    private final ImageDisplay imageDisplay;

    public PrevCommand(List<Image> images, ImageDisplay imageDisplay) {
        this.images = images;
        this.imageDisplay = imageDisplay;
    }
    @Override
    public void execute() {        
        imageDisplay.show(prev());
    }

    private Image prev() {
        int index = images.indexOf(imageDisplay.image());
        return images.get((index-1+images.size())% images.size()); //modulo, es decir size es 4 si index 1, entonces 1-1 + 4 mod 4  = 0 
    }
    
}
