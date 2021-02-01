package app.mock;

import app.mock.MockImageDisplay;
import app.mock.MockImageLoader;
import control.NullCommand;
import control.Command;
import control.ExitCommand;
import control.NextCommand;
import control.PrevCommand;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import model.Image;
import view.ImageDisplay;
import view.ImageLoader;

/**
 *
 * @author Luzma
 * @version 27-11-2020
 * @since Práctica en Aula
 */
public class Main {
    public static void main(String[] args) {
        // TODO code application logic herep
        Scanner scanner = new Scanner(System.in);        
        Map<String, Command> commands = iniCommands(new MockImageLoader());
        while(true){
            commands.getOrDefault(scanner.next(), NullCommand.instance).execute();
        }
    }    

    private static Map<String, Command> iniCommands(ImageLoader imageLoader) {
        List<Image>images = imageLoader.load();
        ImageDisplay imageDisplay = createImageDisplay(images);
        Map<String,Command> result = new HashMap<>();
        result.put("q", new ExitCommand());
        result.put("p", new PrevCommand(images, imageDisplay));
        result.put("n", new NextCommand(images, imageDisplay));
        result.put("Q", result.get("q"));
        result.put("P", result.get("p"));
        result.put("N", result.get("n"));
        return result;
    }

    private static ImageDisplay createImageDisplay(List<Image> images) {
        
        ImageDisplay imageDisplay = new MockImageDisplay();
        imageDisplay.show(images.get(0));
        return imageDisplay;
    }

    private static List<Image> loadImages() {
        return new MockImageLoader().load();
        
    }
}
