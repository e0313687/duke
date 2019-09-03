import java.util.ArrayList;

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
