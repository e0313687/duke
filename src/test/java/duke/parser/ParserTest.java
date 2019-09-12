package duke.parser;
import org.junit.jupiter.api.Test;

import duke.command.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ParserTest {
    @Test
    void parse() {
        try{
            assertTrue(Parser.parse("deadline eat book /by 6pm") instanceof AddCommand);
            assertTrue(Parser.parse("event group meeting /at outside LT3") instanceof AddCommand);
            assertTrue(Parser.parse("todo work") instanceof AddCommand);
            assertTrue(Parser.parse("bye") instanceof ExitCommand);
            assertTrue(Parser.parse("list") instanceof ListCommand);
            assertTrue(Parser.parse("done 1") instanceof MarkAsDoneCommand);
        } catch (Exception e) {
            System.out.println("Fail");
        }
    }
}
