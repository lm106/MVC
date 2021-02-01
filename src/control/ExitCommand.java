package control;

/**
 *
 * @author Luzma
 * @version 27-11-2020
 * @since Práctica en Aula
 */
public class ExitCommand implements Command{

    @Override
    public void execute() {
        System.exit(0);
    }
    
}
