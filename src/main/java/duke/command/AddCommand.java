package duke.command;

import duke.storage.Storage;
import duke.tasks.Task;
import duke.ui.Ui;

/**
 * A command class to add a new task.
 */
public class AddCommand extends Command {
    private final Task task;

    /**
     * A new AddCommand is created given the task.
     *
     * @param task The task to add to the list.
     */
    public AddCommand(Task task){
        this.task = task;
    }

    /**
     * This command is executed on the user interface and the given task list.
     *
     * @param ui The user interface that displays tasks on the list.
     * @param storage The storage object that contains the list.
     */
    @Override
    public void execute(Ui ui, Storage storage) {
        storage.getTasks().add(task);
        ui.showAdd(task);
        storage.write();
        ui.showTotal(storage.getTasks());
    }
}
