package duke.command;

import duke.storage.Storage;
import duke.ui.Ui;

public class ExitCommand extends Command {
    @Override
    public void execute(Ui ui, Storage storage) {
        ui.showBye();
    }
}
