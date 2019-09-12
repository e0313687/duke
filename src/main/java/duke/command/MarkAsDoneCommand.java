package duke.command;

import duke.storage.Storage;
import duke.tasks.Task;
import duke.ui.Ui;

/**
 * A command class to mark a task as done.
 */
public class MarkAsDoneCommand extends Command {
    private int index;

    /**
     * A new MarkAsDoneCommand is created with the given index.
     *
     * @param index The index of the task.
     */
    public  MarkAsDoneCommand(int index){
        this.index = index;
    }

    /**
     * This command is executed on the user interface and the given list.
     *
     * @param ui The user interface that displays tasks on the list.
     * @param storage The storage object that contains the list.
     */
    @Override
    public void execute(Ui ui, Storage storage){
        try {
            Task userCommands = storage.getTasks().get(index);
            userCommands.markAsDone();
            ui.showMarkDone(userCommands);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Index requested is out of bounds!");
        }
        storage.write();
    }
}
