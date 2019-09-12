package duke.command;

import duke.storage.Storage;
import duke.ui.Ui;

public class ListCommand extends Command {
    @Override
    public void execute(Ui ui, Storage storage) {
        ui.showList(storage.getTasks());
    }
}
