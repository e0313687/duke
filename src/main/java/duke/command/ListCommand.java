package duke.command;

import duke.storage.Storage;
import duke.ui.Ui;

/**
 * A command class to list all the tasks.
 */
public class ListCommand extends Command {

    /**
     * This command is executed on the user interface and the given task list.
     *
     * @param ui The user interface that displays tasks on the list.
     * @param storage The storage object that contains the list.
     */
    @Override
    public void execute(Ui ui, Storage storage) {
        ui.showList(storage.getTasks());
    }
}
