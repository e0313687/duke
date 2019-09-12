package duke.command;

import duke.storage.Storage;
import duke.tasks.Task;
import duke.ui.Ui;

public class MarkAsDoneCommand extends Command {
    private int index;

    public  MarkAsDoneCommand(int index){
        this.index = index;
    }

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
