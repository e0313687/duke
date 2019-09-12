package duke.command;

import duke.exception.DukeException;
import duke.storage.Storage;
import duke.tasks.Task;
import duke.ui.Ui;

/**
 * A command class to delete a new task.
 */
public class DeleteCommand extends Command {
    private int index;

    /**
     * A new DeleteCommand is created with the given index.
     *
     * @param index The index of the task.
     */
    public DeleteCommand(int index) {
        this.index = index;
    }

    /**
     * This command is executed on the user interface and the given list.
     *
     * @param ui The user interface that displays tasks on the list.
     * @param storage The storage object that contains the list.
     * @throws DukeException
     */
    @Override
    public void execute(Ui ui, Storage storage) throws DukeException {
        try {
            Task task = storage.getTasks().remove(index);
            ui.showDelete(task);
        } catch (IndexOutOfBoundsException e) {
            throw new DukeException("Index requested is out of bounds!");
        }
        storage.write();
        ui.showTotal(storage.getTasks());
    }
}
