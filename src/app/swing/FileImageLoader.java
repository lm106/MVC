package app.swing;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;
import model.Image;
import view.ImageLoader;

/**
 *
 * @author Luzma
 */
public class FileImageLoader implements ImageLoader{
    private final File root;
    private static final String[] imageExtensions = new String[] { "jpg", "png"};
    public FileImageLoader(File root) {
        this.root = root;
    }
    
    
    @Override
    public List<Image> load() {
        List<Image> res = new ArrayList<>();
        File[] files = root.listFiles(filter());
        for (File file : files) {
            res.add(new Image(file.getAbsolutePath()));
        }
        return res;
    }

    private FilenameFilter filter() {
        return new FilenameFilter(){
            @Override
            public boolean accept(File file, String name){
                for (String extension : imageExtensions) {
                    if(name.endsWith(extension)) return true;   
                }
                return false;
            }
        };
    }
    
}
