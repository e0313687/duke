public class AddCommand extends Command {
    private final Task task;

    public AddCommand(Task task){
        this.task = task;
    }

    @Override
    public void execute(Ui ui, Storage storage) {
        storage.getTasks().add(task);
        ui.showAdd(task);
        storage.write();
        ui.showTotal(storage.getTasks());
    }
}
