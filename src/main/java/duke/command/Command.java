package duke.command;

import duke.exception.DukeException;
import duke.storage.Storage;
import duke.ui.Ui;

/**
 * An abstract class representing individual commands.
 */
public abstract class Command {

        /**
         * This command is executed on the user interface and the given task list.
         *
         * @param ui The user interface that displays tasks on the list.
         * @param storage The storage object that contains the list.
         * @throws DukeException
         */
        public abstract void execute(Ui ui, Storage storage) throws DukeException;
}
