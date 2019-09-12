package duke.command;

import duke.storage.Storage;
import duke.tasks.Task;
import duke.ui.Ui;

import java.util.ArrayList;

/**
 * A command class to find a task given keyword.
 */
public class FindCommand extends Command {
    private String word;

    public FindCommand(String word){
        this.word = word;
    }

    @Override
    public void execute(Ui ui, Storage storage) {
        ArrayList<Task> userCommands = storage.getTasks();
        ArrayList<Task> result = new ArrayList<>();
        for (Task task: userCommands) {
            if (task.toString().contains(word)) {
                result.add(task);
            }
        }
        ui.showList(result);
    }
}
