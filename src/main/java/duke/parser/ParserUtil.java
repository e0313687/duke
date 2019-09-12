package duke.parser;

import duke.exception.DukeException;
import duke.tasks.Deadline;
import duke.tasks.Event;
import duke.tasks.Todo;

/**
 * The ParserUtil class deals with utility functions.
 */
public class ParserUtil {
    /**
     * This parses the userInput and returns a new deadline constructed.
     *
     * @param userInput The userInput read by the user interface.
     * @return The new deadline.
     * @throws DukeException If input is invalid.
     */
    static Deadline createDeadline(String userInput) throws DukeException {
        String[] deadlineDetails = userInput.substring("deadline".length()).strip().split("/by");
        if ((deadlineDetails.length != 2) || (deadlineDetails[1] == null)) {
            System.out.println("Invalid format. Refer to help for command format.");
        }
        if (deadlineDetails[0].strip().isEmpty()) {
            System.out.println("Ah oh, the description cannot be empty.");
        }
        try {
            return new Deadline(deadlineDetails[0].strip(), ParserTime.parseStringToDate(deadlineDetails[1].strip()));
        } catch (DukeException e) {
            return new Deadline(deadlineDetails[0].strip(), deadlineDetails[1].strip());
        }
    }

    /**
     * This parses the userInput and returns a new event constructed.
     *
     * @param userInput The userInput read by the user interface.
     * @return The new event.
     * @throws DukeException If input is invalid.
     */
    static Event createEvent (String userInput) throws DukeException {
        String[] eventDetails = userInput.substring("event".length()).strip().split("/by");
        if (eventDetails.length != 2 || eventDetails[1] == null) {
            System.out.println("Invalid format. Refer to help for command format.");
        }
        if (eventDetails[0].strip().isEmpty()) {
            System.out.println("Ah oh, the description cannot be empty.");
        }
        try {
            return new Event(eventDetails[0].strip(), ParserTime.parseStringToDate(eventDetails[1].strip()));
        } catch (DukeException e) {
            return new Event(eventDetails[0].strip(), eventDetails[1].strip());
        }
    }

    /**
     * This parses the userInput and returns a new to-do constructed.
     *
     * @param userInput The userInput read by the user interface.
     * @return The new to-do.
     * @throws DukeException If input is invalid.
     */
    static Todo createTodo(String userInput) throws DukeException {
        String description = userInput.substring("todo".length()).strip();
        if (description.isEmpty()) {
            System.out.println("Ah oh, the description cannot be empty.");
        }
        return new Todo(description);
    }

    /**
     * This parses the userInput and returns an index extracted from it.
     *
     * @param userInput The userInput read by the user interface.
     * @return The index
     * @throws DukeException If input is invalid.
     */
    static int getIndex (String userInput) throws DukeException {
        try {
            int temp = Integer.parseInt(userInput.replaceAll("\\D+", ""));
            return temp-1;
        } catch (NumberFormatException e) {
            throw new DukeException("Invalid format. Refer to help for command format.");
        }
    }
}
