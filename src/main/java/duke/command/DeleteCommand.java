package duke.command;

import duke.exception.DukeException;
import duke.storage.Storage;
import duke.tasks.Task;
import duke.ui.Ui;

import java.util.ArrayList;

public class DeleteCommand extends Command {
    private int index;

    public DeleteCommand(int index) {
        this.index = index;
    }

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
