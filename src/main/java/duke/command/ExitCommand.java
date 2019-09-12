package duke.command;

import duke.storage.Storage;
import duke.ui.Ui;

/**
 * A command class to exit the program.
 */
public class ExitCommand extends Command {

    /**
     * This command executes on the user interface and the given list.
     *
     * @param ui The user interface that displays tasks on the list.
     * @param storage The storage object that contains the list.
     */
    @Override
    public void execute(Ui ui, Storage storage) {
        ui.showBye();
    }
}
