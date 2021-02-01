package app.mock;

import java.util.ArrayList;
import java.util.List;
import model.Image;
import view.ImageLoader;

/**
 *
 * @author Luzma
 * @version 27-11-2020
 * @since Práctica en Aula
 */
public class MockImageLoader implements ImageLoader{

    @Override
    public List<Image> load() {
        ArrayList<Image> list = new ArrayList<Image>();
        list.add(new Image("hola"));
        list.add(new Image("mundo"));
        list.add(new Image("Bienvenido"));       
        return list;
    }    
}
