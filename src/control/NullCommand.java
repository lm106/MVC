package control;

import control.Command;

/**
 *
 * @author Luzma
 * @version 27-11-2020
 * @since Práctica en Aula
 */
public class NullCommand implements Command {
    public static final Command instance  = new NullCommand();
    public NullCommand() {
    }

    @Override
    public void execute() {
        
    }
    
}
