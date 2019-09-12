import duke.command.Command;
import duke.command.ExitCommand;
import duke.exception.DukeException;
import duke.parser.Parser;
import duke.storage.Storage;
import duke.ui.Ui;

/**
 * The Duke program is a simple Personal Assistant Chatbot that helps to keep track of various things.
 *
 * @autho e0313687
 */
public class Duke {
    private static final String FILE_PATH = "duke.txt";

    /**
     * This creates Duke.
     */
    private Duke(){
        Ui ui = new Ui();
        ui.showWelcome();
        Storage storage = new Storage(FILE_PATH, ui);
        while (true){
            String userInput = ui.readCommand();
            try {
                Command command = Parser.parse(userInput);
                command.execute(ui, storage);
                if (command instanceof ExitCommand) {
                    break;
                }
            } catch (DukeException e) {
                ui.showError(e.getMessage());
            }
        }
    }

    /**
     * This is the entry point;
     * @param args
     */
    public static void main (String[] args){
        new Duke();
    }
}