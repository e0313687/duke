package duke.command;

import duke.storage.Storage;
import duke.tasks.*;
import duke.ui.Ui;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AddCommandTest {
    @Test
    void execute() {
        Ui ui = new Ui();
        Storage storage = new Storage("duke.txt", ui);
        Task task = new Todo("homework");
        AddCommand addCommand = new AddCommand(task);
        addCommand.execute(ui, storage);
        assertTrue(storage.getTasks().contains(task));
    }
}
