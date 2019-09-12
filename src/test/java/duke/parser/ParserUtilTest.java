package duke.parser;

import duke.tasks.Deadline;
import duke.tasks.Event;
import duke.tasks.Todo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import duke.command.*;

public class ParserUtilTest {

    @Test
    void createDeadline() {
        try {
            assertTrue(ParserUtil.createDeadline("deadline A-Exceptions /by tonight") instanceof Deadline);
        } catch (Exception e) {
            System.out.println("Fail");
        }
    }

    @Test
    void CreateEvent() {
        try {
            assertTrue(ParserUtil.createEvent("event Group meeting /at outside Lt7") instanceof Event);
        } catch (Exception e) {
            System.out.println("Fail");
        }
    }

    @Test
    void createTodo() {
        try {
            assertTrue(ParserUtil.createTodo("Level10") instanceof Todo);
        } catch (Exception e) {
            System.out.println("Fail");
        }
    }

    @Test
    void getIndex() {
        try {
            assertEquals(ParserUtil.getIndex("done 1"), 0);
        } catch (Exception e) {
            System.out.println("Fail");
        }
    }
}
