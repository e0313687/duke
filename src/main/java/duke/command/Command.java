package duke.command;

import duke.exception.DukeException;
import duke.storage.Storage;
import duke.ui.Ui;

public abstract class Command {
        public abstract void execute(Ui ui, Storage storage) throws DukeException;
}
