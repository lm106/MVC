package app.swing;

import control.Command;
import control.NextCommand;
import control.PrevCommand;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import model.Image;
import view.ImageDisplay;

/**
 *
 * @author Luzma
 * @version 11-12-2020
 * @since Práctica en Aula
 */
public class Main extends JFrame{
    public static void main(String[] args) {
        new Main().execute();
    }
    
    private List<Image> images;
    private ImageDisplay imageDisplay;
    private Map<String, Command> commands = new HashMap<>();
    
    public Main(){
        this.setTitle("Image Viewer");
        this.setSize(800,600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.getContentPane().add(imagePanel());
        this.add(toolbar(), BorderLayout.SOUTH);
    }

    private void execute() {
        this.images = new FileImageLoader(new File("Fotos")).load();
        this.imageDisplay.show(images.get(0));
        this.commands.put("<", new PrevCommand(images, imageDisplay));
        this.commands.put(">", new NextCommand(images, imageDisplay));
        this.setVisible(true);
    }

    private JPanel imagePanel() {
        ImagePanel panel = new ImagePanel();
        this.imageDisplay = panel;
        return panel;
    }

    private JMenuBar toolbar() {
        JMenuBar toolbar = new JMenuBar();
        toolbar.add(button("<"));
        toolbar.add(button(">"));
        return toolbar;
    }

    private JButton button(String name) {
        JButton buton = new JButton(name);
        buton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                commands.get(name).execute();
            }
            
        });
        return buton;
    }
    
}
